package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class AppCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
    private AppUser user;


}
