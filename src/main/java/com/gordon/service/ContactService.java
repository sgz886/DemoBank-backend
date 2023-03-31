package com.gordon.service;

import com.gordon.model.ContactMessage;
import com.gordon.repository.ContactMessageRepository;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ContactService {

  private final ContactMessageRepository contactMessageRepository;

  public ContactMessage saveContactInquiryDetails(ContactMessage message) {
    message.setId(getServiceReqNumber());
    return contactMessageRepository.save(message);
  }

  private String getServiceReqNumber() {
    Random random = new Random();
    int ranNum = random.nextInt(999999999 - 9999) + 9999;
    return "SR"+ranNum;
  }
}
