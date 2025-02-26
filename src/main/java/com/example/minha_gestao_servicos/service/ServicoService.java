package com.example.minha_gestao_servicos.service;

import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.model.Servico;
import com.example.minha_gestao_servicos.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoService {

    Servico create(Servico servico);
    Optional<Servico> findById(Long id);
    List<Servico> findAll();
    Servico update(Long id, Servico servico);
}
