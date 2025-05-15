package com.pear.shop.Service;

import com.pear.shop.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  void saveMember(String username, String password, String displayname) {
    memberRepository.save(username,password,displayname);
  }
}
