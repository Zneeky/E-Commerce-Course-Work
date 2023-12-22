package com.obuvki.rest.services.impl;

import com.obuvki.rest.DTO.ProductDTOs.ExportCartDto;
import com.obuvki.rest.Models.AppCart;
import com.obuvki.rest.Models.AppCartDetails;
import com.obuvki.rest.Models.AppProduct;
import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.repository.CartDetailsRepository;
import com.obuvki.rest.repository.CartRepository;
import com.obuvki.rest.repository.ProductRepository;
import com.obuvki.rest.services.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

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
    public void increaseProductQuantity(long productId, long userId){
        AppCart cart = cartRepository.findByUserId(userId);
        AppCartDetails cartDetails = cartDetailsRepository.findByProductIdAndCartId(productId, cart.getId());
        cartDetails.setQuantity(cartDetails.getQuantity() + 1);
        cartDetailsRepository.save(cartDetails);
    }
    @Transactional
    public void decreaseProductQuantity(long productId, long userId){
        AppCart cart = cartRepository.findByUserId(userId);
        AppCartDetails cartDetails = cartDetailsRepository.findByProductIdAndCartId(productId, cart.getId());
        if (cartDetails.getQuantity() == 1){
            deleteProductInCart(productId, userId);
            return;
        }

        cartDetails.setQuantity(cartDetails.getQuantity() - 1);
        cartDetailsRepository.save(cartDetails);
    }
    public void createCart(AppUser user){
        AppCart cart = new AppCart();
        cart.setUser(user);

        cartRepository.save(cart);
    }

    public List<ExportCartDto> getCartProducts(long userId) {
        AppCart cart = cartRepository.findByUserId(userId);
        List<AppCartDetails> cartDetails = cartDetailsRepository.findByCartId(cart.getId());
        List<AppProduct> products = productRepository.findAppProductByIdIn(
                cartDetails.stream()
                        .map(cartDetail -> cartDetail.getProduct().getId())
                        .collect(Collectors.toList())
        );

        List<ExportCartDto> cartDtos = new ArrayList<>();

        for (int i=0;i<cartDetails.size();i++)
        {
            ExportCartDto exportCartDto = new ExportCartDto();
            exportCartDto.setId(products.get(i).getId());
            exportCartDto.setSize(products.get(i).getSize());
            exportCartDto.setPrice(products.get(i).getPrice());
            exportCartDto.setProductName(products.get(i).getProductName());
            exportCartDto.setImageURL(products.get(i).getImageURL());
            exportCartDto.setQuantity(cartDetails.get(i).getQuantity());
            cartDtos.add(exportCartDto);
        }

        return cartDtos;
    }
    @Transactional
    public void deleteProductInCart(long productId, long userId)
    {
        AppCart cart = cartRepository.findByUserId(userId);
        cartDetailsRepository.deleteByProductIdAndCartId(productId, cart.getId());
    }
    @Transactional
    public void deleteAllProducts(long userId){
        AppCart cart = cartRepository.findByUserId(userId);
        cartDetailsRepository.deleteByCartId(cart.getId());
    }
}
