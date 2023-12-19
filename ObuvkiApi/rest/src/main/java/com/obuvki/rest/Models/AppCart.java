package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class AppCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long cartid;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", unique = true)
    private AppUser userid;

    @OneToMany(mappedBy = "cartid")
    private List<AppCartDetails> cartDetailsList;

}
