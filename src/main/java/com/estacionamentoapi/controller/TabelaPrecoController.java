package com.estacionamentoapi.controller;

import com.estacionamentoapi.dto.TabelaPrecoRequestDTO;
import com.estacionamentoapi.dto.TabelaPrecoResponseDTO;
import com.estacionamentoapi.service.TabelaPrecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "TabelaPreco", description = "Gerenciamento de tabelaprecos")
@RestController
@RequestMapping("/api/tabelaprecos")
public class TabelaPrecoController {

    @Autowired
    private TabelaPrecoService service;

    @Operation(summary = "Listar todos os TabelaPreco")
    @GetMapping
    public List<TabelaPrecoResponseDTO> listar(@RequestParam(required = false) String tipo) {
        List<TabelaPrecoResponseDTO> resultado = service.listar();
        if (tipo != null && !tipo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipo() != null &&
                item.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar TabelaPreco por ID")
    @GetMapping("/{id}")
    public TabelaPrecoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar TabelaPreco")
    @PostMapping
    public ResponseEntity<TabelaPrecoResponseDTO> criar(@Valid @RequestBody TabelaPrecoRequestDTO tabelaPreco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(tabelaPreco));
    }

    @Operation(summary = "Atualizar TabelaPreco")
    @PutMapping("/{id}")
    public TabelaPrecoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TabelaPrecoRequestDTO tabelaPreco) {
        return service.atualizar(id, tabelaPreco);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir TabelaPreco")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
