package com.pear.shop.Controller;

import com.pear.shop.Composition.Item;
import com.pear.shop.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// html로 정보를 전송하는 클래스
@Controller  // <-- 이런 꼴을 이노테이션이라고 함
@RequiredArgsConstructor
public class ItemContorller {
//  public ItemContorller(ItemRepository itemRepository) {
//    this.itemRepository = itemRepository;
//    }
  // ** Lombok 써서 생략된 코드 원래는 이거 써야함

  private final ItemService itemService; // 이 또한 롬북이 해줘서 생성자 없이 되는거;;아니면 만들어줘야함
  // Dependency Injection 이란것 알아두기


  @GetMapping("/list")
  String list(Model model) {
    List<Item> result = itemService.findAll(); //DB에서 모든아이템가져옴
    // 뷰로 데이터를 보냄
    model.addAttribute("items",result); //"전달할 데이터이름"," 데이터"
    return "list.html";
  }


  // 읽고 데이터베이스에 추가하는 기능
  @GetMapping("/write")
  String write() {
    return "write.html";
  }
  @PostMapping("/add") // POST 받아서 title, price파라미터로 순서대로 넣어줌
  String addPost(@RequestParam String title, @RequestParam Integer price) {

    itemService.saveItem(title,price); // DB에 저장해주는 것
    return "redirect:/list";
  }
  // 상세페이지 Contorller
  @GetMapping("/detail/{id}") // id 변수 클라이언트가 친 값 파라미터로 줌
  String detail(@PathVariable Integer id,Model model) { // id = 클라이언트가 친 숫자를 파라미터로 가져옴 (인풋)
    Optional<Item> result = itemService.deepSearch(id);

    if(result.isPresent()) { // optional은 비어있으면 서버멈춰서 검사함수가 필요함!!
      model.addAttribute("item",result.get());
    }
    else {
      return "redirect:/list";
    }
    return "detail";
  }

/*
   view에서 edit.html에 수정버튼 만듬
-> 수정 누르면 GetMapping에 의해 edit/{id}로 접속
-> @PathVariable로 id값 가져옴
-> deepSearch는 id값 주면 title,price값이 나옴
 */
  @GetMapping("/edit/{id}") // id 변수 클라이언트가 친 값 파라미터로 줌
  String edit(@PathVariable Integer id,Model model) { // id = 클라이언트가 친 숫자를 파라미터로 가져옴 (인풋)
    Optional<Item> result = itemService.deepSearch(id);

    if(result.isPresent()) { // optional은 비어있으면 서버멈춰서 검사함수가 필요함!!
      model.addAttribute("item",result.get());
    }
    else {
      return "redirect:/list";
    }
    return "edit";
  }
  @PostMapping("/update")
  String edit(@RequestParam Integer id ,@RequestParam String title,@RequestParam Integer price) {

    itemService.updateItem(id, title, price);
    return "redirect:/list";
  }

  @DeleteMapping("/item")
  ResponseEntity<String> delete(@RequestParam Integer id) {
    System.out.println(id);
    itemService.deleteItem(id);
    return ResponseEntity.status(200).body("삭제완료");
  }

@ExceptionHandler(Exception.class)
  public ResponseEntity<String> handler() {
    return ResponseEntity.status(400).body("에러났음");
  }
}
