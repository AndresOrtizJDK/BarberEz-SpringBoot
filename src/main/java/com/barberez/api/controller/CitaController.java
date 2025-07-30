package com.barberez.api.controller;

import com.barberez.api.model.Barbero;
import com.barberez.api.model.Cita;
import com.barberez.api.service.CitaService;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCita(@PathVariable Long id) {
        servicio.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita nuevosDatos) {
        Cita actualizado = servicio.actualizar(id, nuevosDatos);
        return ResponseEntity.ok(actualizado);
    }
}
