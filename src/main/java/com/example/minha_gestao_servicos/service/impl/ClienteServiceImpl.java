package com.example.minha_gestao_servicos.service.impl;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.repository.ClienteRepository;
import com.example.minha_gestao_servicos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente novoCliente) {
        if ((novoCliente.getId() != null) && (clienteRepository.existsById(novoCliente.getId()))) {
            throw new IllegalArgumentException("Ja existe um cliente com esse ID");
        }
        return clienteRepository.save(novoCliente);
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
        if (clienteOptional.isPresent()) {
            return clienteOptional;
        } else {
            throw new NoSuchElementException("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public Cliente delete(String cpf) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            clienteRepository.delete(cliente);

            return cliente;

        } else {
            throw new NoSuchElementException("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public Cliente update(String cpf, Cliente novosDados) {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            cliente.setEmail(novosDados.getEmail());
            cliente.setNumeroContato(novosDados.getNumeroContato());
            cliente.setEndereco(novosDados.getEndereco());

            clienteRepository.save(cliente);

            return cliente;
        } else {
            throw new NoSuchElementException("Cliente com CPF " + cpf + " não encontrado.");
        }
    }}