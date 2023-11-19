package com.gnjBook.dto;

public class Notice {
  private int no;
  private String title;
  private String content;
  private String regdate;
  private int visited = 0;

  public Notice() {
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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

  public String getResdate() {
    return regdate;
  }

  public void setResdate(String regdate) {
    this.regdate = regdate;
  }

  public int getVisited() {
    return visited;
  }

  public void setVisited(int visited) {
    this.visited = visited;
  }

  public Notice(int no, String title, String content, String regdate, int visited) {
    this.no = no; this.title = title; this.content = content; this.regdate = regdate; this.visited = visited;
  }
}
