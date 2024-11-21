package com.example.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.integrations.services.EmailService;
import com.example.integrations.services.SendGridEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

  @Bean
  public EmailService emailService() {
    return new SendGridEmailService();
  }
}
