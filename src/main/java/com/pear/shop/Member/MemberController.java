package com.pear.shop.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Authenticator;

@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/signup") // 회원가입
  String signup() {
    new BCryptPasswordEncoder().encode("wkfka1");
    return "signup.html";
  }

  @GetMapping("/login") // 로그인
  String login() {


    return "login.html";
  }

@PostMapping("/join")
String join(@RequestParam String username, @RequestParam String password,@RequestParam String displayname){

    memberService.saveMember(username,password,displayname);

    return "signup";

}

  @GetMapping("mypage")
  String myPage(Authentication auth) {

    System.out.println(auth); // 계정
    System.out.println(auth.getName());  // 계정 이름
    System.out.println(auth.isAuthenticated()); // 로그인 여부 (true/false)

    return "mypage.html";
  }

}
