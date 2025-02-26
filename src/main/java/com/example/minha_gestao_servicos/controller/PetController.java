package com.example.minha_gestao_servicos.controller;



import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.service.impl.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    private PetServiceImpl petService;


    @PostMapping(value = "/save")
    public ResponseEntity<Pet> create(@RequestBody Pet pet){

        pet = petService.create(pet);

        return ResponseEntity.ok().body(pet);
    }

//    @PostMapping(name = "/save")
//    public ResponseEntity<Pet> adicionarPet(@RequestBody Pet pet) {
//        Optional<Cliente> clienteOptional = clienteService.findByCpf(pet.getTutor().getCpf());
//        if (clienteOptional.isPresent()) {
//            Cliente cliente = clienteOptional.get();
//            pet.setTutor(cliente);
//            cliente.getPets().add(pet);
//            Pet novoPet = petService.create(pet);
//            return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }




    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Pet>> findById(@PathVariable Long id){
        Optional<Pet> pet = petService.findById(id);

        if (pet.isPresent()){
            return ResponseEntity.ok(pet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @GetMapping(value = "/todos")
    public ResponseEntity <List<Pet>> findAll(){
        List<Pet> pets = petService.findAll();

        return ResponseEntity.ok(pets);
    }
}
