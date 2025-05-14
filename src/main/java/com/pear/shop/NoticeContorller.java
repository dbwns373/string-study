package com.pear.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeContorller {

  private final NoticeService noticeService;
  @GetMapping("/noti")
  String noti(Model model) {
    List<Notice> result = noticeService.findAll();
    model.addAttribute("lists",result); //"전달할 데이터이름"," 데이터"

    return "noti.html";
  }

  @GetMapping("/noticeWrite")
  String write(Model model) {
    return "noticeWrite.html";
  }

  @PostMapping("/notiadd")
  String addPost(@RequestParam String title) {
    noticeService.saveNotice(title);
    return "redirect:/noti";
  }
}
