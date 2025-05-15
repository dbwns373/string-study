package com.pear.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;


@Controller
public class BasicContorller {
  @GetMapping("/")     // url 넣어도되고
  String hello() {
    return "index.html";      //  파일명 써도되고
  }

  @GetMapping("/about")
  @ResponseBody
  String about() {
    return "뭐하러 알게";
  }

  @GetMapping("/date")
  @ResponseBody
  String date() {
    return ZonedDateTime.now().toString();
  }


}

