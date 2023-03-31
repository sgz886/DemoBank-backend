package com.gordon.controller;

import com.gordon.model.Customer;
import com.gordon.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * register
 */
@RequiredArgsConstructor
@RestController
public class RegisterController {

  private final RegisterService registerService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Customer customer) {
    return registerService.register(customer);
  }
}
