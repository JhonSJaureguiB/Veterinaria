package com.example.Veterinaria.Controller;

import com.example.Veterinaria.InterfaceService.IVeterinarioService;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Model.Propietario;
import com.example.Veterinaria.Model.Veterinarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    private IVeterinarioService service;

    @GetMapping("/listar")
    public String listarVeterinarios(Model model){
        model.addAttribute("titulo","Listar veterinarios");
        model.addAttribute("veterinarios", service.listar());
        return "veterinario/index";
    }

    @GetMapping("/nuevo")
    public String formAgregarMascota(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "VETERINARIO NUEVO");
        model.addAttribute("veterinario", new Veterinarios());
        return "veterinario/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Veterinarios veterinarios) {
        service.guardar(veterinarios);
        return "redirect:/veterinario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model){
        Optional<Veterinarios> optionalVeterinarios = service.editar(id);

        if (optionalVeterinarios.isPresent()){
            Veterinarios veterinarios= optionalVeterinarios.get();
            model.addAttribute("veterinario", veterinarios);
        }
        else {
            model.addAttribute("error", "Veterinario no encontrado");
            return "error";
        }
        return "veterinario/nuevo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVeterinario(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/veterinario/listar";

    }
}
