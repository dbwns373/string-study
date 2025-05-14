package com.pear.shop;

import jakarta.persistence.*;

@Entity  //독립체(?) 테이블 만들어주는거
public class Item {

  /*
  ID getter 없어서 링크 만들때 db에서 id 못꺼낸다는거에서 고생함;
  getter 만들자..;
   */
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 아이디 증감
  private Integer id;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(nullable = false,unique = true)
  private String title;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  private int price;
}


