package com.pear.shop.Service;

import com.pear.shop.Composition.Item;
import com.pear.shop.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  public void saveItem(String title, Integer price) {
    Item item = new Item();
    item.setTitle(title);
    item.setPrice(price);
    itemRepository.save(item);
  }
  public List<Item> findAll() {
    return itemRepository.findAll();
  }
  public Optional<Item> deepSearch(Integer id) {
    return itemRepository.findById(id);
  }
  public void updateItem(Integer id,String title, Integer price){
    Item item = new Item();
    item.setId(id);
    item.setTitle(title);
    item.setPrice(price);
    itemRepository.save(item);
  }
  public void deleteItem(Integer id) {

    itemRepository.deleteById(id);
  }
}
