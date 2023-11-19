package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public CartDAO() {
  }

  public List<Cart> getCartList(){
    conn = db.connect();
    List<Cart> cartList = new ArrayList<>();

    String sql = "select * from cart";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        cartList.add(new Cart(rs.getInt("cartNo"), rs.getString("memId"), rs.getInt("proNo"), rs.getInt("amount"),rs.getInt("price"),rs.getString("imgsrc1")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cartList;
  }

  public Cart getCart(int cart_no){
    conn = db.connect();
    Cart cart = new Cart();

    String sql = "select * from cart where cartNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cart_no);
      rs = pstmt.executeQuery();

      if(rs.next()){
        cart = new Cart(rs.getInt("cartNo"), rs.getString("memId"), rs.getInt("proNo"), rs.getInt("amount"),rs.getInt("price"),rs.getString("imgsrc1"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cart;
  }

  public int addCart(Cart cart){
    conn = db.connect();
    int cnt = 0;

    String sql = "insert into cart(memId, proNo, amount,price,imgsrc1) values(?, ?, ?,?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, cart.getMemId());
      pstmt.setInt(2, cart.getProNo());
      pstmt.setInt(3, cart.getAmount());
      pstmt.setInt(4,cart.getPrice());
      pstmt.setString(5, cart.getImgsrc1());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public int updateCart(Cart cart){
    conn = db.connect();
    int cnt = 0;

    String sql = "update cart set memId=?, proNo=?, amount=? where cartNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, cart.getMemId());
      pstmt.setInt(2, cart.getProNo());
      pstmt.setInt(3, cart.getAmount());
      pstmt.setInt(4, cart.getCartNo());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
  public int deleteCart(int cartno){
    conn = db.connect();
    int cnt = 0;

    String sql = "delete from cart where cartNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cartno);
      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs,pstmt, conn);
    }
    return cnt;
  }

  // 특정 회원의 장바구니 목록 가져오기
  public List<Cart> getMemberCartList(String memid){
    conn = db.connect();
    List<Cart> cartList = new ArrayList<>();

    String sql = "select * from cart where memId=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memid);

      rs = pstmt.executeQuery();

      while(rs.next()){
        cartList.add(new Cart(rs.getInt("cartNo"), rs.getString("memId"), rs.getInt("proNo"), rs.getInt("amount"),rs.getInt("price"),rs.getString("imgsrc1")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cartList;
  }
}
