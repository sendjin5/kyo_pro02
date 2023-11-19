package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaqDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public FaqDAO() {
  }

  public List<Faq> getFaqList(){
    conn = db.connect();
    List<Faq> noticeList = new ArrayList<>();
    String sql = "select * from faq order by regdate desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      String regdate = sdf.format(rs.getDate("regdate"));

      while(rs.next()){
        noticeList.add(new Faq(rs.getInt("fno"), rs.getString("title"), rs.getString("content"),regdate));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return noticeList;
  }

  public Faq getFaq(int no){
    conn = db.connect();
    Faq faq = new Faq();

    String sql = "select * from faq where fno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        faq = new Faq(rs.getInt("fno"), rs.getString("title"), rs.getString("content"),regdate);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return faq;
  }

  public int addFaq(Faq faq){
    int cnt = 0;

    conn = db.connect();
    String sql = "insert into faq(title, content) values(?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, faq.getTitle());
      pstmt.setString(2, faq.getContent());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int updateFaq(Faq faq){
    int cnt = 0;

    conn = db.connect();
    String sql = "update faq set title=?, content=? where fno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, faq.getTitle());
      pstmt.setString(2, faq.getContent());
      pstmt.setInt(3, faq.getFno());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int deleteFaq(int no){
    int cnt = 0;

    conn = db.connect();
    String sql = "delete from faq where fno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }
}
