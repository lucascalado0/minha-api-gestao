package com.example.minha_gestao_servicos.repository;

import com.example.minha_gestao_servicos.model.Cliente;
import com.example.minha_gestao_servicos.model.Pet;
import com.example.minha_gestao_servicos.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    Optional<Servico> findById(Long id);
    List<Servico> findAll();
}
