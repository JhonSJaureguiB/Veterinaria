package com.example.Veterinaria.InterfaceService;

import com.example.Veterinaria.Model.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    List<Mascota> listar();
    public void guardar(Mascota mascota);
    Optional<Mascota> editar(int id);
    public void eliminar(int id);
}
