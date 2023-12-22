package com.obuvki.rest.services;

import com.obuvki.rest.Models.AppUser;

public interface CartService {
    void addProductToCart(long productId, long userId);

    void createCart(AppUser user);
}
