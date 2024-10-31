package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Model.Mascota;

import com.example.Veterinaria.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RMascota extends JpaRepository<Mascota, Integer> {
}
