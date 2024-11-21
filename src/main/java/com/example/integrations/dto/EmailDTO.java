package com.example.integrations.dto;

import java.io.Serializable;

/**
 * DTO (Data Transfer Object) para encapsular as informações necessárias para o
 * envio de e-mails.
 * Implementa Serializable para permitir que o objeto seja serializado, caso
 * necessário.
 */
public class EmailDTO implements Serializable {

  private static final long serialVersionUID = 1L; // Identificador único para a serialização.

  // Endereço de e-mail do remetente.
  private String fromEmail;
  // Nome do remetente.
  private String fromName;
  // Endereço para resposta (Reply-To), caso diferente do remetente.
  private String replyTo;
  // Endereço de e-mail do destinatário.
  private String to;
  // Assunto do e-mail.
  private String subject;
  // Corpo da mensagem do e-mail.
  private String body;
  // Tipo de conteúdo do e-mail (ex.: text/plain, text/html).
  private String contentType;

  /**
   * Construtor padrão.
   */
  public EmailDTO() {
  }

  /**
   * Construtor com todos os campos.
   * 
   * @param fromEmail   Endereço de e-mail do remetente.
   * @param fromName    Nome do remetente.
   * @param replyTo     Endereço de resposta (Reply-To).
   * @param to          Endereço de e-mail do destinatário.
   * @param subject     Assunto do e-mail.
   * @param body        Corpo do e-mail.
   * @param contentType Tipo de conteúdo do e-mail.
   */
  public EmailDTO(String fromEmail, String fromName, String replyTo, String to, String subject, String body,
      String contentType) {
    this.fromEmail = fromEmail;
    this.fromName = fromName;
    this.replyTo = replyTo;
    this.to = to;
    this.subject = subject;
    this.body = body;
    this.contentType = contentType;
  }

  // Métodos getters e setters para cada campo, permitindo acesso e modificação
  // dos valores.

  public String getFromEmail() {
    return fromEmail;
  }

  public void setFromEmail(String fromEmail) {
    this.fromEmail = fromEmail;
  }

  public String getFromName() {
    return fromName;
  }

  public void setFromName(String fromName) {
    this.fromName = fromName;
  }

  public String getReplyTo() {
    return replyTo;
  }

  public void setReplyTo(String replyTo) {
    this.replyTo = replyTo;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }
}
