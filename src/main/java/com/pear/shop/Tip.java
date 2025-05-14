package com.pear.shop;

import jakarta.persistence.*;

@Entity
@Table(name = "tip")
public class Tip {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 아이디 증감


  private Integer id;
  @Column
  private String sub;
  private String description;

  public String getSub() {
    return sub;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if(description.length() < 1000) // 이거 기호 거꾸로 해뒀다가 오류 한참 찾음;
      this.description = description;
  }

  public void setSub(String sub) {
    if(sub.length() < 1000)
      this.sub = sub;
  }

}
