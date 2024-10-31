package com.example.Veterinaria.Service;

import com.example.Veterinaria.InterfaceService.IMascotaService;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Propietario;
import com.example.Veterinaria.Repository.RMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private RMascota repositorio;

    @Override
    public List<Mascota> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascota mascota) {
        repositorio.save(mascota);
    }

    @Override
    public Optional<Mascota> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

}
