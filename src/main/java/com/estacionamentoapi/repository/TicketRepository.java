package com.estacionamentoapi.repository;

import com.estacionamentoapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
