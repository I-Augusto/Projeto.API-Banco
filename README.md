# Projeto.API-Banco

projeto feito para consolidar conhecimentos em API REST e Spring

## Diagrama

```mermaid
classDiagram

    class User {
        -Client client
        -Account account
        -Card card
    }

    class Client {
        -String name
        -String email
        -String cpf
        -String phone
        -String birthDate
    }

    class Account {
        -String agency
        -String accountNumber
        -BigDecimal balance
        -BigDecimal creditLimit
        -String accountStatus
    }

    class Card {
        -String number
        -BigDecimal limit
    }

    User "1" *-- "1" Account 
    User "1" *-- "1" Card
    User "1" *-- "1" Client


```
## Como usar
Para vizualizar o uso da API é possivel realizar isso da seguinte forma:
* Abra o Link: http://localhost:8080/h2-console
* Confirme os seguintes dados:
    * JDBC URL: jdbc:h2:mem:bancoapi
    * User name: bancoapi
* Abra o Link: http://localhost:8080/swagger-ui/index.html
* Para utilizar o swagger siga os passos em [Exemplos para os usos do Swagger](#exemplos-para-os-usos-do-swagger)
    * [POST](#post)
    * [GET](#get)
* Com tudo feito já é possivel utilizar os métodos e monitorar o banco de dados no H2 (A memória dele é temporaria, então quando o programa for fechado todos os dados serão deletados)


## Exemplos para os usos do Swagger

### POST
```json
{
  "client": {
    "name": "Pedro",
    "email": "pedro@gmail.com",
    "cpf": "987.654.321-01",
    "phone": "(11) 94568-8965",
    "birthDate": "2000-06-16"
  },
  "account": {
    "agency": "0001",
    "number": "00000001-1",
    "balance": 257.5,
    "creditLimit": 120,
    "accountStatus": "Ativa"
  },
  "card": {
    "number": "0000-0000-0000-0001",
    "limit": 100
  }
}
```

### GET
Coloque apenas o Id que deseja consultar
