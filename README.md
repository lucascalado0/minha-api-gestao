# API gestao de servicos


##Diagrama de classes

```
classDiagram
    class Cliente {
        -String nomeCompleto
        -String email
        -String numero
        -String rua
        -String bairro
        -String historico
    }

    class Pet {
        -String nome
        -int idade
        -String raca
        -float peso
        -String sexo
    }

    class Servico {
        -String dataInicio
        -String dataFim
        -String tipoServico
        -String statusPagamento
        -String formaPagamento
        -String dataPagamento
    }

    Cliente --* Pet
    Pet --* Servico

```