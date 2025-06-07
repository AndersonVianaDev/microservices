# User Service

Este serviço é responsável pelo cadastro de usuários e pelo envio de mensagens a uma fila SQS da AWS após a criação de um novo usuário. A mensagem contém os dados necessários para que outro serviço possa processar e enviar um e-mail de notificação.

## 📌 Funcionalidades

- Cadastro de usuários
- Persistência dos dados com PostgreSQL
- Envio de evento para fila SQS após cadastro

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- Spring Cloud AWS
- Lombok
- PostgreSQL

## 📦 Integrações

- **Amazon SQS**: Usado para comunicação assíncrona com o serviço de e-mail.

## 🚀 Como executar
Configure as variáveis de ambiente ou `application.yml` para acesso ao banco de dados e AWS.