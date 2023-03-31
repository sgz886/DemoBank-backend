package com.gordon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_transaction")
public class AccountTransaction {

  @Id
  @Column(name = "transaction_id", nullable = false, length = 200)
  private String id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "account_number", nullable = false)
  private Account account;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "transaction_dt", nullable = false)
  private LocalDate transactionDt;

  @Column(name = "transaction_summary", nullable = false, length = 200)
  private String transactionSummary;

  @Column(name = "transaction_type", nullable = false, length = 100)
  private String transactionType;

  @Column(name = "transaction_amt", nullable = false)
  private Integer transactionAmt;

  @Column(name = "closing_balance", nullable = false)
  private Integer closingBalance;

  @Column(name = "create_dt")
  private LocalDate createDt;

}