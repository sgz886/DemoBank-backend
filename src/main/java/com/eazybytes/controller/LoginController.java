package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired
  CustomerRepository customerRepository;

  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Customer customer) {
    ResponseEntity<String> response = null;
    try {
      Customer savedCustomer = customerRepository.save(customer);
      if (savedCustomer.getId() > 0) {
        ResponseEntity.status(HttpStatus.CREATED)
            .body("Given user details are successfully registed");
      }
    } catch (Exception ex) {
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An exception occured due to " + ex.getMessage());
    }
    return response;
  }
}
