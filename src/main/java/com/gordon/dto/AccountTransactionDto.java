package com.gordon.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A DTO for the {@link com.gordon.model.AccountTransaction} entity
 */
@AllArgsConstructor
@Getter
public class AccountTransactionDto implements Serializable {

  private final LocalDate transactionDt;
  private final String transactionSummary;
  private final String transactionType;
  private final Integer transactionAmt;
  private final Integer closingBalance;
}