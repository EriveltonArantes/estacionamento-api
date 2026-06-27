package com.estacionamentoapi.service;

import com.estacionamentoapi.dto.TabelaPrecoRequestDTO;
import com.estacionamentoapi.dto.TabelaPrecoResponseDTO;
import com.estacionamentoapi.exception.ResourceNotFoundException;
import com.estacionamentoapi.mapper.TabelaPrecoMapper;
import com.estacionamentoapi.model.TabelaPreco;
import com.estacionamentoapi.repository.TabelaPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TabelaPrecoService {

    @Autowired
    private TabelaPrecoRepository repository;

    @Autowired
    private TabelaPrecoMapper mapper;

    @Transactional(readOnly = true)
    public List<TabelaPrecoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TabelaPrecoResponseDTO buscar(Long id) {
        TabelaPreco entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("TabelaPreco não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public TabelaPrecoResponseDTO criar(TabelaPrecoRequestDTO dto) {
        TabelaPreco entity = mapper.toEntity(dto);
        TabelaPreco salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public TabelaPrecoResponseDTO atualizar(Long id, TabelaPrecoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TabelaPreco não encontrado com id: " + id);
        }
        TabelaPreco entity = mapper.toEntity(dto);
        entity.setId(id);
        TabelaPreco salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TabelaPreco não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
