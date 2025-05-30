package com.pear.shop.Member;

import jakarta.persistence.*;

@Entity
public class Member {


  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 아이디 증감
  private Integer id;
  @Column(nullable = false,unique = true)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String displayName;

}
