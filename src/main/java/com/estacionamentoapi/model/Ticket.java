package com.estacionamentoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataSaida;
    private Integer horas;
    private Double valorTotal;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }
    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
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
