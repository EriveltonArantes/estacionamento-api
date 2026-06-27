package com.estacionamentoapi.dto;

import jakarta.validation.constraints.*;

public class VagaRequestDTO {

    @Min(value = 0, message = "numero não pode ser negativo")
    @NotNull(message = "numero não pode ser nulo")
    private Integer numero;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotNull(message = "disponivel não pode ser nulo")
    private Boolean disponivel;
    @NotNull(message = "andar não pode ser nulo")
    private Integer andar;
    @NotBlank(message = "setor não pode estar em branco")
    private String setor;

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
    public Integer getAndar() { return andar; }
    public void setAndar(Integer andar) { this.andar = andar; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
}
