package com.gordon.repository;

import com.gordon.model.AccountTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {

  List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(Long customerId);
}