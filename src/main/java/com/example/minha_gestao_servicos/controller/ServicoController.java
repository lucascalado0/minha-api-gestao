package com.example.minha_gestao_servicos.controller;


import com.example.minha_gestao_servicos.model.Servico;
import com.example.minha_gestao_servicos.service.impl.ServicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoServiceImpl servicoService;


    @PostMapping(value = "/save")
    public ResponseEntity <Servico> create(@RequestBody Servico servico){
        servico = servicoService.create(servico);

        return ResponseEntity.ok().body(servico);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id) {
        Optional<Servico> servicoBusca = servicoService.findById(id);
        if (servicoBusca.isPresent()) {
            Servico servico = servicoBusca.get();
            return ResponseEntity.ok(servico);
        } else {
            throw new NoSuchElementException("Nao existe servico com esse id!");
        }
    }


    @GetMapping(value = "/todos")
    public ResponseEntity <List<Servico>> findAll(){
        List<Servico> servicos = servicoService.findAll();

        return ResponseEntity.ok(servicos);
    }
}
