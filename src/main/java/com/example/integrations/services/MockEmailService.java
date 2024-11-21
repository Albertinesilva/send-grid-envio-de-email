package com.example.integrations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.integrations.dto.EmailDTO;

public class MockEmailService implements EmailService {

  private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

  public void sendEmail(EmailDTO emailDTO) {
    LOG.info("Sending email to: " + emailDTO.getTo());
    LOG.info("Email sent!");
  }
}
