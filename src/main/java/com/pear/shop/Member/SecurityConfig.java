package com.pear.shop.Member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean // 모든 유저의 요청과 서버의 응답 사이에 자동으로 실행해주고 싶은 코드 담는곳
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable()); // csrf공격방지 기능 off하는 코드
    http.authorizeHttpRequests((authorize) ->
        authorize.requestMatchers("/**").permitAll()//permitAll = 로그인 해제
    );
    http.formLogin((formLogin) -> formLogin.loginPage("/login") //로그인을 위한 폼은 어딨냐
        .defaultSuccessUrl("/list") // 로그인 성공했을때 이동할 url
        .failureUrl("/login?error=ture") // 로그인 실패했을때 이동할 url
    );
    http.logout( logout -> logout.logoutUrl("/logout")
        .logoutUrl("/index")
    );

    return http.build();
  }
}

