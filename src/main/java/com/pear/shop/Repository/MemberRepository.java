package com.pear.shop.Repository;

import com.pear.shop.Composition.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
