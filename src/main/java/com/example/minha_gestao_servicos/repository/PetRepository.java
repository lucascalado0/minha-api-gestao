package com.example.minha_gestao_servicos.repository;

import com.example.minha_gestao_servicos.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
