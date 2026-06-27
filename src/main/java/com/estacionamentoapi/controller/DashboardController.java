package com.estacionamentoapi.controller;

import com.estacionamentoapi.model.Vaga;
import com.estacionamentoapi.model.Veiculo;
import com.estacionamentoapi.model.Ticket;
import com.estacionamentoapi.model.TabelaPreco;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.estacionamentoapi.repository.VagaRepository vagaRepository;

    @Autowired
    private com.estacionamentoapi.repository.VeiculoRepository veiculoRepository;

    @Autowired
    private com.estacionamentoapi.repository.TicketRepository ticketRepository;

    @Autowired
    private com.estacionamentoapi.repository.TabelaPrecoRepository tabelaPrecoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalVaga", vagaRepository.count());
        resumo.put("somaNumeroVaga", vagaRepository.findAll().stream().filter(e -> e.getNumero() != null).mapToInt(e -> e.getNumero()).sum());
        resumo.put("totalVeiculo", veiculoRepository.count());
        resumo.put("totalTicket", ticketRepository.count());
        resumo.put("somaValorTotalTicket", ticketRepository.findAll().stream().filter(e -> e.getValorTotal() != null).mapToDouble(e -> e.getValorTotal()).sum());
        resumo.put("graficoTicket", ticketRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalTabelaPreco", tabelaPrecoRepository.count());
        resumo.put("somaValorHoraTabelaPreco", tabelaPrecoRepository.findAll().stream().filter(e -> e.getValorHora() != null).mapToDouble(e -> e.getValorHora()).sum());
        return resumo;
    }
}
