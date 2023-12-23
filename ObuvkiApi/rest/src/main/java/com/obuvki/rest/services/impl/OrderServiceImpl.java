package com.obuvki.rest.services.impl;

import com.obuvki.rest.Models.*;
import com.obuvki.rest.repository.*;
import com.obuvki.rest.services.CartService;
import com.obuvki.rest.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private  final OrderRepository orderRepository;
    private  final CartRepository cartRepository;
    private  final UserRepository userRepository;
    private  final CartDetailsRepository cartDetailsRepository;
    private  final ProductRepository productRepository;
    private  final SupplierRepository supplierRepository;
    private  final OrderDetailsRepository orderDetailsRepository;
    @Transactional
    public long createOrder(long userId, long supplierId){
        AppUser user = userRepository.findById(userId).get();
        AppCart cart = cartRepository.findByUserId(userId);
        List<AppCartDetails> cartDetails = cartDetailsRepository.findByCartId(cart.getId());
        List<AppProduct> products = productRepository.findAppProductByIdIn(
                cartDetails.stream()
                        .map(cartDetail -> cartDetail.getProduct().getId())
                        .collect(Collectors.toList())
        );



        AppSupplier supplier = supplierRepository.findById(supplierId).get();

        double price = 0;
        for (AppProduct product : products) {
            price += product.getPrice();
        }

        AppOrder order = new AppOrder();
        order.setOrderDate(new Date());
        order.setSupplier(supplier);
        order.setUser(user);
        order.setTotalAmount(price);
        orderRepository.save(order);

        List<AppOrderDetails> orderProducts = new ArrayList<>();
        for (int i = 0;i<cartDetails.size();i++){
            AppOrderDetails details = new AppOrderDetails();
            details.setOrder(order);
            details.setProduct(cartDetails.get(i).getProduct());
            details.setQuantity(cartDetails.get(i).getQuantity());
            orderProducts.add(details);
        }
        orderDetailsRepository.saveAll(orderProducts);

        cartDetailsRepository.deleteByCartId(cart.getId());

        return order.getId();
    }
    public List<AppOrder> getAllOrders(long userId){
        return orderRepository.findByUserId(userId);
    }

}
