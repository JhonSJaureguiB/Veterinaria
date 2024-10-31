package com.example.Veterinaria.Controller;

import com.example.Veterinaria.InterfaceService.IMascotaService;
import com.example.Veterinaria.InterfaceService.IPropietarioService;
import com.example.Veterinaria.Model.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    private IMascotaService service;
    @Autowired
    private IPropietarioService pservice;

    @GetMapping("/listar")
    public String listarMascotas(Model model){
        model.addAttribute("titulo", "listar mascotas");
        model.addAttribute("mascotas", service.listar());
        return "mascota/index";
    }


    @GetMapping("/nuevo")
    public String formAgregarMascota(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "MASCOTA NUEVA");
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", pservice.listar());
        return "mascota/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        service.guardar(mascota);
        return "redirect:/mascota/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") int id, Model model) {
        if (service.editar(id).orElse(null) != null) {
            LocalDate fechaNacimiento = service.editar(id).orElse(null).getFecha_nacimiento();
            model.addAttribute("fecha_nacimiento", fechaNacimiento != null ? fechaNacimiento.toString() : null);
        }
        model.addAttribute("mascota", service.editar(id).orElse(null));
        model.addAttribute("propietarios", pservice.listar());
        return "mascota/nuevo";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/mascota/listar";
    }
}
