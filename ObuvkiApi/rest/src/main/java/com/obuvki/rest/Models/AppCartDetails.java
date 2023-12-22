package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class AppCartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private AppCart cart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private AppProduct product;

    private Integer quantity;
}