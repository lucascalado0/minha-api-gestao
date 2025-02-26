package com.example.minha_gestao_servicos.service.impl;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.repository.PetRepository;
import com.example.minha_gestao_servicos.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Optional<Pet> findById(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isPresent()){
            return petOptional;
        } else {
            throw new NoSuchElementException("Pet com Id " + id + " não encontrado");
        }
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet update(Long id, Pet novosDados) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            pet.setIdade(novosDados.getIdade());
            pet.setPeso(novosDados.getPeso());


            petRepository.save(pet);

            return pet;
        } else {
            throw new NoSuchElementException("pet com id " + id + " não encontrado.");
        }
    }


}
