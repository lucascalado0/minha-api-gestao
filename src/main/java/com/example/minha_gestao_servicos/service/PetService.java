package com.example.minha_gestao_servicos.service;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    Optional<Pet> findById(Long id);
    List<Pet> findAll();
    Pet update(Long id, Pet pet);
    Pet create(Pet pet);
}
