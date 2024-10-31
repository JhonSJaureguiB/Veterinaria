package com.example.Veterinaria.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "consulta")
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name= "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    @ManyToOne()
    @JoinColumn(name= "veterinario_id", referencedColumnName = "id")
    private Veterinarios veterinarios;

    private LocalDate fecha_consulta;

    private String motivo;

    private String diagnostico;
}
