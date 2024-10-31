package com.example.Veterinaria.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name= "veterinario")
public class Veterinarios {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String especialidad;

    private String telefono;

    @OneToMany(mappedBy = "veterinarios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Consultas> consultas = new HashSet<>();

}
