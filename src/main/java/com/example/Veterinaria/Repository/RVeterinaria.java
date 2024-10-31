package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Model.Veterinarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RVeterinaria extends JpaRepository<Veterinarios, Integer> {
}
