package com.example.minha_gestao_servicos.model;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
public class Servico {
    private Long idServico;
    private LocalDate dataInicio;
    private Local dataFim;
    private String statusPagamento;
    private String formaPagamento;
    private Double valor;
    private List<Pet> pets;
}
