package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPropietario extends JpaRepository<Propietario, Integer> {
}
