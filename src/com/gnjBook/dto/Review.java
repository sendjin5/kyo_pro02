package com.gnjBook.dto;

public class Review {
  private int rno;
  private String memId;
  private int payNo;
  private int star = 5;
  private String content;
  private String regdate;
  private int proNo;

  public Review() {
  }

  public Review(int rno, String memId, int payNo, int star, String content, String regdate, int proNo) {
    this.rno = rno;
    this.memId = memId;
    this.payNo = payNo;
    this.star = star;
    this.content = content;
    this.regdate = regdate;
    this.proNo = proNo;
  }

  public int getRno() {
    return rno;
  }

  public void setRno(int rno) {
    this.rno = rno;
  }

  public String getMemId() {
    return memId;
  }

  public void setMemId(String memId) {
    this.memId = memId;
  }

  public int getPayNo() {
    return payNo;
  }

  public void setPayNo(int payNo) {
    this.payNo = payNo;
  }

  public int getStar() {
    return star;
  }

  public void setStar(int star) {
    this.star = star;
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

  public int getProNo() {
    return proNo;
  }

  public void setProNo(int proNo) {
    this.proNo = proNo;
  }
}
