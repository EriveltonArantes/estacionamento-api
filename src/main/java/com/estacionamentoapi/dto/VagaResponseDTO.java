package com.estacionamentoapi.dto;

public class VagaResponseDTO {

    private Long id;
    private Integer numero;
    private String tipo;
    private Boolean disponivel;
    private Integer andar;
    private String setor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
