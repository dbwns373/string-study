package com.pear.shop.Member;
import com.pear.shop.Member.Member;
import com.pear.shop.Member.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public void saveMember(String username, String password, String displayname) {
    Member member = new Member();
    member.setUsername(username);
    member.setPassword(new BCryptPasswordEncoder().encode(password));
    member.setDisplayName(displayname);

    memberRepository.save(member);
  }
}
