package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Member;
import com.gnjBook.dto.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public ProductDAO() {
  }

  public List<Product> getProductListmain(){
    conn = db.connect();
    List<Product> productList = new ArrayList<>();

    String sql = "select * from product limit 0, 8";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        productList.add(new Product(
                rs.getInt("proNo"),
                rs.getString("categoryId"),
                rs.getString("procategory"),
                rs.getInt("price"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("content"),
                rs.getString("img"),
                regdate, rs.getString("video")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return productList;
  }


  public List<Product> getProductList(){
    conn = db.connect();
    List<Product> productList = new ArrayList<>();

    String sql = "select * from product";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        productList.add(new Product(
                rs.getInt("proNo"),
                rs.getString("categoryId"),
                rs.getString("procategory"),
                rs.getInt("price"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("content"),
                rs.getString("img"),
                regdate, rs.getString("video")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return productList;
  }

  public Product getProduct(int proNo){
    conn = db.connect();
    Product product = new Product();

    String sql = "select * from product where proNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        product = new Product(
                rs.getInt("proNo"),
                rs.getString("categoryId"),
                rs.getString("procategory"),
                rs.getInt("price"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("content"),
                rs.getString("img"),
                regdate,
                rs.getString("video"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return product;
  }

  public int addProduct(Product product){
    conn = db.connect();
    int cnt = 0;

    Product product1 = new Product();

    String sql = "insert into product(categoryId, title, author, price, content, img, video) values(?, ?, ?, ?, ?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, product.getCategoryId());
      pstmt.setString(2, product.getTitle());
      pstmt.setString(3, product.getAuthor());
      pstmt.setInt(4, product.getPrice());
      pstmt.setString(5, product.getContent());
      pstmt.setString(6, product.getImg());
      pstmt.setString(7, product.getVideo());

      cnt = pstmt.executeUpdate();

      pstmt.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    sql = "SELECT * FROM product ORDER BY regdate DESC LIMIT 1";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if(rs.next()) {
        product1.setProNo(rs.getInt("proNo"));
      }
      rs.close();
      pstmt.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    sql = "insert into instock(proNo, amount, inPrice) values(?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, product1.getProNo());
      pstmt.setInt(2, 0);
      pstmt.setInt(3, 0);
      cnt += pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    sql = "insert into outstock(proNo, amount, outPrice) values(?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, product1.getProNo());
      pstmt.setInt(2, 0);
      pstmt.setInt(3, 0);
      cnt += pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  public int updateProduct(Product product){
    conn = db.connect();
    int cnt = 0;

    String sql = "update product set categoryId=?, price=?, title=?, author=?, content=? where proNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, product.getCategoryId());
      pstmt.setInt(2, product.getPrice());
      pstmt.setString(3, product.getTitle());
      pstmt.setString(4, product.getAuthor());
      pstmt.setString(5, product.getContent());
      pstmt.setInt(6, product.getProNo());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public int deleteProduct(int proNo){
    conn = db.connect();
    int cnt = 0;

    String sql = "delete from product where proNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }


  public List<Product> getCategoryProduct(String categoryId){
      conn = db.connect();
      List<Product> productList = new ArrayList<>();

      String sql = "select * from product where categoryId=?";
      try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, categoryId);
        rs = pstmt.executeQuery();

        while(rs.next()){
          String regdate = sdf.format(rs.getDate("regdate"));

          productList.add(new Product(
                  rs.getInt("proNo"),
                  rs.getString("categoryId"),
                  rs.getString("procategory"),
                  rs.getInt("price"),
                  rs.getString("title"),
                  rs.getString("author"),
                  rs.getString("content"),
                  rs.getString("img"),
                  rs.getString("video"),
                  regdate));
        }

      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally{
        db.close(rs, pstmt, conn);
      }

      return productList;
    }

    // 해당 상품의 재고 수량을 가져옴
  public int getAmount(int proNo){
    int amount = 0;
    conn = db.connect();

    String sql = "select * from inventory where proNo = ?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      rs = pstmt.executeQuery();
      if(rs.next()){
        amount = rs.getInt("amount");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      db.close(rs, pstmt, conn);
    }

    return amount;
  }
}
