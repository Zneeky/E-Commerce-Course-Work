package com.obuvki.rest.Controller;

import com.obuvki.rest.DTO.ProductDTOs.ExportCartDto;
import com.obuvki.rest.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class CartController {
    private final CartService cartService;
    @PutMapping("/addProductToCart/{productId}/{userId}")
    public void addProductToCart(@PathVariable long productId, @PathVariable long userId){
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

    @PatchMapping("/addQuantity/{productId}/{userId}")
    public void addQuantityToProduct(@PathVariable long productId, @PathVariable long userId){
        cartService.increaseProductQuantity(productId, userId);
    }

    @PatchMapping("/decreaseQuantity/{productId}/{userId}")
    public void decreaseQuantityToProduct(@PathVariable long productId, @PathVariable long userId){
        cartService.decreaseProductQuantity(productId, userId);
    }
}
