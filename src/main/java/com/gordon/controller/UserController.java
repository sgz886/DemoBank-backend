package com.gordon.controller;

import com.gordon.model.Customer;
import com.gordon.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final CustomerService customerService;

  @GetMapping("/user")
  public Customer getUserDetailAfterLogin(Authentication authentication) {
    return customerService.getUserDetailAfterLogin(authentication);
  }
}
