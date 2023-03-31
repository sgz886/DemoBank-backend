package com.gordon.controller;

import com.gordon.model.NoticeDetail;
import com.gordon.service.NoticeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NoticeController {

  private final NoticeService noticeService;

  @GetMapping("/notices")
  public ResponseEntity<List<NoticeDetail>> getNotices() {
    return noticeService.getAllNotices();
  }
}
