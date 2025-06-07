# User Registration & Notification System

Este repositório contém dois serviços independentes que trabalham de forma integrada utilizando Amazon SQS para comunicação assíncrona. O objetivo é fornecer uma arquitetura desacoplada para cadastro de usuários e envio de e-mails de confirmação.

### 🧩 Serviços incluídos:

- **User Service**: Responsável por criar e persistir usuários no banco de dados PostgreSQL. Após o cadastro, o serviço envia uma mensagem para uma fila SQS.
- **Email Service**: Responsável por consumir mensagens da fila SQS e enviar um e-mail de notificação para o usuário recém-cadastrado.

### 🛠️ Tecnologias Utilizadas

| Serviço        | Tecnologias                                                               |
|----------------|---------------------------------------------------------------------------|
| User Service   | Java 21, Spring Boot 3.5.0, JPA, Spring Cloud AWS, Lombok, PostgreSQL     |
| Email Service  | Java 21, Spring Boot 3.5.0, Spring Cloud AWS, Lombok, Java Mail Sender    |