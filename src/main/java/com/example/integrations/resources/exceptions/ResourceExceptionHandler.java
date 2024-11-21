package com.example.integrations.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.integrations.services.exceptions.EmailException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Classe responsável por tratar exceções em todo o projeto.
 * Utiliza a anotação @ControllerAdvice para capturar exceções de forma global.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

  /**
   * Método que trata exceções do tipo EmailException.
   * Constrói uma resposta detalhada com informações relevantes sobre o erro.
   * 
   * @param e       Exceção capturada.
   * @param request Objeto que contém informações da requisição onde o erro
   *                ocorreu.
   * @return ResponseEntity contendo os detalhes do erro e o status HTTP
   *         apropriado.
   */
  @ExceptionHandler(EmailException.class)
  public ResponseEntity<StandardError> emailException(EmailException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST; // Define o status HTTP para erro na requisição.
    StandardError err = new StandardError(); // Objeto para encapsular os detalhes do erro.
    err.setTimestamp(Instant.now()); // Timestamp do momento em que o erro ocorreu.
    err.setStatus(status.value()); // Código de status HTTP.
    err.setError("Email error"); // Descrição genérica do tipo de erro.
    err.setMessage(e.getMessage()); // Mensagem específica da exceção lançada.
    err.setPath(request.getRequestURI()); // Caminho da URI onde o erro ocorreu.
    return ResponseEntity.status(status).body(err); // Retorna a resposta com os detalhes do erro.
  }
}
