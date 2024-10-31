package com.example.Veterinaria.Service;

import com.example.Veterinaria.InterfaceService.IConsultaService;
import com.example.Veterinaria.Model.Consultas;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Veterinarios;
import com.example.Veterinaria.Repository.RConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsultaService {
    @Autowired
    private RConsulta repositorio;

    @Override
    public List<Consultas> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Consultas consultas) {
        repositorio.save(consultas);
    }

    @Override
    public Optional<Consultas> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
    repositorio.deleteById(id);
    }

}
