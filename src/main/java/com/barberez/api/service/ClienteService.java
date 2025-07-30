package com.barberez.api.service;

import com.barberez.api.model.Cliente;
import com.barberez.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repositorio;

    public ClienteService(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    public Cliente guardar(Cliente usuario) {
        return repositorio.save(usuario);
    }
}