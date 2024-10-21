package com.example.Veterinaria.Controller;

import com.example.Veterinaria.InterfaceService.IPropietarioService;
import com.example.Veterinaria.Model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class PropietarioController {

    @Autowired
    private IPropietarioService service;

    @GetMapping("/listar")
    public String listarPropietarios(Model model){

        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "LISTA DE PROPIETARIOS");

        model.addAttribute("datos", service.listar());

        return "index";
    }

    @GetMapping("/nuevo")
    public String formAgregarPropietario(Model model){

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "PROPIETARIO NUEVO");
        model.addAttribute("prop", new Propietario());
        return "nuevo";
    }

    @GetMapping("/editar/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model){
        Optional<Propietario> optionalPropietario = service.editar(id);

        if (optionalPropietario.isPresent()){
            Propietario propietario= optionalPropietario.get();
            model.addAttribute("prop", propietario);
        }
        else {
            model.addAttribute("error", "Propietario no encontrado");
            return "error";
        }
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarPropietario(@ModelAttribute Propietario pro){
        service.guardar(pro);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPropietario(@PathVariable("id") int id){

        service.eliminar(id);

        return "redirect:/listar";

    }
}
