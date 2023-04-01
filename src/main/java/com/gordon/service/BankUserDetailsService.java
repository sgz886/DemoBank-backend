package com.gordon.service;

import com.gordon.model.Customer;
import com.gordon.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * this is customized implementation of UserDetailsService
 * implement customized logic for login
 */
@Service
@RequiredArgsConstructor
public class BankUserDetailsService implements UserDetailsService {

  private final CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Customer customerFromDB = customerRepository.findByEmail(username).orElseThrow(
        () -> new UsernameNotFoundException(String.format("email not found for %s", username)));
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customerFromDB.getRole());
    return new User(customerFromDB.getEmail(),
        customerFromDB.getPwd(),
        List.of(authority));
  }
}
