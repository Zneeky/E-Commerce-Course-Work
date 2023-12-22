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
    @Column(name="orderid")
    private Long orderid;

    @Column(name="total_amount")
    private Double totalAmount;

    @Column(name="order_date")
    private Date orderDate;

    @ManyToOne
    private AppUser userid;

    @ManyToOne
    private AppSupplier supplierid;

    @OneToMany(mappedBy = "orderid")
    private List<AppOrderDetails> orderDetails;
}
