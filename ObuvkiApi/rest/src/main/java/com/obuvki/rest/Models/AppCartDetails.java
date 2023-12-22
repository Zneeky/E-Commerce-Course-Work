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
    private AppCart cartid;

    @ManyToOne
    private AppProduct productid;

    private Integer quantity;
}