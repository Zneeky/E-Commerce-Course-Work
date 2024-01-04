package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;
@Entity
@Data
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="total_amount")
    private Double totalAmount;

    @Column(name="order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private AppSupplier supplier;

}
