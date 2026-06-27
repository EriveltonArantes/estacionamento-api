package com.estacionamentoapi.dto;

import jakarta.validation.constraints.*;

public class TicketRequestDTO {

    @NotNull(message = "VagaId é obrigatório")
    @Positive(message = "VagaId deve ser um ID válido (positivo)")
    private Long vagaId;
    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotNull(message = "data entrada não pode ser nulo")
    private java.time.LocalDateTime dataEntrada;
    @NotNull(message = "data saida não pode ser nulo")
    private java.time.LocalDateTime dataSaida;
    @NotNull(message = "horas não pode ser nulo")
    private Integer horas;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public java.time.LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(java.time.LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }
    public java.time.LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(java.time.LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
    public Integer getHoras() { return horas; }
    public void setHoras(Integer horas) { this.horas = horas; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
