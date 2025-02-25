package com.example.minha_gestao_servicos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable //objeto encorporado a classe cliente
@Data
public class Endereco {

    @Column(length = 50, nullable = false)
    private String rua;

    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(nullable = false)
    private int numero;

    @Column(length = 20, nullable = false)
    private String cep;
}
