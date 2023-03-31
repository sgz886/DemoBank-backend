package com.gordon.repository;

import com.gordon.model.Loan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

  List<Loan> findByCustomerId(Long id);

}