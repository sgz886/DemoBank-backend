package com.gordon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Entity
@Table(name = "contact_message")
public class ContactMessage {

  @Id
  @Column(name = "contact_id", nullable = false, length = 50)
  private String id;

  @Column(name = "contact_name", nullable = false, length = 50)
  private String contactName;

  @Column(name = "contact_email", nullable = false, length = 100)
  private String contactEmail;

  @Column(name = "subject", nullable = false, length = 500)
  private String subject;

  @Column(name = "message", nullable = false, length = 2000)
  private String message;

  @CreationTimestamp
  @Column(name = "create_dt")
  private OffsetDateTime createDt;

}