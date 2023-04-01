package com.gordon.controller;

import com.gordon.model.Customer;
import com.gordon.service.CustomerService;
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

  private final CustomerService customerService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Customer customer) {
    return customerService.register(customer);
  }
}
