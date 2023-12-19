package com.obuvki.rest.Models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column
    private  String email;

    @Column
    private String password;

    @Column
    private  String firstName;

    @Column
    private  String lastName;

    @Column
    private  int age;
}
