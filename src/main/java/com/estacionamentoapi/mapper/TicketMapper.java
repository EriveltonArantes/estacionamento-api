package com.estacionamentoapi.mapper;

import com.estacionamentoapi.dto.TicketRequestDTO;
import com.estacionamentoapi.dto.TicketResponseDTO;
import com.estacionamentoapi.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "vaga", ignore = true)
    @Mapping(target = "veiculo", ignore = true)
    Ticket toEntity(TicketRequestDTO dto);

    @Mapping(target = "vagaId", source = "vaga.id")
    @Mapping(target = "veiculoId", source = "veiculo.id")
    TicketResponseDTO toResponseDTO(Ticket entity);
}
