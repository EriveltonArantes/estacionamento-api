package com.estacionamentoapi.mapper;

import com.estacionamentoapi.dto.TabelaPrecoRequestDTO;
import com.estacionamentoapi.dto.TabelaPrecoResponseDTO;
import com.estacionamentoapi.model.TabelaPreco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TabelaPrecoMapper {

    TabelaPreco toEntity(TabelaPrecoRequestDTO dto);

    TabelaPrecoResponseDTO toResponseDTO(TabelaPreco entity);
}
