package com.example.minha_gestao_servicos.model;

import lombok.Data;

@Data
public class Pet {
    private Long petId;
    private String nome;
    private Integer idade;
    private String raca;
    private Double peso;
    private String sexo;
    private Cliente dono;
}
