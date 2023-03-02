package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetailsService implements UserDetailsService {

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
