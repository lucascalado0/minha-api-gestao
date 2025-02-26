package com.example.minha_gestao_servicos.service;

import com.example.minha_gestao_servicos.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> findByCpf(String cpf);

    Cliente create(Cliente novoCliente);

    Cliente delete(String cpf);

    Cliente update(String cpf, Cliente cliente);
}
