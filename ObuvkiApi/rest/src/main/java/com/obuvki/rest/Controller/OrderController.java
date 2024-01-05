package com.obuvki.rest.Controller;

import com.obuvki.rest.Models.AppOrder;
import com.obuvki.rest.services.CartService;
import com.obuvki.rest.services.OrderService;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create/{userId}/{supplierId}")
    public ResponseEntity<Long> createOrder(@PathVariable long userId, @PathVariable long supplierId){
        return ResponseEntity.ok(orderService.createOrder(userId, supplierId));
    }
    @GetMapping("/get")
    public ResponseEntity<List<AppOrder>> getUserOrders(@RequestParam("userId") long userId){
        return ResponseEntity.ok(orderService.getAllOrders(userId));
    }
}
