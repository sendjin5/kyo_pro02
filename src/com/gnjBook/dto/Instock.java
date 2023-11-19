package com.gnjBook.dto;

public class Instock {
  private int inNo;
  private int proNo;
  private int amount = 0;
  private int inPrice = 0;
  private String regdate;

  public Instock() {
  }

  public Instock(int inNo, int proNo, int amount, int inPrice, String regdate) {
    this.inNo = inNo;
    this.proNo = proNo;
    this.amount = amount;
    this.inPrice = inPrice;
    this.regdate = regdate;
  }

  public int getInNo() {
    return inNo;
  }

  public void setInNo(int inNo) {
    this.inNo = inNo;
  }

  public int getProNo() {
    return proNo;
  }

  public void setProNo(int proNo) {
    this.proNo = proNo;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getInPrice() {
    return inPrice;
  }

  public void setInPrice(int inPrice) {
    this.inPrice = inPrice;
  }

  public String getRegdate() {
    return regdate;
  }

  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
}
