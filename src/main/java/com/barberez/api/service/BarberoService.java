package com.barberez.api.service;

import com.barberez.api.model.Barbero;
import com.barberez.api.repository.BarberoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberoService {

    private final BarberoRepository repositorio;

    public BarberoService(BarberoRepository barberoRepository) {
        this.repositorio = barberoRepository;
    }

    public List<Barbero> listar() {
        return repositorio.findAll();
    }

    public Barbero guardar(Barbero barbero) {
        return repositorio.save(barbero);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public Optional<Barbero> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

}
