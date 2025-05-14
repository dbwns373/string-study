package com.pear.shop;

public class Age {
  private int humanage;
  private String name;
  public Age() {
    this.humanage = 0;
  }

  public String nameSet(String name) {
    this.name = name;
    return "이제부터 이 사람 이름은"+name+"입니다.";
  }
  public int agePlus() {
    if(100 <= humanage) {
      System.out.println("100살 이상입니다.");
      return 0;
    }

    return humanage+=1;
  }

  public int ageSetting(int setage){


    if (100 <= setage) { System.out.println("100살 이상입니다");
      return 0;
    }
    else if (setage < 0) {
      System.out.println("0살보다 위여야합니다.");
      return 0;
    }
    else {
      humanage = setage;
      return humanage;
    }
  }
  public int getAge() {
    return humanage;
  }
}
