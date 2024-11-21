package com.example.integrations.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.integrations.dto.EmailDTO;
import com.example.integrations.services.exceptions.EmailException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

/**
 * Serviço responsável por enviar e-mails utilizando a API do SendGrid.
 */
public class SendGridEmailService implements EmailService {

  // Logger utilizado para registrar informações e eventos do envio de e-mail.
  private static Logger LOG = LoggerFactory.getLogger(SendGridEmailService.class);

  // Cliente SendGrid configurado no projeto e injetado automaticamente.
  @Autowired
  private SendGrid sendGrid;

  /**
   * Envia um e-mail utilizando os dados fornecidos pelo EmailDTO.
   * 
   * @param emailDTO Objeto que contém as informações necessárias para o envio do
   *                 e-mail
   *                 (remetente, destinatário, assunto, tipo de conteúdo e corpo).
   * @throws EmailException Exceção personalizada para erros no envio de e-mails.
   */
  public void sendEmail(EmailDTO emailDTO) {
    // Cria o remetente do e-mail com o endereço e nome fornecidos.
    Email from = new Email(emailDTO.getFromEmail(), emailDTO.getFromName());
    // Cria o destinatário do e-mail.
    Email to = new Email(emailDTO.getTo());
    // Configura o conteúdo do e-mail.
    Content content = new Content(emailDTO.getContentType(), emailDTO.getBody());
    // Constrói o objeto Mail com as informações do e-mail.
    Mail mail = new Mail(from, emailDTO.getSubject(), to, content);

    // Configura a requisição para a API do SendGrid.
    Request request = new Request();
    try {
      request.setMethod(Method.POST); // Define o método HTTP como POST.
      request.setEndpoint("mail/send"); // Define o endpoint da API de envio de e-mails.
      request.setBody(mail.build()); // Constrói o corpo da requisição com os dados do e-mail.

      LOG.info("Sending email to: " + emailDTO.getTo()); // Log informando o destinatário.

      // Executa a chamada para a API do SendGrid.
      Response response = sendGrid.api(request);

      // Verifica erros na resposta da API (códigos 4xx indicam erros do cliente).
      if (response.getStatusCode() >= 400 && response.getStatusCode() < 500) {
        LOG.error("Error sending email: " + response.getBody()); // Log detalhado do erro.
        throw new EmailException(response.getBody()); // Lança exceção personalizada.
      }

      LOG.info("Email sent! Status = " + response.getStatusCode()); // Log de sucesso.
    } catch (IOException e) {
      // Captura erros de entrada/saída e lança uma exceção personalizada.
      throw new EmailException(e.getMessage());
    }
  }
}
