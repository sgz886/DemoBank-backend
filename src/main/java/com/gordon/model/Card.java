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
@Table(name = "card")
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "card_id", nullable = false)
  private Long id;

  @Column(name = "card_number", nullable = false, length = 100)
  private String cardNumber;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "card_type", nullable = false, length = 100)
  private String cardType;

  @Column(name = "total_limit", nullable = false)
  private Integer totalLimit;

  @Column(name = "amount_used", nullable = false)
  private Integer amountUsed;

  @Column(name = "available_amount", nullable = false)
  private Integer availableAmount;

  @Column(name = "create_dt")
  private LocalDate createDt;

}