package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private  long userid;

    @Column(name="email")
    private  String email;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private  String username;

    @OneToMany(mappedBy = "userid")
    private Set<AppOrder> orders;

    @OneToOne(mappedBy = "userid")
    private AppCart cartUser;
}
