package com.obuvki.rest.services;

import com.obuvki.rest.DTO.ProductDTOs.ExportCartDto;
import com.obuvki.rest.Models.AppUser;

import java.util.List;

public interface CartService {
    void addProductToCart(long productId, long userId);
    void increaseProductQuantity(long productId, long userId);
    void decreaseProductQuantity(long productId, long userId);

    void createCart(AppUser user);

    void deleteProductInCart(long productId, long userId);
    List<ExportCartDto> getCartProducts(long userId);

    void deleteAllProducts(long userId);
}
