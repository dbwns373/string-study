package com.pear.shop.Notice;

import com.pear.shop.Notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository  extends JpaRepository<Notice, Integer> {
}
