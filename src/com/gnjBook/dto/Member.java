package com.gnjBook.dto;

public class Member {
  private String id;
  private String pw;
  private String name;
  private String email;
  private String tel;
  private String birth;
  private String address;
  private String postcode;
  private String regdate;
  private int point = 0;
  private String grade = "F";

  public Member() {
  }

  public Member(String id, String pw, String name, String email, String tel, String birth, String address, String postcode, String regdate, int point, String grade) {
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.birth = birth;
    this.address = address;
    this.postcode = postcode;
    this.regdate = regdate;
    this.point = point;
    this.grade = grade;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRegdate() {
    return regdate;
  }

  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }
}
