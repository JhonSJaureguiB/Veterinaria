package com.example.Veterinaria.InterfaceService;

import com.example.Veterinaria.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {

    public List<Propietario> listar();

    public void guardar(Propietario prop);

    public Optional<Propietario> editar(int id);

    public void eliminar(int id);

}
