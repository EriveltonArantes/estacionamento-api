package com.estacionamentoapi.mapper;

import com.estacionamentoapi.dto.VeiculoRequestDTO;
import com.estacionamentoapi.dto.VeiculoResponseDTO;
import com.estacionamentoapi.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    Veiculo toEntity(VeiculoRequestDTO dto);

    VeiculoResponseDTO toResponseDTO(Veiculo entity);
}
