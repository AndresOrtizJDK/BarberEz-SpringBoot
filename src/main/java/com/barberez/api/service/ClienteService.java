package com.barberez.api.service;

import com.barberez.api.model.Barbero;
import com.barberez.api.model.Cliente;
import com.barberez.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void eliminar(Long id) {repositorio.deleteById(id);}

    public Optional<Cliente> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }
}