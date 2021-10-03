# Itau Project
Utilizado spring boot com Java 11, criei uma api que recebe uma string e retorna um boolean validando algumas regras:

* Nove ou mais caracteres.
* Ao menos 1 dígito.
* Ao menos 1 letra minúscula.
* Ao menos 1 letra maiúscula.
* Ao menos 1 caractere especial.
* Considere como especial os seguintes caracteres: "!@#$%^&*()-+".
* Não possuir caracteres repetidos dentro do conjunto.

Foram criados testes unitários para executar os cenários que são validados no serviço.
Para executá-los basta apenas executar o comando no terminal do intellij: 
* "mvn test".

#Para executar o projeto:
* No terminal exexute um mvn clean install.
* Suba a aplicação com o run.
* Faça a chamada do serviço pelo postman ou usando o curl.

#Exemplo de uma chamada:

* curl --location --request POST 'http://localhost:8080/v1/password/validate' \
--header 'Content-Type: application/json' \
--data-raw '{
"key": "Th1460 Aug_s+*"
}'
