package com.example.minha_gestao_servicos.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity(name = "clientes")
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Long id;

    @Column(length = 12, nullable = false, unique = true)
    private String cpf;

    @Column(name = "primeiro_nome", length = 100, nullable = false)
    private String primeiroNome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "numero_contato", length = 20, nullable = false, unique = true)
    private String numeroContato;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL) //cascadate.type todas as operações feitas no Cliente também serão propagadas para os Pets
    @JsonManagedReference
    private List<Pet> pets;
}
