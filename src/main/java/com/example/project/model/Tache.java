package com.example.project.model;

import jakarta.persistence.*;

@Entity
public class Tache {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String titre;

    @ManyToOne
    public Projet projet;
}
