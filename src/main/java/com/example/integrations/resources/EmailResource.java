package com.example.integrations.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrations.dto.EmailDTO;

@RestController
@RequestMapping(value = "/emails")
public class EmailResource {

  @PostMapping
  public ResponseEntity<Void> sendEmail(@RequestBody EmailDTO emailDTO) {
    return ResponseEntity.noContent().build();
  }
}