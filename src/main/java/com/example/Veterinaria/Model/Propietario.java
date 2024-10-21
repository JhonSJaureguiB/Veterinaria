package com.example.Veterinaria.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String direccion;

    private String telefono;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Mascota> mascotas = new HashSet<>();
}
