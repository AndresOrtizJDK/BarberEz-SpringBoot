package com.barberez.api.controller;

import com.barberez.api.model.Barbero;
import com.barberez.api.service.BarberoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barberos")
public class BarberoController {

    private final BarberoService servicio;

    public BarberoController(BarberoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Barbero> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Barbero guardar(@RequestBody Barbero barbero) {
        return servicio.guardar(barbero);
    }
}
