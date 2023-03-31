package com.gordon.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A DTO for the {@link com.gordon.model.Loan} entity
 */
@AllArgsConstructor
@Getter
public class LoanDto implements Serializable {

  private final LocalDate startDt;
  private final String loanType;
  private final Integer totalLoan;
  private final Integer amountPaid;
  private final Integer outstandingAmount;
}