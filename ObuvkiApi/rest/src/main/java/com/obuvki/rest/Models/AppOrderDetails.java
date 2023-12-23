package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppOrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
    @ManyToOne
    @JoinColumn(name="order_id")
    private AppOrder order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private AppProduct product;

    @Column
    private Integer quantity;
}