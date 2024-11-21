package com.example.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.integrations.dto.EmailDTO;

/**
 * Serviço de e-mail simulado (Mock) usado para testes ou ambientes de
 * desenvolvimento.
 * Em vez de enviar um e-mail real, apenas registra os detalhes no log.
 */
public class MockEmailService implements EmailService {

  // Logger utilizado para registrar informações e simular o envio de e-mails.
  private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

  /**
   * Simula o envio de um e-mail registrando os detalhes no log.
   * 
   * @param emailDTO Objeto contendo as informações do e-mail (destinatário,
   *                 assunto, corpo etc.).
   */
  public void sendEmail(EmailDTO emailDTO) {
    // Registra no log que o e-mail está sendo enviado.
    LOG.info("Sending email to: " + emailDTO.getTo());
    // Registra no log que o e-mail foi enviado com sucesso.
    LOG.info("Email sent!");
  }
}
