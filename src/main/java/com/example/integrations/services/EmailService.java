package com.example.integrations.services;

import com.example.integrations.dto.EmailDTO;

/**
 * Interface que define o contrato para serviços de envio de e-mails.
 * Implementações dessa interface devem fornecer a lógica para envio de e-mails.
 */
public interface EmailService {

  /**
   * Envia um e-mail utilizando os dados fornecidos.
   * 
   * @param emailDTO Objeto que encapsula as informações do e-mail,
   *                 como remetente, destinatário, assunto, corpo e tipo de
   *                 conteúdo.
   */
  void sendEmail(EmailDTO emailDTO);
}
