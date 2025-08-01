package com.example.project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nom;

    @ManyToOne
    public User user;

    @OneToMany(mappedBy = "projet")
    public List<Tache> taches;
}
