package com.barberez.api.controller;

import com.barberez.api.model.Barbero;
import com.barberez.api.service.BarberoService;

import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/eliminar/{id}")
    public void eliminarBarbero(@PathVariable Long id) {
        servicio.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Barbero> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Barbero> actualizarBarbero(@PathVariable Long id, @RequestBody Barbero nuevosDatos) {
        Barbero actualizado = servicio.actualizar(id, nuevosDatos);
        return ResponseEntity.ok(actualizado);
    }


}
