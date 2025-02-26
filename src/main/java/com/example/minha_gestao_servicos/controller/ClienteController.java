package com.example.minha_gestao_servicos.controller;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Optional<Cliente>> findByCpf(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.findByCpf(cpf);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        cliente = clienteService.create(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {

        Cliente atualizado = clienteService.update(cliente.getCpf(), cliente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping(value = "/delete/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        try {
            clienteService.delete(cpf);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

