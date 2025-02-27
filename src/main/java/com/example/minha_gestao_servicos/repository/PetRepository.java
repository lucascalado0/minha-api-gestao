package com.example.minha_gestao_servicos.repository;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findById(Long id);
    List<Pet> findAll();
}
