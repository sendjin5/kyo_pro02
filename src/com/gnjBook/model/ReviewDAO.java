package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Review;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public ReviewDAO() {
  }

  public boolean checkReview(String id, int proNo) {
    boolean pass =false;

    conn = db.connect();
    String sql = "SELECT * FROM delivery d, payment p WHERE d.payNo = p.payNo AND d.memId = ? AND p.proNo = ? AND d.state = 3";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setInt(2, proNo);
      rs = pstmt.executeQuery();
      if(rs.next()) {
        pass = true;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      db.close(rs, pstmt, conn);
    }

    return pass;
  }

  public int getReviewPayInfo(String id, int proNo) {
    int payNo = 0;

    conn = db.connect();
    String sql = "SELECT d.payNo AS payNo FROM delivery d, payment p WHERE d.payNo = p.payNo AND d.memId = ? AND p.proNo = ?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setInt(2, proNo);
      rs = pstmt.executeQuery();
      if(rs.next()) {
        payNo = rs.getInt("payNo");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return payNo;
  }

  public List<Review> getReviewList(int proNo){
    conn = db.connect();
    List<Review> reviewList = new ArrayList<>();
    String sql = "select * from review WHERE proNo = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, proNo);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));

        reviewList.add(new Review(rs.getInt("rno"), rs.getString("memId"), rs.getInt("payNo"), rs.getInt("star"), rs.getString("content"), regdate, rs.getInt("proNo")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return reviewList;
  }

  public Review getReview(int rno){
    conn = db.connect();
    Review review = new Review();

    String sql = "select * from review where rno = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, rno);

      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));

        review = new Review(rs.getInt("rno"), rs.getString("memId"), rs.getInt("payNo"), rs.getInt("star"), rs.getString("content"), regdate, rs.getInt("proNo"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return review;
  }

  public int addReview(Review review){
    int cnt = 0;

    conn = db.connect();

    String sql = "insert into review(memId, payNo, star, content, proNo) values (?, ?, ?, ?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, review.getMemId());
      pstmt.setInt(2, review.getPayNo());
      pstmt.setInt(3, review.getStar());
      pstmt.setString(4, review.getContent());
      pstmt.setInt(5, review.getProNo());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int updateReview(Review review){
    int cnt = 0;

    conn = db.connect();
    String sql = "update review set memId=?, payNo=?, star=?, content=?, proNo=? where rno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, review.getMemId());
      pstmt.setInt(2, review.getPayNo());
      pstmt.setInt(3, review.getStar());
      pstmt.setString(4, review.getContent());
      pstmt.setInt(5, review.getProNo());
      pstmt.setInt(6, review.getRno());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  public int deleteReview(int rno){
    int cnt = 0;

    conn = db.connect();

    String sql = "delete from review where rno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, rno);

      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }
}
