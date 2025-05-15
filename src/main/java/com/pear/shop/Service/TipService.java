package com.pear.shop.Service;

import com.pear.shop.Composition.Tip;
import com.pear.shop.Repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class TipService {

  private final TipRepository tipRepository;

  public void saveTip(String sub , String description) {
    Tip tip = new Tip();
    tip.setSub(sub);
    tip.setDescription(description);
    tipRepository.save(tip);
  }
  public List<Tip> findAll() {
    return tipRepository.findAll();
  }

}
