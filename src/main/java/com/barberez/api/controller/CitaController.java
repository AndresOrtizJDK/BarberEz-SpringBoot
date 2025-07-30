package com.barberez.api.controller;

import com.barberez.api.model.Cita;
import com.barberez.api.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private CitaService servicio;

    public CitaController(CitaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Cita> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Cita guardar(@RequestBody Cita cita) {
        return servicio.guardar(cita);
    }

}
