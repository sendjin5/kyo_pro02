package com.gnjBook.dto;

public class Fileboard {
    private int no;
    private String title;
    private String content;
    private String regdate;
    private int visited;
    private String filename1;
    private String filename2;
    private String filename3;

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

    public String getFilename1() {
        return filename1;
    }

    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename3() {
        return filename3;
    }

    public void setFilename3(String filename3) {
        this.filename3 = filename3;
    }

    @Override
    public String toString() {
        return "Fileboard{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regdate='" + regdate + '\'' +
                ", visited=" + visited +
                ", filename1='" + filename1 + '\'' +
                ", filename2='" + filename2 + '\'' +
                ", filename3='" + filename3 + '\'' +
                '}';
    }
}
