package com.gnjBook.dto;

public class Book {
  private int proNo;
  private int bookNo;
  private String publish;
  private String author;
  private String title;
  private String content;
  private String img;
  private String video;

  public Book() {
  }

  public Book(int proNo, int bookNo, String publish, String author, String title, String content, String img, String video) {
    this.proNo = proNo;
    this.bookNo = bookNo;
    this.publish = publish;
    this.author = author;
    this.title = title;
    this.content = content;
    this.img = img;
    this.video = video;
  }

  public int getProNo() {
    return proNo;
  }

  public void setProNo(int proNo) {
    this.proNo = proNo;
  }

  public int getBookNo() {
    return bookNo;
  }

  public void setBookNo(int bookNo) {
    this.bookNo = bookNo;
  }

  public String getPublish() {
    return publish;
  }

  public void setPublish(String publish) {
    this.publish = publish;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
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

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }
}

