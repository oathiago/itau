# Itau Project
> Utilizado spring boot com Java 11 e lombok, 
> criei uma api que recebe uma string e retorna um boolean 
> validando algumas regras:

* Nove ou mais caracteres.
* Ao menos 1 dígito.
* Ao menos 1 letra minúscula.
* Ao menos 1 letra maiúscula.
* Ao menos 1 caractere especial.
* Considere como especial os seguintes caracteres: "!@#$%^&*()-+".
* Não possuir caracteres repetidos dentro do conjunto.

> Decidi fazer em Java, pois trabalhei durante muito tempo com a linguagem e 
> tenho domínio da mesma.
>
> Atualmente estou trabalhando com Kotlin.

> Foram criados testes unitários para validar todos os cenários possíveis de entrada de dados.

#Para executar o projeto:
* No terminal exexute um mvn clean install.
* Suba a aplicação com o run.
* Faça a chamada do serviço pelo postman ou usando o curl.

#Exemplo de uma chamada:

* curl --location --request POST 'http://localhost:8080/v1/password/validate/key' \
--header 'Content-Type: application/json' \
--data-raw '{
"key": "Th1460 Aug_s+*"
}'
