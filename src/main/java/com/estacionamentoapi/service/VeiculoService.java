package com.estacionamentoapi.service;

import com.estacionamentoapi.dto.VeiculoRequestDTO;
import com.estacionamentoapi.dto.VeiculoResponseDTO;
import com.estacionamentoapi.exception.ResourceNotFoundException;
import com.estacionamentoapi.mapper.VeiculoMapper;
import com.estacionamentoapi.model.Veiculo;
import com.estacionamentoapi.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private VeiculoMapper mapper;

    @Transactional(readOnly = true)
    public List<VeiculoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VeiculoResponseDTO buscar(Long id) {
        Veiculo entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public VeiculoResponseDTO criar(VeiculoRequestDTO dto) {
        Veiculo entity = mapper.toEntity(dto);
        Veiculo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Veiculo não encontrado com id: " + id);
        }
        Veiculo entity = mapper.toEntity(dto);
        entity.setId(id);
        Veiculo salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Veiculo não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
