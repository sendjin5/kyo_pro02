package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public BookDAO() {
  }

  public List<Book> getBookList(){
    conn = db.connect();
    List<Book> bookList = new ArrayList<>();

    String sql = "select * from book";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        bookList.add(new Book(rs.getInt("proNo"), rs.getInt("bookNo"), rs.getString("publish"), rs.getString("author"), rs.getString("title"), rs.getString("content"), rs.getString("img"), rs.getString("video")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return bookList;
  }

  public Book getBook(int bookNo){
    conn = db.connect();
    Book book = new Book();

    String sql = "select * from book where bookNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, bookNo);
      rs = pstmt.executeQuery();

      if(rs.next()){
        book = new Book(rs.getInt("proNo"), rs.getInt("bookNo"), rs.getString("publish"), rs.getString("author"), rs.getString("title"), rs.getString("content"), rs.getString("img"), rs.getString("video"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return book;
  }

  public int addBook(Book book){
    conn = db.connect();
    int cnt = 0;

    String sql = "insert into book(proNo, publish, author, title, content, img, video) values(?, ?, ?, ?, ?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, book.getProNo());
      pstmt.setString(2, book.getPublish());
      pstmt.setString(3, book.getAuthor());
      pstmt.setString(4, book.getTitle());
      pstmt.setString(5, book.getContent());
      pstmt.setString(6, book.getImg());
      pstmt.setString(7, book.getVideo());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public int updateProduct(Book book){
    conn = db.connect();
    int cnt = 0;

    String sql = "update book set proNo, publish, author, title, content, img, video where bookNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, book.getProNo());
      pstmt.setString(2, book.getPublish());
      pstmt.setString(3, book.getAuthor());
      pstmt.setString(4, book.getTitle());
      pstmt.setString(5, book.getContent());
      pstmt.setString(6, book.getImg());
      pstmt.setString(7, book.getVideo());
      pstmt.setInt(8, book.getBookNo());


      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
  public int deleteBook(int bookNo){
    conn = db.connect();
    int cnt = 0;

    String sql = "delete from book where bookNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, bookNo);

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
  public Book getProductBook(int proNo){
    conn = db.connect();
    Book book = new Book();

    String sql = "select * from book where proNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      rs = pstmt.executeQuery();

      if(rs.next()){
        book = new Book(rs.getInt("proNo"), rs.getInt("bookNo"), rs.getString("publish"), rs.getString("author"), rs.getString("title"), rs.getString("content"), rs.getString("img"), rs.getString("video"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return book;
  }
}
