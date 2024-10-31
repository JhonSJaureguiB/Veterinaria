package com.example.Veterinaria.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "propietario_id", referencedColumnName = "id")
    private Propietario propietario;

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Consultas> consultas = new HashSet<>();
}
