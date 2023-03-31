package com.gordon.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A DTO for the {@link com.gordon.model.Card} entity
 */
@AllArgsConstructor
@Getter
public class CardDto implements Serializable {

  private final String cardNumber;
  private final String cardType;
  private final Integer totalLimit;
  private final Integer amountUsed;
  private final Integer availableAmount;
  private final LocalDate createDt;
}