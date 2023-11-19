package com.gnjBook.dto;

public class Cart {
  private int cartNo;
  private String memId;
  private int proNo;
  private int amount;
  private int price;
  private String imgsrc1;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getImgsrc1() {
    return imgsrc1;
  }

  public void setImgsrc1(String imgsrc1) {
    this.imgsrc1 = imgsrc1;
  }

  public Cart() {
  }

  public Cart(int cartNo, String memId, int proNo, int amount, int price, String imgsrc1) {
    this.cartNo = cartNo;
    this.memId = memId;
    this.proNo = proNo;
    this.amount = amount;
    this.price = price;
    this.imgsrc1 = imgsrc1;
  }

  public int getCartNo() {
    return cartNo;
  }

  public void setCartNo(int cartNo) {
    this.cartNo = cartNo;
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

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
