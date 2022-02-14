# Registro de Pessoas

### Objetivo

Sistema básico para servir de teste no processo seletivo de pessoas para B2W.

### Configurações Básicas

- [Habilitar acesso de aplicativos menos seguros na sua conta do GMail](https://myaccount.google.com/u/0/lesssecureapps?pli=1)
- Preencher os campos mailer.username e mailer.password no arquivo application.properties com os dados da sua conta

### Exemplo para criação de uma pessoa
```
curl -X POST \
  http://localhost:8081/people/register \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "Fulano de Tal",
	"email": "fulanodetal@b2wdigital.com",
	"cpf": "56780134227",
	"age": 19,
	"gender": "Masculino"
}'

### EXECUTANDO OS SERVIÇOS NO DOCKER

requisitos:
 - ter o docker instalado na maquina
 
Executando OS SERVIÇOS:

1. CONSTRUINDO IMAGEM DOS SERVIÇOS:
	- docker build -t cpf-validator
	- docker build -t api-people-registration
	
2. EXECUTANDO A IMAGEM DOCKER DENTRO DOS CONTAINERS
  - docker network create rede_local
  - docker run -p 8081:8081 --name api-people-registration --network rede_local api-people-registration
  - docker run -p 8080:8080 --name cpf-validator --network rede_local cpf-validator 
```