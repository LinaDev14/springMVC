package com.example.springmvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {

        var mensaje = "Adios mundo con Thymeleaf";

        var persona = new Persona();

        persona.setNombre("Santiago");
        persona.setApellido("Vlad");
        persona.setEmail("santiagoVlad@gmail.com");
        persona.setCelular("3215689651");

        var persona2 = new Persona();

        persona2.setNombre("Mateo");
        persona2.setApellido("Vlad");
        persona2.setEmail("MateoVlad@gmail.com");
        persona2.setCelular("3215679651");

        var personas = Arrays.asList(persona, persona2);

        log.info("Ejecutando el controlador Spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
