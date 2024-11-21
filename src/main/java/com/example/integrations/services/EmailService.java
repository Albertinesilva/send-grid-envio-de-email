package com.example.integrations.services;

import com.example.integrations.dto.EmailDTO;

public interface EmailService {
  
  void sendEmail(EmailDTO emailDTO);
}
