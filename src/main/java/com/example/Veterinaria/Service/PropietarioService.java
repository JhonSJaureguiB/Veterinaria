package com.example.Veterinaria.Service;

import com.example.Veterinaria.InterfaceService.IPropietarioService;
import com.example.Veterinaria.Model.Propietario;
import com.example.Veterinaria.Repository.RPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService implements IPropietarioService {
    @Autowired
    private RPropietario repositorio;

    @Override
    public List<Propietario> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Propietario pro) {
        repositorio.save(pro);
    }

    @Override
    public Optional<Propietario> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {

        repositorio.deleteById(id);

    }
}
