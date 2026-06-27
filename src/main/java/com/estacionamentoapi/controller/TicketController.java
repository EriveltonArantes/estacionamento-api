package com.estacionamentoapi.controller;

import com.estacionamentoapi.dto.TicketRequestDTO;
import com.estacionamentoapi.dto.TicketResponseDTO;
import com.estacionamentoapi.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Ticket", description = "Gerenciamento de tickets")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    @Operation(summary = "Listar todos os Ticket")
    @GetMapping
    public List<TicketResponseDTO> listar(@RequestParam(required = false) Long vagaId, @RequestParam(required = false) Long veiculoId) {
        List<TicketResponseDTO> resultado = service.listar();
        if (vagaId != null) {
            resultado = resultado.stream().filter(item -> vagaId.equals(item.getVagaId())).collect(java.util.stream.Collectors.toList());
        }
        if (veiculoId != null) {
            resultado = resultado.stream().filter(item -> veiculoId.equals(item.getVeiculoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Ticket por ID")
    @GetMapping("/{id}")
    public TicketResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Ticket")
    @PostMapping
    public ResponseEntity<TicketResponseDTO> criar(@Valid @RequestBody TicketRequestDTO ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(ticket));
    }

    @Operation(summary = "Atualizar Ticket")
    @PutMapping("/{id}")
    public TicketResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TicketRequestDTO ticket) {
        return service.atualizar(id, ticket);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Ticket")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
