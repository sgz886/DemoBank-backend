package com.gordon.controller;

import com.gordon.model.ContactMessage;
import com.gordon.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ContactController {

  private final ContactService contactService;
  @PostMapping("/contact")
  public ContactMessage saveContactMessage(@RequestBody ContactMessage message) {
    return contactService.saveContactInquiryDetails(message);
  }
}
