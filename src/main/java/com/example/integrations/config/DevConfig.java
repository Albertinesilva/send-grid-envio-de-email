package com.example.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.integrations.services.EmailService;
import com.example.integrations.services.SendGridEmailService;

/**
 * Configuração específica para o ambiente de desenvolvimento (dev).
 * Define os beans que serão usados quando o perfil "dev" estiver ativo.
 */
@Configuration // Indica que esta classe contém configurações de beans para o Spring Container.
@Profile("dev") // Define que esta configuração será utilizada apenas quando o perfil "dev"
                // estiver ativo.
public class DevConfig {

  /**
   * Define um bean do tipo EmailService, que será utilizado para enviar e-mails
   * no ambiente de desenvolvimento.
   * Aqui, é especificado que o serviço de envio de e-mails será o
   * SendGridEmailService.
   *
   * @return A instância do serviço de e-mail.
   */
  @Bean // Indica que este método define um bean que será gerenciado pelo Spring.
  public EmailService emailService() {
    // Retorna uma instância do serviço SendGridEmailService para ser usada na
    // aplicação.
    return new SendGridEmailService();
  }
}
