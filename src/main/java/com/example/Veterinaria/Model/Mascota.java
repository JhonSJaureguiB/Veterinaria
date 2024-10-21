package com.example.Veterinaria.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String especie;
    private String raza;
    private Date fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "propietario_id", referencedColumnName = "id")
    private Propietario propietario;
}
