package com.estacionamentoapi.repository;

import com.estacionamentoapi.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
