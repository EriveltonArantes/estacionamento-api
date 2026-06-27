package com.estacionamentoapi.dto;

import jakarta.validation.constraints.*;

public class TabelaPrecoRequestDTO {

    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @DecimalMin(value = "0.0", message = "valor hora não pode ser negativo")
    @NotNull(message = "valor hora não pode ser nulo")
    private Double valorHora;
    @DecimalMin(value = "0.0", message = "valor diaria não pode ser negativo")
    @NotNull(message = "valor diaria não pode ser nulo")
    private Double valorDiaria;
    @DecimalMin(value = "0.0", message = "valor mensal não pode ser negativo")
    @NotNull(message = "valor mensal não pode ser nulo")
    private Double valorMensal;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Double getValorHora() { return valorHora; }
    public void setValorHora(Double valorHora) { this.valorHora = valorHora; }
    public Double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(Double valorDiaria) { this.valorDiaria = valorDiaria; }
    public Double getValorMensal() { return valorMensal; }
    public void setValorMensal(Double valorMensal) { this.valorMensal = valorMensal; }
}
