package com.barberez.api.controller;

import com.barberez.api.model.Cliente;
import com.barberez.api.service.ClienteService;

import com.barberez.api.*;
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
}