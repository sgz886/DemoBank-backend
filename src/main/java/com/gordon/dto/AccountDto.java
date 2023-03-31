package com.gordon.dto;

import com.gordon.model.Account;
import java.io.Serializable;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A DTO for the {@link Account} entity
 */
@AllArgsConstructor
@Getter
public class AccountDto implements Serializable {

  private final String accountType;
  private final String branchAddress;
  private final OffsetDateTime createDt;
}