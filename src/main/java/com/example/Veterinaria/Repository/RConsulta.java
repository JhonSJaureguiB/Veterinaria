package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Model.Consultas;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Veterinarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RConsulta extends JpaRepository<Consultas, Integer> {
}
