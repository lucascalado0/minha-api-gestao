package com.example.minha_gestao_servicos.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;



@Entity(name = "servicos")
@Data
@Table(name = "tb_servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column(name = "data_inicio", columnDefinition = "DATE", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", columnDefinition = "DATE", nullable = false)
    private LocalDate dataFim;

    @Column(name = "status_pagamento", nullable = false)
    private Boolean statusPagamento;

    @Column(name = "forma_pagamento", length = 10, nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "servico_pet",
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private List<Pet> pets;
}
