package com.gordon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_number")
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "account_type", nullable = false, length = 100)
  private String accountType;

  @Column(name = "branch_address", length = 200)
  private String branchAddress;

  @Column(name = "create_dt", nullable = false)
  private OffsetDateTime createDt;

}