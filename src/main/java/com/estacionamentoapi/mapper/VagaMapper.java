package com.estacionamentoapi.mapper;

import com.estacionamentoapi.dto.VagaRequestDTO;
import com.estacionamentoapi.dto.VagaResponseDTO;
import com.estacionamentoapi.model.Vaga;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VagaMapper {

    Vaga toEntity(VagaRequestDTO dto);

    VagaResponseDTO toResponseDTO(Vaga entity);
}
