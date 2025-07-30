package com.barberez.api.service;

import com.barberez.api.model.Barbero;
import com.barberez.api.model.Cita;
import com.barberez.api.model.Cliente;
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
    public Cita actualizar(Long id, Cita nuevosDatos) {
        return repositorio.findById(id).map(cita -> {
            cita.setBarbero(nuevosDatos.getBarbero());
            cita.setCliente(nuevosDatos.getCliente());
            cita.setEstado(nuevosDatos.getEstado());
            cita.setFecha(nuevosDatos.getFecha());
            cita.setHora(nuevosDatos.getHora());
            return repositorio.save(cita);
        }).orElseThrow(() -> new RuntimeException("Cita no encontrado con ID: " + id));
    }
}
