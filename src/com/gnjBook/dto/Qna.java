package com.gnjBook.dto;

public class Qna {
  private int qno;
  private String title;
  private String content;
  private String author;
  private String regdate;
  private int visited = 0;
  private int lev = 0;
  private int par;
  private boolean secret = false;

  public Qna() {
  }

  public Qna(int qno, String title, String content, String author, String regdate, int visited, int lev, int par, boolean secret) {
    this.qno = qno;
    this.title = title;
    this.content = content;
    this.author = author;
    this.regdate = regdate;
    this.visited = visited;
    this.lev = lev;
    this.par = par;
    this.secret = secret;
  }

  public int getQno() {
    return qno;
  }

  public void setQno(int qno) {
    this.qno = qno;
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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getRegdate() {
    return regdate;
  }

  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }

  public int getVisited() {
    return visited;
  }

  public void setVisited(int visited) {
    this.visited = visited;
  }

  public int getLev() {
    return lev;
  }

  public void setLev(int lev) {
    this.lev = lev;
  }

  public int getPar() {
    return par;
  }

  public void setPar(int par) {
    this.par = par;
  }

  public boolean isSecret() {
    return secret;
  }

  public void setSecret(boolean secret) {
    this.secret = secret;
  }
}
