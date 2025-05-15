package com.pear.shop.Repository;

import com.pear.shop.Composition.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {//entity,타입 적기

}

