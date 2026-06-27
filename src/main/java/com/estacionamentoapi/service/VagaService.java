package com.estacionamentoapi.service;

import com.estacionamentoapi.dto.VagaRequestDTO;
import com.estacionamentoapi.dto.VagaResponseDTO;
import com.estacionamentoapi.exception.ResourceNotFoundException;
import com.estacionamentoapi.mapper.VagaMapper;
import com.estacionamentoapi.model.Vaga;
import com.estacionamentoapi.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VagaService {

    @Autowired
    private VagaRepository repository;

    @Autowired
    private VagaMapper mapper;

    @Transactional(readOnly = true)
    public List<VagaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VagaResponseDTO buscar(Long id) {
        Vaga entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vaga não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public VagaResponseDTO criar(VagaRequestDTO dto) {
        Vaga entity = mapper.toEntity(dto);
        Vaga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public VagaResponseDTO atualizar(Long id, VagaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vaga não encontrado com id: " + id);
        }
        Vaga entity = mapper.toEntity(dto);
        entity.setId(id);
        Vaga salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vaga não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
