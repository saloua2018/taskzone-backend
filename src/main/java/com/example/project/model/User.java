package com.example.project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;
    public String password;
    public String role;

    @OneToMany(mappedBy = "user")
    public List<Projet> projets;
}
