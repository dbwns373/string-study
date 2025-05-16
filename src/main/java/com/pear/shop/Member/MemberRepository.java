package com.pear.shop.Member;

import com.pear.shop.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface MemberRepository extends JpaRepository<Member, Integer> {//entity,타입 적기
// findAll은 username컬럼과 일치하는 username변수에 들어간거 다 찾아줌 대신 리스트로 담아야함. 다찾아오니까!
  Optional<Member> findByUsername(String username);//derived query method
}