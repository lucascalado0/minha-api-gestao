# API gestao de servicos


##Diagrama de classes

```mermaid
classDiagram
    class Cliente {
        -String nomeCompleto
        -String email
        -String numero
        -String rua
        -String bairro
        -String historico
        -String cpf
    }

    class Pet {
        -String nome
        -int idade
        -String raca
        -float peso
        -String sexo
        -Long donoId
    }

    class Servico {
        -String dataInicio
        -String dataFim
        -String tipoServico
        -String statusPagamento
        -String formaPagamento
        -String dataPagamento
        -String cpfCliente
        -String nomePet
    }

    Cliente --* Pet
    Pet --* Servico
    Cliente --* Servico



```