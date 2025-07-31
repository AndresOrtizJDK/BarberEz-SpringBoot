package com.barberez.api.repository;

import com.barberez.api.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByBarberoIdAndFecha(Long barberoId, LocalDate fecha);

}
