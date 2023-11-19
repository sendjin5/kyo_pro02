package com.gnjBook.vo;

import com.gnjBook.dto.*;

public class PayVO {
  private Payment pay;
  private Product pro;
  private Delivery del;

  public PayVO() {
  }

  public Payment getPay() {
    return pay;
  }

  public void setPay(Payment pay) {
    this.pay = pay;
  }

  public Product getPro() {
    return pro;
  }

  public void setPro(Product pro) {
    this.pro = pro;
  }

  public Delivery getDel() {
    return del;
  }

  public void setDel(Delivery del) {
    this.del = del;
  }
}
