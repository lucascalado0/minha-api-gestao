package com.example.minha_gestao_servicos.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "pets")
@Data
@Table(name = "tb_pets")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nome")
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
    private Cliente tutor;


    @ManyToMany(mappedBy = "pets")
    private List<Servico> servicos;
}
