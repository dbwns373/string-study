package com.pear.shop.Member;

import com.pear.shop.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MemberRepository extends JpaRepository<Member, Integer> {//entity,타입 적기

}