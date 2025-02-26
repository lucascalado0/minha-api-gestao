package com.example.minha_gestao_servicos.service.impl;

import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.model.Servico;
import com.example.minha_gestao_servicos.repository.ServicoRepository;
import com.example.minha_gestao_servicos.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


    @Override
    public Optional<Servico> findById(Long id) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        if (servicoOptional.isPresent()){
            return servicoOptional;
        } else {
            throw new NoSuchElementException("Serviço com Id " + id + " não encontrado");
        }
    }

    @Override
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }


    @Override
    public Servico update(Long id, Servico novosDados) {
        Optional<Servico> servicoOptional = servicoRepository.findById(id);
        if (servicoOptional.isPresent()) {
            Servico servico = servicoOptional.get();

            servico.setDataInicio(novosDados.getDataInicio());
            servico.setDataFim(novosDados.getDataFim());
            servico.setFormaPagamento(novosDados.getFormaPagamento());
            servico.setValor(novosDados.getValor());


           servicoRepository.save(servico);

            return servico;
        } else {
            throw new NoSuchElementException("pet com id " + id + " não encontrado.");
        }
    }
}
