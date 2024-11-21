package com.example.integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.integrations.services.EmailService;
import com.example.integrations.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

  @Bean
  public EmailService emailService() {
    return new MockEmailService();
  }
}
