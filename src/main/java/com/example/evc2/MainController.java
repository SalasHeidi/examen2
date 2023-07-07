package com.example.evc2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("")
    public String alumno() {
        return "sm72784330 - Heidi Salas Rivera";
    }

    @GetMapping("idat/codigo")
    public String codigo() {
        return "sm72784330";
    }

    @GetMapping("idat/nombre-completo")
    public String nombre() {
        return "Heidi Salas Rivera";
    }

}
