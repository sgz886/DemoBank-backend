package com.gordon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notice_detail")
public class NoticeDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_id", nullable = false)
  private Integer id;

  @Column(name = "notice_summary", nullable = false, length = 200)
  private String noticeSummary;

  @Column(name = "notice_details", nullable = false, length = 500)
  private String noticeDetails;

  @Column(name = "notice_beg_dt", nullable = false)
  private LocalDate noticeBegDt;

  @Column(name = "notice_end_dt")
  private LocalDate noticeEndDt;

  @Column(name = "create_dt")
  private LocalDate createDt;

  @Column(name = "update_dt")
  private LocalDate updateDt;

}