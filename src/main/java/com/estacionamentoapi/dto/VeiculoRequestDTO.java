package com.estacionamentoapi.dto;

import jakarta.validation.constraints.*;

public class VeiculoRequestDTO {

    @NotBlank(message = "placa não pode estar em branco")
    private String placa;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "marca não pode estar em branco")
    private String marca;
    @NotBlank(message = "cor não pode estar em branco")
    private String cor;
    @NotBlank(message = "cliente nome não pode estar em branco")
    private String clienteNome;
    @NotBlank(message = "cliente telefone não pode estar em branco")
    private String clienteTelefone;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    public String getClienteTelefone() { return clienteTelefone; }
    public void setClienteTelefone(String clienteTelefone) { this.clienteTelefone = clienteTelefone; }
}
