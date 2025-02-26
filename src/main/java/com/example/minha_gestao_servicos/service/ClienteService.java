package com.example.minha_gestao_servicos.service;

import com.example.minha_gestao_servicos.model.Cliente;

public interface ClienteService {

    Cliente findByCpf(String cpf);

    Cliente create(Cliente novoCliente);

    Cliente deleteByCpf(String cpf);

    Cliente updateByCpf(String cpf, Cliente cliente);
}
