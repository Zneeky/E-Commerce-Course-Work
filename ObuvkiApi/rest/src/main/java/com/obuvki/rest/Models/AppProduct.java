package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  long id;

    @Column(name="product_name")
    private  String productName;

    @Column(name="price")
    private  float price;

    @Column(name="size")
    private  String size;

    @Column(name="color")
    private  String color;

    @Column(name="brand")
    private  String brand;

    @Column(name="image_url")
    private  String imageURL;

}