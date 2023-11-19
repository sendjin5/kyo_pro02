package com.gnjBook.dto;

public class Outstock {
  private int outNo;
  private int proNo;
  private int amount = 0;
  private int outPrice = 0;
  private String regdate;

  public Outstock() {
  }

  public Outstock(int out_no, int pro_no, int amount, int out_price, String regdate) {
    this.outNo = out_no;
    this.proNo = pro_no;
    this.amount = amount;
    this.outPrice = out_price;
    this.regdate = regdate;
  }

  public int getOutNo() {
    return outNo;
  }

  public void setOutNo(int outNo) {
    this.outNo = outNo;
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

  public int getOutPrice() {
    return outPrice;
  }

  public void setOutPrice(int outPrice) {
    this.outPrice = outPrice;
  }

  public String getRegdate() {
    return regdate;
  }

  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
}
