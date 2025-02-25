package com.example.minha_gestao_servicos.model;

import lombok.Data;

@Data
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
