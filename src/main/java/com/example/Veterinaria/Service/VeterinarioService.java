package com.example.Veterinaria.Service;

import com.example.Veterinaria.InterfaceService.IVeterinarioService;
import com.example.Veterinaria.Model.Veterinarios;
import com.example.Veterinaria.Repository.RVeterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService implements IVeterinarioService {
    @Autowired
    private RVeterinaria repositorio;

    @Override
    public List<Veterinarios> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Veterinarios veterinarios) {
        repositorio.save(veterinarios);
    }

    @Override
    public Optional<Veterinarios> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
