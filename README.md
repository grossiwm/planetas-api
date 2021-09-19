# Planetas-Api

Esta é uma aplicação dedicada aos Planetas de Star Wars. Existe uma versão [demo](https://planetasapi.herokuapp.com/api-docs.html) rodando.
Caso queira testar utilizando Postman disponibizei esta [collection](https://planetasapi.herokuapp.com/api-docs.json). 
Para rodar este projeto localmente adicione uma variável de ambiente DB_SOURCE com a url de seu banco [MongoDB](https://www.mongodb.com).

# Documentação da API

## Indices

* [Ungrouped](#ungrouped)

  * [Adiconar Planeta no Banco de Dados](#1-adiconar-planeta-no-banco-de-dados)
  * [Buscar Planeta Planeta por Id do Banco de Dados](#2-buscar-planeta-planeta-por-id-do-banco-de-dados)
  * [Buscar Planeta por Nome do Banco de Dados](#3-buscar-planeta-por-nome-do-banco-de-dados)
  * [Buscar Planetas da API do Star Wars](#4-buscar-planetas-da-api-do-star-wars)
  * [Listar Planetas do Banco de Dados](#5-listar-planetas-do-banco-de-dados)
  * [Remover Planeta do Banco de Dados](#6-remover-planeta-do-banco-de-dados)


--------


## Ungrouped



### 1. Adiconar Planeta no Banco de Dados



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{baseUrl}}/planetas
```



***Body:***

```js        
{
    "nome": "Neoplaneta",
    "clima": "tropical",
    "terreno": "florestas",
    "numeroAparicoes": 3
}
```



***More example Requests/Responses:***


##### I. Example Request: Adiconar Planeta no Banco de Dados



***Body:***

```js        
{
    "nome": "Neoplaneta",
    "clima": "tropical",
    "terreno": "florestas",
    "numeroAparicoes": 3
}
```



##### I. Example Response: Adiconar Planeta no Banco de Dados
```js
{
    "id": "6147bde83da14049ef71140a",
    "nome": "Neoplaneta",
    "clima": "tropical",
    "terreno": "florestas",
    "numeroAparicoes": 3
}
```


***Status Code:*** 201

<br>



### 2. Buscar Planeta Planeta por Id do Banco de Dados



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{baseUrl}}/planetas/6147a7386231537b40db7d54
```



***More example Requests/Responses:***


##### I. Example Request: Buscar Planeta Planeta por Id do Banco de Dados



##### I. Example Response: Buscar Planeta Planeta por Id do Banco de Dados
```js
{
    "id": "6147a7386231537b40db7d54",
    "nome": "Orbtitron",
    "clima": "temperado",
    "terreno": "montanhas",
    "numeroAparicoes": 2
}
```


***Status Code:*** 200

<br>



### 3. Buscar Planeta por Nome do Banco de Dados



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{baseUrl}}/planetas/por-nome/mexitin
```



***More example Requests/Responses:***


##### I. Example Request: Buscar Planeta por Nome do Banco de Dados



##### I. Example Response: Buscar Planeta por Nome do Banco de Dados
```js
{
    "id": "6147b26d81aa8e52bebf86a7",
    "nome": "Mexitin",
    "clima": "tropical",
    "terreno": "florestas",
    "numeroAparicoes": 2
}
```


***Status Code:*** 200

<br>



### 4. Buscar Planetas da API do Star Wars



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{baseUrl}}/planetas/da-swapi
```



***More example Requests/Responses:***


##### I. Example Request: Buscar Planetas da API do Star Wars



##### I. Example Response: Buscar Planetas da API do Star Wars
```js
[
    {
        "nome": "Tatooine",
        "clima": "árido",
        "terreno": "deserto",
        "numeroAparicoes": 5
    },
    {
        "nome": "Alderaan",
        "clima": "temperado",
        "terreno": "pastagens, montanhas",
        "numeroAparicoes": 2
    },
    {
        "nome": "Yavin IV",
        "clima": "temperado, tropical",
        "terreno": "selva, floresta tropical",
        "numeroAparicoes": 1
    },
    {
        "nome": "Hoth",
        "clima": "congelado",
        "terreno": "tundra, cavernas de gelo, cordilheiras",
        "numeroAparicoes": 1
    },
    {
        "nome": "Dagobah",
        "clima": "turvo",
        "terreno": "pântano, selvas",
        "numeroAparicoes": 3
    },
    {
        "nome": "Bespin",
        "clima": "temperado",
        "terreno": "planeta gasoso",
        "numeroAparicoes": 1
    },
    {
        "nome": "Endor",
        "clima": "temperado",
        "terreno": "florestas, montanhas, lagos",
        "numeroAparicoes": 1
    },
    {
        "nome": "Naboo",
        "clima": "temperado",
        "terreno": "colinas gramadas, pântanos, florestas, montanhas",
        "numeroAparicoes": 4
    },
    {
        "nome": "Coruscant",
        "clima": "temperado",
        "terreno": "paisagem urbana, montanhas",
        "numeroAparicoes": 4
    },
    {
        "nome": "Kamino",
        "clima": "temperado",
        "terreno": "oceano",
        "numeroAparicoes": 1
    }
]
```


***Status Code:*** 200

<br>



### 5. Listar Planetas do Banco de Dados



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{baseUrl}}/planetas
```



***More example Requests/Responses:***


##### I. Example Request: Listar Planetas do Banco de Dados



##### I. Example Response: Listar Planetas do Banco de Dados
```js
[
    {
        "id": "6147a7386231537b40db7d54",
        "nome": "Orbtitron",
        "clima": "temperado",
        "terreno": "montanhas",
        "numeroAparicoes": 2
    },
    {
        "id": "6147ab504dc41d7205b9c860",
        "nome": "Ciburial",
        "clima": "tropical",
        "terreno": "selva",
        "numeroAparicoes": 5
    },
    {
        "id": "6147b26d81aa8e52bebf86a7",
        "nome": "Mexitin",
        "clima": "tropical",
        "terreno": "florestas",
        "numeroAparicoes": 2
    },
    {
        "id": "6147bde83da14049ef71140a",
        "nome": "Neoplaneta",
        "clima": "tropical",
        "terreno": "florestas",
        "numeroAparicoes": 3
    }
]
```


***Status Code:*** 200

<br>



### 6. Remover Planeta do Banco de Dados



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{baseUrl}}/planetas/6147bde83da14049ef71140a
```



***More example Requests/Responses:***


##### I. Example Request: Remover Planeta do Banco de Dados



***Status Code:*** 204

<br>



---
[Back to top](#planetasapi)
> Made with &#9829; by [thedevsaddam](https://github.com/thedevsaddam) | Generated at: 2021-09-19 19:58:37 by [docgen](https://github.com/thedevsaddam/docgen)
