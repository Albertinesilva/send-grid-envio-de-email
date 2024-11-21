package com.example.integrations.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrations.dto.EmailDTO;
import com.example.integrations.services.EmailService;

/**
 * Controlador responsável por gerenciar as requisições relacionadas ao envio de
 * e-mails.
 */
@RestController
@RequestMapping(value = "/emails") // Define o caminho base da API para este recurso, que será /emails.
public class EmailResource {

  // Injeta a dependência do serviço de envio de e-mails
  @Autowired
  private EmailService emailService;

  /**
   * Método que recebe uma requisição POST com os dados de um e-mail e chama o
   * serviço
   * para enviar o e-mail.
   *
   * @param emailDTO Objeto contendo os dados do e-mail a ser enviado.
   * @return Uma resposta HTTP sem conteúdo (204 No Content) se o e-mail for
   *         enviado com sucesso.
   */
  @PostMapping // Mapeia a requisição HTTP POST para o envio de e-mail.
  public ResponseEntity<Void> sendEmailMessage(@RequestBody EmailDTO emailDTO) {
    // Chama o serviço para enviar o e-mail com os dados fornecidos.
    emailService.sendEmail(emailDTO);

    // Retorna uma resposta HTTP indicando que a requisição foi bem-sucedida
    // e não há conteúdo adicional a ser retornado.
    return ResponseEntity.noContent().build();
  }
}
