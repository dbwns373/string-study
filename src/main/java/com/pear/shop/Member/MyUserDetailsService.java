package com.pear.shop.Member;

import com.pear.shop.Member.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//***********DB에 있던 유저 정보 꺼내는 코드 ***********
@Service
  public class MyUserDetailsService implements UserDetailsService {
  private final MemberRepository memberRepository;

  public MyUserDetailsService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //   DB에서 username을 가진 유저를 찾아와서
    //   return new user (유저아이디, 비번, 권한)

    Optional<Member> result = memberRepository.findByUsername(username);
    if(result.isEmpty()) {
      throw new UsernameNotFoundException("그런 아이디 없다");
    }
    var user = result.get();
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("일반유저"));
    return new User(user.getUsername(),user.getPassword(), authorities);
  }
}
