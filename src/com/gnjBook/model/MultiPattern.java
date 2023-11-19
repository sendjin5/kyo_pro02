package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiPattern {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public MultiPattern() {
  }

  public void instock(Instock instock){
    int cnt = 0;
    InstockDAO instockDAO = new InstockDAO();
    cnt += instockDAO.inInstock(instock);
  }

  // 출고 처리. 트랜잭션이 필요하다.
  public int outstock(Payment payment, Delivery delivery, Cart cart){
    int payNo = 0;
    conn = db.connect();
    String sql = "";
    try {
      conn.setAutoCommit(false);
      int cnt = 0;

      // 출고 시 결제 기록
      sql = "insert into payment(memId, proNo, payPrice, amount, method, pcom, paccount) values(?, ?, ?, ?, ?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, payment.getMemId());
      pstmt.setInt(2, payment.getProNo());
      pstmt.setInt(3, payment.getPayPrice());
      pstmt.setInt(4, payment.getAmount());
      pstmt.setString(5, payment.getMethod());
      pstmt.setString(6, payment.getPcom());
      pstmt.setString(7, payment.getPaccount());
      cnt += pstmt.executeUpdate();

      // 출고 시 출고 기록
      sql = "insert into outstock(proNo, amount, outPrice) values(?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payment.getProNo());
      pstmt.setInt(2, payment.getAmount());
      pstmt.setInt(3, payment.getPayPrice());
      cnt += pstmt.executeUpdate();

      // 출고, 결제 시 결제 번호 반환
      sql = "select payNo from payment order by payNo desc limit 1";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if(rs.next()){
        payNo = rs.getInt("payNo");
      }

      sql = "insert into delivery(payNo, memId, address, tel, name, state) values (?, ?, ?, ?, ?, 0)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payNo);
      pstmt.setString(2, delivery.getMemId());
      pstmt.setString(3, delivery.getAddress());
      pstmt.setString(4, delivery.getTel());
      pstmt.setString(5, delivery.getName());
      cnt += pstmt.executeUpdate();

      // 출고 시 카트에서 삭제
      sql = "delete from cart where cartNo=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cart.getCartNo());
      cnt += pstmt.executeUpdate();


      conn.commit();
      conn.setAutoCommit(true);
    } catch (SQLException e) {
      try {
        conn.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

      throw new RuntimeException(e);
    }
    return payNo;
  }

  public int outstockProduct(Payment payment, Delivery delivery){
    int payNo = 0;
    conn = db.connect();
    String sql = "";
    try {
      conn.setAutoCommit(false);
      int cnt = 0;

      // 출고 시 결제 기록
      sql = "insert into payment(memId, proNo, payPrice, amount, method, pcom, paccount) values(?, ?, ?, ?, ?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, payment.getMemId());
      pstmt.setInt(2, payment.getProNo());
      pstmt.setInt(3, payment.getPayPrice());
      pstmt.setInt(4, payment.getAmount());
      pstmt.setString(5, payment.getMethod());
      pstmt.setString(6, payment.getPcom());
      pstmt.setString(7, payment.getPaccount());
      cnt += pstmt.executeUpdate();

      // 출고 시 출고 기록
      sql = "insert into outstock(proNo, amount, outPrice) values(?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payment.getProNo());
      pstmt.setInt(2, payment.getAmount());
      pstmt.setInt(3, payment.getPayPrice());
      cnt += pstmt.executeUpdate();

      // 출고, 결제 시 결제 번호 반환
      sql = "select payNo from payment order by payNo desc limit 1";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if(rs.next()){
        payNo = rs.getInt("payNo");
      }

      sql = "insert into delivery(payNo, memId, address, tel, name, state) values (?, ?, ?, ?, ?, 0)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payNo);
      pstmt.setString(2, delivery.getMemId());
      pstmt.setString(3, delivery.getAddress());
      pstmt.setString(4, delivery.getTel());
      pstmt.setString(5, delivery.getName());
      cnt += pstmt.executeUpdate();

      conn.commit();
      conn.setAutoCommit(true);
    } catch (SQLException e) {
      try {
        conn.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

      throw new RuntimeException(e);
    }
    return payNo;
  }

  public void refund(int payNo, int proNo){
    conn = db.connect();
    int cnt = 0;
    String sql = "";

    try {
      conn.setAutoCommit(false);

      // 반품 시 결제 취소
      sql = "delete from payment where payNo=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payNo);
      cnt += pstmt.executeUpdate();


      // 반품 시 출고 취소
      sql = "delete from outstock where proNo=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      cnt += pstmt.executeUpdate();

      // 반품 시 배송 삭제
      sql = "delete from delivery where payNo=?";
      pstmt.setInt(1, payNo);
      cnt += pstmt.executeUpdate();

      conn.commit();
      conn.setAutoCommit(true);
    } catch (SQLException e) {
      try {
        conn.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }

      throw new RuntimeException(e);
    }
  }

}
