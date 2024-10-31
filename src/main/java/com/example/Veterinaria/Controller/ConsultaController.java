package com.example.Veterinaria.Controller;

import com.example.Veterinaria.InterfaceService.IConsultaService;
import com.example.Veterinaria.InterfaceService.IMascotaService;
import com.example.Veterinaria.InterfaceService.IVeterinarioService;
import com.example.Veterinaria.Model.Consultas;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Veterinarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private IConsultaService service;
    @Autowired
    private IMascotaService mascotaService;
    @Autowired
    private IVeterinarioService veterinarioService;

    @GetMapping("/listar")
    public String listarConsultas(Model model){
        model.addAttribute("titulo", "listar consultas");
        model.addAttribute("consulta", service.listar());
        return "consulta/index";
    }

    @GetMapping("/nuevo")
    public String formAgregarConsulta(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "COUNSULTA NUEVA");
        model.addAttribute("consulta", new Consultas());
        model.addAttribute("mascota", mascotaService.listar());
        model.addAttribute("veterinario", veterinarioService.listar());
        return "consulta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarConsulta(@ModelAttribute Consultas consulta) {
        service.guardar(consulta);
        return "redirect:/consulta/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarConsultas(@PathVariable("id") int id, Model model){
        Optional<Consultas> optionalConsultas = service.editar(id);

        if (optionalConsultas.isPresent()){
            Consultas consultas= optionalConsultas.get();
            model.addAttribute("consulta", consultas);
            model.addAttribute("veterinario",veterinarioService.listar());
            model.addAttribute("mascota", mascotaService.listar());
        }
        else {
            model.addAttribute("error", "Consulta no encontrada");
            return "error";
        }
        return "consulta/nuevo";

    }
    @GetMapping("/eliminar/{id}")
    public String eliminarConsulta(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/consulta/listar";
    }

}
