package com.example.minha_gestao_servicos.controller;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;


    @PostMapping(value = "/save")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {

        cliente = clienteService.create(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Optional<Cliente>> findByCpf(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.findByCpf(cpf);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @GetMapping(value = "/todos")
    public ResponseEntity <List<Cliente>> findAll(){
        List<Cliente> clientes = clienteService.findAll();

        return ResponseEntity.ok(clientes);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteService.findByCpf(cliente.getCpf());
        if (clienteOptional.isPresent()) {
            Cliente atualizado = clienteService.update(cliente.getCpf(), cliente);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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

