package com.barberez.api.service;

import com.barberez.api.model.Barbero;
import com.barberez.api.model.Cita;
import com.barberez.api.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository repositorio;

    public CitaService(CitaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public List<Cita> listar() {
        return repositorio.findAll();
    }

    public Cita guardar(Cita cita) {
        return repositorio.save(cita);
    }

    public void eliminar(Long id) {repositorio.deleteById(id);}

    public Optional<Cita> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }
}
