package com.gordon.repository;

import com.gordon.model.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

  public Optional<Account> findByCustomerId(Long customerId);
}