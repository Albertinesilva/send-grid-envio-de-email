# Integração de Envio de E-mails com SendGrid e Mock para Testes

Este projeto foi desenvolvido para integrar um serviço de envio de e-mails usando a API do SendGrid, permitindo o envio de mensagens de e-mail de forma programática e robusta. Ele também oferece suporte para testes usando um serviço simulado (MockEmailService), garantindo que a aplicação possa ser testada sem a necessidade de fazer envios reais de e-mails durante o desenvolvimento ou a execução de testes.

## Funcionalidades

- **Envio de E-mails Real**: Usando a API do SendGrid, os e-mails são enviados para os destinatários definidos, com suporte para diferentes tipos de conteúdo (HTML, texto simples) e opções de resposta.
- **Serviço Simulado para Testes**: Para facilitar o desenvolvimento e testar a lógica sem enviar e-mails reais, o projeto inclui um serviço simulado que apenas loga os e-mails que seriam enviados.
- **Tratamento de Exceções**: O sistema captura erros de envio de e-mails e retorna respostas apropriadas, com logs detalhados para facilitar o diagnóstico de problemas.
- **Configuração por Perfil**: O projeto usa perfis do Spring (`dev` e `test`) para configurar o comportamento do serviço de e-mail, facilitando o uso de diferentes soluções em ambientes de desenvolvimento e testes.

## Estrutura do Projeto

- **EmailService**: Interface que define o método para envio de e-mails, com duas implementações principais: `SendGridEmailService` para produção e `MockEmailService` para testes.
- **EmailDTO**: Classe responsável por transportar os dados necessários para o envio do e-mail, como remetente, destinatário, assunto e conteúdo.
- **Controller**: Através do `EmailResource`, um endpoint REST (`/emails`) foi criado para receber requisições HTTP POST para envio de e-mails.
- **Configuração de Perfis**: Arquivos de configuração para ativar o serviço correto de envio de e-mails dependendo do perfil ativo (`dev` ou `test`).

## Como Configurar

1. **Defina a chave API do SendGrid**: No arquivo `application.properties`, insira sua chave da API do SendGrid.
   - `spring.sendgrid.api-key=${SENDGRID_API_KEY}`
2. **Configuração de Perfil**: Alterne entre os perfis `dev` e `test` no arquivo `application.properties` para usar o SendGrid em produção ou o serviço simulado em testes.

## Exemplos de Uso

### Enviar um E-mail:

Envie uma requisição HTTP POST para o endpoint `/emails` com o corpo da solicitação no formato JSON, contendo os detalhes do e-mail (remetente, destinatário, assunto, conteúdo, etc.).

### Exemplo de Corpo da Requisição:

```json
{
  "fromEmail": "example@example.com",
  "fromName": "Example Sender",
  "to": "recipient@example.com",
  "subject": "Test Email",
  "body": "This is a test email sent via SendGrid.",
  "contentType": "text/plain"
}
```
