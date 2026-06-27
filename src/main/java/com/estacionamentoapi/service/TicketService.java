package com.estacionamentoapi.service;

import com.estacionamentoapi.dto.TicketRequestDTO;
import com.estacionamentoapi.dto.TicketResponseDTO;
import com.estacionamentoapi.exception.ResourceNotFoundException;
import com.estacionamentoapi.mapper.TicketMapper;
import com.estacionamentoapi.model.Ticket;
import com.estacionamentoapi.repository.TicketRepository;
import com.estacionamentoapi.repository.VagaRepository;
import com.estacionamentoapi.model.Vaga;
import com.estacionamentoapi.repository.VeiculoRepository;
import com.estacionamentoapi.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketMapper mapper;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(readOnly = true)
    public List<TicketResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TicketResponseDTO buscar(Long id) {
        Ticket entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TicketResponseDTO criar(TicketRequestDTO dto) {
        Ticket entity = mapper.toEntity(dto);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Ticket salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TicketResponseDTO atualizar(Long id, TicketRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ticket não encontrado com id: " + id);
        }
        Ticket entity = mapper.toEntity(dto);
        entity.setId(id);
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + dto.getVagaId()));
        entity.setVaga(vaga);
        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + dto.getVeiculoId()));
        entity.setVeiculo(veiculo);
        Ticket salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ticket não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
