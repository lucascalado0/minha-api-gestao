package com.example.minha_gestao_servicos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "pets")
@Data
@Table(name = "tb_pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(length = 20, nullable = false)
    private String raca;

    @Column(nullable = false)
    private Double peso;

    @Column(length = 10, nullable = false)
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente dono;

    @ManyToMany(mappedBy = "pets")
    private List<Servico> servicos;
}
