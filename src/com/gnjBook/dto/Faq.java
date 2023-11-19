package com.gnjBook.dto;

public class Faq {
  private int fno;
  private String title;
  private String content;
  private String regdate;

  public Faq() {
  }

  public Faq(int fno, String title, String content, String regdate) {
    this.fno = fno;
    this.title = title;
    this.content = content;
    this.regdate = regdate;
  }

  public int getFno() {
    return fno;
  }

  public void setFno(int fno) {
    this.fno = fno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getRegdate() {
    return regdate;
  }

  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
}
