package com.obuvki.rest.Controller;

import com.obuvki.rest.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PutMapping("/addProductToCart")
    public void addProductToCart(@RequestParam("productId") long productId, @RequestParam("userId") long userId){
        cartService.addProductToCart(productId,userId);
    }

}
