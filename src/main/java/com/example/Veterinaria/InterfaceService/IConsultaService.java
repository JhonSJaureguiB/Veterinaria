package com.example.Veterinaria.InterfaceService;

import com.example.Veterinaria.Model.Consultas;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Veterinarios;

import java.util.List;
import java.util.Optional;

public interface IConsultaService {
    List<Consultas> listar();
    void guardar(Consultas consultas);
    Optional<Consultas> editar(int id);
    void eliminar(int id);
}
