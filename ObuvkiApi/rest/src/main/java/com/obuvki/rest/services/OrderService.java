package com.obuvki.rest.services;

import com.obuvki.rest.Models.AppOrder;

import java.util.List;

public interface OrderService {
    long createOrder(long userId, long supplierId);
    List<AppOrder> getAllOrders(long userId);
}
