package com.gnjBook.dto;

public class Payment {
  private int payNo;
  private String memId;
  private int proNo;
  private int payPrice;
  private int amount = 1;
  private String method;
  private String pcom;
  private String paccount;
  private int dno;

  public Payment() {
  }

  public Payment(int payNo, String memId, int proNo, int payPrice, int amount, String method, String pcom, String paccount, int dno) {
    this.payNo = payNo;
    this.memId = memId;
    this.proNo = proNo;
    this.payPrice = payPrice;
    this.amount = amount;
    this.method = method;
    this.pcom = pcom;
    this.paccount = paccount;
    this.dno = dno;
  }

  public int getPayNo() {
    return payNo;
  }

  public void setPayNo(int payNo) {
    this.payNo = payNo;
  }

  public String getMemId() {
    return memId;
  }

  public void setMemId(String memId) {
    this.memId = memId;
  }

  public int getProNo() {
    return proNo;
  }

  public void setProNo(int proNo) {
    this.proNo = proNo;
  }

  public int getPayPrice() {
    return payPrice;
  }

  public void setPayPrice(int payPrice) {
    this.payPrice = payPrice;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPcom() {
    return pcom;
  }

  public void setPcom(String pcom) {
    this.pcom = pcom;
  }

  public String getPaccount() {
    return paccount;
  }

  public void setPaccount(String paccount) {
    this.paccount = paccount;
  }

  public int getDno() {
    return dno;
  }

  public void setDno(int dno) {
    this.dno = dno;
  }
}
