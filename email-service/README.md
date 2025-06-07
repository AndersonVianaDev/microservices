# Email Service

Este serviço é responsável por consumir mensagens da fila SQS e enviar e-mails de notificação para os usuários recém-cadastrados.

## 📌 Funcionalidades

- Consumo de mensagens da Amazon SQS
- Envio de e-mails com JavaMailSender
- Lógica desacoplada do serviço de cadastro

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Cloud AWS
- Java Mail Sender
- Lombok

## 📦 Integrações

- **Amazon SQS**: Consome mensagens contendo dados do usuário
- **Email SMTP Provider**: Responsável por enviar os e-mails (ex: Gmail SMTP ou SES)

## 🚀 Como executar

1. Configure suas credenciais AWS para consumo da fila.
2. Configure SMTP no `application.yml` com seu provedor de e-mail.