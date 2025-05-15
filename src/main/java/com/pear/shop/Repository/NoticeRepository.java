package com.pear.shop.Repository;

import com.pear.shop.Composition.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository  extends JpaRepository<Notice, Integer> {
}
