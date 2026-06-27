package com.estacionamentoapi.dto;

public class TicketResponseDTO {

    private Long id;
    private Long vagaId;
    private Long veiculoId;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataSaida;
    private Integer horas;
    private Double valorTotal;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
