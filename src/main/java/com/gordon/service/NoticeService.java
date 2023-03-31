package com.gordon.service;

import com.gordon.model.NoticeDetail;
import com.gordon.repository.NoticeDetailRepository;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeDetailRepository noticeDetailRepository;

  public ResponseEntity<List<NoticeDetail>> getAllNotices() {
    List<NoticeDetail> notices = noticeDetailRepository.findAllActiveNotices();
    if (notices.size() > 0) {
      return ResponseEntity.ok()
          .cacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES))
          .body(notices);
    } else {
      return null;
    }
  }
}
