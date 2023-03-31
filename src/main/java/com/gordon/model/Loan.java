package com.gordon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "loan")
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "loan_number", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "start_dt", nullable = false)
  private LocalDate startDt;

  @Column(name = "loan_type", nullable = false, length = 100)
  private String loanType;

  @Column(name = "total_loan", nullable = false)
  private Integer totalLoan;

  @Column(name = "amount_paid", nullable = false)
  private Integer amountPaid;

  @Column(name = "outstanding_amount", nullable = false)
  private Integer outstandingAmount;

  @Column(name = "create_dt")
  private LocalDate createDt;

}