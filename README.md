# API gestao de servicos


##Diagrama de classes

```mermaid
classDiagram
    class Cliente {
        +Long id
        +String cpf
        +String primeiroNome
        +String sobrenome
        +String email
        +String numeroContato
        +Endereco endereco
        +List<Pet> pets
    }

    class Endereco {
        +String rua
        +String bairro
        +Integer numero
        +String cidade
        +String estado
        +String cep
    }

    class Pet {
        +Long id
        +String nome
        +Integer idade
        +String raca
        +Double peso
        +String sexo
        +Cliente cliente
        +String observacoes
    }

    class Servico {
        +Long id
        +Cliente cliente
        +List<Pet> pets
        +LocalDate dataInicio
        +LocalDate dataFim
        +Boolean statusPagamento
        +String formaPagamento
        +Double valor
    }

    Cliente "1" -- "1" Endereco : possui
    Cliente "1" -- "0..*" Pet : possui
    Servico "1" -- "1" Cliente : pertence
    Servico "1" -- "1..*" Pet : inclui


```
##Cardinalidades

-Cliente "1" -- "1" Endereco → Um cliente tem um endereço.<br>
-Cliente "1" -- "0..*" Pet → Um cliente pode ter vários pets, mas um pet pertence a apenas um cliente.<br>
-Servico "1" -- "1" Cliente → Um serviço pertence a um único cliente.<br>
-Servico "1" -- "1..*" Pet → Um serviço pode incluir um ou mais pets.<br>