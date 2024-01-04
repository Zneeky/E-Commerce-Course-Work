package com.obuvki.rest.Controller;

import com.obuvki.rest.DTO.ProductDTOs.ExportCartDto;
import com.obuvki.rest.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PutMapping("/addProductToCart")
    public void addProductToCart(@RequestParam("productId") long productId, @RequestParam("userId") long userId){
        cartService.addProductToCart(productId,userId);
    }

    @GetMapping("/{userId}")
    public List<ExportCartDto> getAllCartProducts(@PathVariable long userId){
        return cartService.getCartProducts(userId);
    }
    @DeleteMapping("/deleteInCart")
    public void deleteProductInCart(@RequestParam("productId") long productId, @RequestParam("userId") long userId){
        cartService.deleteProductInCart(productId, userId);
    }

    @DeleteMapping("/deleteAllInCart")
    public void deleteAllInCart(@RequestParam("userId") long userId){
        cartService.deleteAllProducts(userId);
    }

    @PatchMapping("/addQuantity")
    public void addQuantityToProduct(@RequestParam("productId") long productId, @RequestParam("userId") long userId){
        cartService.increaseProductQuantity(productId, userId);
    }

    @PatchMapping("/decreaseQuantity")
    public void decreaseQuantityToProduct(@RequestParam("productId") long productId, @RequestParam("userId") long userId){
        cartService.decreaseProductQuantity(productId, userId);
    }
}
