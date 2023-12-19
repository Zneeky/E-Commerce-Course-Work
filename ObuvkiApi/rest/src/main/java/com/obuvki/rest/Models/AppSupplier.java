package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplierid")
    private  long supplierid;

    @Column(name="supplier_name")
    private  String supplierName;

    @Column(name="phone_number")
    private  String phoneNumber;
}
