package com.gordon.repository;

import com.gordon.model.NoticeDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeDetailRepository extends JpaRepository<NoticeDetail, Integer> {

  @Query("from NoticeDetail where CURRENT DATE between noticeBegDt and noticeEndDt")
  List<NoticeDetail> findAllActiveNotices();
}