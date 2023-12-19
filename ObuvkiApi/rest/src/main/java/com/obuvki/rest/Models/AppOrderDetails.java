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
    private AppOrder orderid;

    @ManyToOne
    private AppProduct productid;

    @Column
    private Integer quantity;
}