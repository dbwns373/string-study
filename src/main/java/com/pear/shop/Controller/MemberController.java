package com.pear.shop.Controller;

import com.pear.shop.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/signup")
  String signup() {
    new BCryptPasswordEncoder().encode("wkfka1");
    return "signup.html";
  }
@PostMapping("/join")
String join(@RequestParam String username, @RequestParam String password,@RequestParam String displayname){

    memberService.savemember(username,password,displayname);

    return "signup";
}
}
