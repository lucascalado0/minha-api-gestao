package com.example.minha_gestao_servicos.model;


import lombok.Data;

import java.util.List;

@Data
public class Cliente {
    private String cpf;
    private String primeiroNome;
    private String sobrenome;
    private String email;
    private String numeroContato;
    private String rua;
    private String bairro;
    private List<Pet> pets;
    //atualizar historico;
}
