# Projeto.API-Banco

projeto feito para consolidar conhecimentos em API REST e Spring

## Diagrama

```mermaid
classDiagram
    class Cliente {
        -String nome
        -String email
        -String cpf
        -String telefone
        -String dataDeNascimento
    }

    class Conta {
        -String agencia
        -String conta
        -Float saldo
        -Float limiteDeCredito
        -String estadoDaConta
    }

    class Cartao {
        -String numero
        -Float limite
    }

    Cliente "1" *-- "1" Conta 
    Cliente "1" *-- "1" Cartao 

```
