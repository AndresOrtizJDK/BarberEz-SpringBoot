package com.barberez.api.controller;

import com.barberez.api.model.Barbero;
import com.barberez.api.model.Cliente;
import com.barberez.api.service.ClienteService;

import com.barberez.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService servicio;

    public ClienteController(ClienteService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Cliente> listar() {
        return servicio.listar();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return servicio.guardar(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarBarbero(@PathVariable Long id) {
        servicio.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) {
        return servicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente nuevosDatos) {
        Cliente actualizado = servicio.actualizar(id, nuevosDatos);
        return ResponseEntity.ok(actualizado);
    }

}