package com.pear.shop.Notice;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Notice {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  public String getTitle() {
    return title;
  }

  public Date getDate() {
    return date;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Column
  private String title;
  private Date date;
}
