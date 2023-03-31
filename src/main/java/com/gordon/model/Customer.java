package com.gordon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

  @Id
  @Column(name = "customer_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String mobileNumber;

  @Column(nullable = false)
  private String email;

  // 让该字段只能写入数据库(deserialization), ask ChatGPT
  @JsonProperty(access = Access.WRITE_ONLY)
  @Column(nullable = false)
  private String pwd;

  @Column(nullable = false)
  private String role;

  @CreationTimestamp
  @Column(nullable = false)
  private Date createDt;

  @JsonIgnore()
  @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
  private Set<Authority> authority;
}
