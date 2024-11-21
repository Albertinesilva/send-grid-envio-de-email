package com.example.integrations.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

/**
 * Classe que representa o formato de erro padrão a ser retornado
 * em respostas de exceções tratadas.
 */
public class StandardError implements Serializable {

  private static final long serialVersionUID = 1L; // Identificador único para serialização.

  private Instant timestamp; // Data e hora do erro.
  private Integer status; // Código do status HTTP do erro.
  private String error; // Descrição genérica do erro.
  private String message; // Mensagem detalhada do erro.
  private String path; // Caminho da URI onde o erro ocorreu.

  /**
   * Construtor padrão.
   */
  public StandardError() {
  }

  /**
   * Método que retorna a data e hora do erro.
   * 
   * @return timestamp - o momento do erro.
   */
  public Instant getTimestamp() {
    return timestamp;
  }

  /**
   * Método que define a data e hora do erro.
   * 
   * @param timestamp - o momento do erro.
   */
  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Método que retorna o código de status HTTP do erro.
   * 
   * @return status - código do erro.
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * Método que define o código de status HTTP do erro.
   * 
   * @param status - código do erro.
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Método que retorna a descrição genérica do erro.
   * 
   * @return error - descrição do tipo de erro.
   */
  public String getError() {
    return error;
  }

  /**
   * Método que define a descrição genérica do erro.
   * 
   * @param error - descrição do tipo de erro.
   */
  public void setError(String error) {
    this.error = error;
  }

  /**
   * Método que retorna a mensagem detalhada do erro.
   * 
   * @return message - mensagem do erro.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Método que define a mensagem detalhada do erro.
   * 
   * @param message - mensagem do erro.
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Método que retorna o caminho da URI onde o erro ocorreu.
   * 
   * @return path - caminho da URI.
   */
  public String getPath() {
    return path;
  }

  /**
   * Método que define o caminho da URI onde o erro ocorreu.
   * 
   * @param path - caminho da URI.
   */
  public void setPath(String path) {
    this.path = path;
  }
}
