package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Instock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InstockDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public InstockDAO() {
  }

  public List<Instock> getInstockList(){
    conn = db.connect();
    List<Instock> instockList = new ArrayList<>();

    String sql = "select * from instock";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        instockList.add(new Instock(rs.getInt("inNo"), rs.getInt("proNo"), rs.getInt("amount"), rs.getInt("inPrice"), regdate));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return instockList;
  }

  public Instock getInstock(int inNo){
    conn = db.connect();
    Instock instock = new Instock();

    String sql = "select * from instock where inNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, inNo);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        instock = new Instock(rs.getInt("inNo"), rs.getInt("proNo"), rs.getInt("amount"), rs.getInt("inPrice"), regdate);
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return instock;
  }

  public int addInstock(Instock instock){
    conn = db.connect();
    int cnt = 0;

    String sql = "insert into instock(proNo, amount, inPrice) values(?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, instock.getProNo());
      pstmt.setInt(2, instock.getAmount());
      pstmt.setInt(3, instock.getInPrice());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public int updateInstock(Instock instock){
    conn = db.connect();
    int cnt = 0;

    String sql = "update instock set proNo=?, amount=?, inPrice=? where inNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, instock.getProNo());
      pstmt.setInt(2, instock.getAmount());
      pstmt.setInt(3, instock.getInPrice());
      pstmt.setInt(4, instock.getInNo());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }
  public int deleteInstock(int inNo){
    conn = db.connect();
    int cnt = 0;

    String sql = "delete from instock where inNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, inNo);

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  // 입고 시 입고 처리
  public int inInstock(Instock instock){
    conn = db.connect();
    int cnt = 0;

    String sql = "insert into instock(proNo, amount, inPrice) values(?, ?, ?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, instock.getProNo());
      pstmt.setInt(2, instock.getAmount());
      pstmt.setInt(3, instock.getInPrice());

      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }

  public Instock getProductInstock(int proNo){
    conn = db.connect();
    Instock instock = new Instock();

    String sql = "select * from instock where proNo=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        instock = new Instock(rs.getInt("inNo"), rs.getInt("proNo"), rs.getInt("amount"), rs.getInt("inPrice"), regdate);
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return instock;
  }
}
