package com.pear.shop.Notice;

import com.pear.shop.Notice.Notice;
import com.pear.shop.Notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

  private final NoticeRepository noticeRepository;

  public List<Notice> findAll() {
    return noticeRepository.findAll();
  }
  public void saveNotice(String title) {
    Notice notice = new Notice();
    Date d = new Date();
    notice.setTitle(title);
    notice.setDate(d);
    noticeRepository.save(notice);// db저장

  }
}
