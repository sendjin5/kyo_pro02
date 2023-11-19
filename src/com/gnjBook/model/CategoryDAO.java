package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public CategoryDAO() {
  }

  public List<Category> getCategoryList(){
    conn = db.connect();
    List<Category> categoryList = new ArrayList<>();

    String sql = "select * from category";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        categoryList.add(new Category(rs.getString("categoryId"), rs.getString("categoryName")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return categoryList;
  }

  public Category getCategory(String id){
    conn = db.connect();
    Category category = new Category();

    String sql = "select * from category where categoryId=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if(rs.next()){
        category = new Category(rs.getString("categoryId"), rs.getString("categoryName"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return category;
  }

  public int addCategory(Category cate){
    conn = db.connect();
    int cnt = 0;

    String sql = "insert into category(categoryId, categoryName) values(?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, cate.getCategoryId());
      pstmt.setString(2, cate.getCategoryName());
      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public int updateCategory(Category category){
    conn = db.connect();
    int cnt = 0;

    String sql = "update category set categoryName=? where categoryId=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, category.getCategoryName());
      pstmt.setString(2, category.getCategoryId());
      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
  public int deleteCategory(String id){
    conn = db.connect();
    int cnt = 0;

    String sql = "delete from category where categoryId=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
}
