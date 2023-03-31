package com.gordon.service;

import com.gordon.model.Customer;
import com.gordon.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public ResponseEntity<String> register(Customer customer) {
    ResponseEntity<String> response = null;
    // omitted check if user is already registered
    try {
      // hash password before storing
      String hashedPwd = passwordEncoder.encode(customer.getPwd());
      customer.setPwd(hashedPwd);
      Customer savedCustomer = customerRepository.save(customer);
      if (savedCustomer.getId() > 0) {
        response = ResponseEntity.status(HttpStatus.CREATED)
            .body("Given user details registered successfully");
      }
    } catch (Exception ex) {
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An exception occured due to " + ex.getMessage());
    }
    return response;
  }
}
