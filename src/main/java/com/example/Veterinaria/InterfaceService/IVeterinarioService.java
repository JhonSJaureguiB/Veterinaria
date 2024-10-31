package com.example.Veterinaria.InterfaceService;

import com.example.Veterinaria.Model.Veterinarios;

import java.util.List;
import java.util.Optional;

public interface IVeterinarioService {
    List<Veterinarios> listar();
    void guardar(Veterinarios veterinarios);
    Optional<Veterinarios> editar(int id);
    void eliminar(int id);

}
