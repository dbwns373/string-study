package com.pear.shop;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TipContorller {


  private final TipService tipService;
  @GetMapping("/tip") //
  String tip(Model model) {
    List<Tip> result = tipService.findAll();
    model.addAttribute("tip",result);
    return "tip.html";
  }
  @PostMapping("/tipadd")
  String tipPost(@RequestParam String sub,@RequestParam String description) {
    tipService.saveTip(sub,description);

    return "redirect:/tip";
  }

}
