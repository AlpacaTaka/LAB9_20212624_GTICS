package com.example.lab9_20212624_gtics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/test2")
    public String test2(Model model) {
        // Agregar datos de ejemplo para la página de test
        model.addAttribute("titulo", "Gestión Deportiva - Página de Test 2");
        model.addAttribute("fechaActual", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        // Lista de deportes de ejemplo
        List<String> deportes = new ArrayList<>();
        deportes.add("Fútbol");
        deportes.add("Básquetbol");
        deportes.add("Voleibol");
        deportes.add("Tenis");
        deportes.add("Natación");
        model.addAttribute("deportes", deportes);

        // Lista de equipos de ejemplo
        List<String> equipos = new ArrayList<>();
        equipos.add("Real Madrid");
        equipos.add("Barcelona");
        equipos.add("Manchester United");
        equipos.add("Bayern Munich");
        model.addAttribute("equipos", equipos);

        return "test2";
    }

    @PostMapping("/test2/procesar")
    public String procesarFormulario(@RequestParam("nombre") String nombre,
                                   @RequestParam("deporte") String deporte,
                                   @RequestParam("equipo") String equipo,
                                   @RequestParam(value = "comentarios", required = false) String comentarios,
                                   Model model) {

        // Procesar los datos del formulario
        model.addAttribute("titulo", "Resultado del Formulario");
        model.addAttribute("nombreJugador", nombre);
        model.addAttribute("deporteSeleccionado", deporte);
        model.addAttribute("equipoSeleccionado", equipo);
        model.addAttribute("comentariosJugador", comentarios != null ? comentarios : "Sin comentarios");
        model.addAttribute("fechaProcesamiento", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        return "test2-resultado";
    }

}
