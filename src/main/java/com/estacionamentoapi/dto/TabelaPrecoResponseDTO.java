package com.estacionamentoapi.dto;

public class TabelaPrecoResponseDTO {

    private Long id;
    private String tipo;
    private Double valorHora;
    private Double valorDiaria;
    private Double valorMensal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Double getValorHora() { return valorHora; }
    public void setValorHora(Double valorHora) { this.valorHora = valorHora; }
    public Double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(Double valorDiaria) { this.valorDiaria = valorDiaria; }
    public Double getValorMensal() { return valorMensal; }
    public void setValorMensal(Double valorMensal) { this.valorMensal = valorMensal; }
}
