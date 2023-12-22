package com.obuvki.rest.services.impl;

import com.obuvki.rest.Models.AppCart;
import com.obuvki.rest.Models.AppCartDetails;
import com.obuvki.rest.Models.AppProduct;
import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.repository.CartDetailsRepository;
import com.obuvki.rest.repository.CartRepository;
import com.obuvki.rest.repository.ProductRepository;
import com.obuvki.rest.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private  final CartRepository cartRepository;
    private  final ProductRepository productRepository;
    private  final CartDetailsRepository cartDetailsRepository;
    public void addProductToCart(long productId, long userId){
        Optional<AppProduct> product = productRepository.findById(productId);
        AppCart cart = cartRepository.findByUserId(userId);
        AppCartDetails cartDetails = new AppCartDetails();
        cartDetails.setCart(cart);
        cartDetails.setProduct(product.get());
        cartDetails.setQuantity(1);
        cartDetailsRepository.save(cartDetails);
    }

    public void createCart(AppUser user){
        AppCart cart = new AppCart();
        cart.setUser(user);

        cartRepository.save(cart);
    }
}
