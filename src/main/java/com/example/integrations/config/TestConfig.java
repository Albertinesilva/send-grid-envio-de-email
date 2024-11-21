package com.example.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.integrations.services.EmailService;
import com.example.integrations.services.MockEmailService;

/**
 * Configuração específica para o ambiente de teste (test).
 * Define os beans que serão usados quando o perfil "test" estiver ativo.
 */
@Configuration // Indica que esta classe contém configurações de beans para o Spring Container.
@Profile("test") // Define que esta configuração será utilizada apenas quando o perfil "test"
                 // estiver ativo.
public class TestConfig {

  /**
   * Define um bean do tipo EmailService, que será utilizado para simular o envio
   * de e-mails no ambiente de teste.
   * Neste caso, é especificado que o serviço de envio de e-mails será o
   * MockEmailService (simulação).
   *
   * @return A instância do serviço de e-mail simulado.
   */
  @Bean // Indica que este método define um bean que será gerenciado pelo Spring.
  public EmailService emailService() {
    // Retorna uma instância do serviço MockEmailService para ser usada nos testes.
    return new MockEmailService();
  }
}
