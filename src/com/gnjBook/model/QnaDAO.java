package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class QnaDAO extends NoticeDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public QnaDAO() {
  }

  public List<Qna> getQnaList(){
    conn = db.connect();
    List<Qna> qnaList = new ArrayList<>();
    String sql = "select * from qna order by par asc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();


      while(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        qnaList.add(new Qna(rs.getInt("qno"), rs.getString("title"), rs.getString("content"), rs.getString("author"), regdate, rs.getInt("visited"), rs.getInt("lev"), rs.getInt("par"), rs.getBoolean("secret")));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return qnaList;
  }

  public Qna getQna(int qno){
    conn = db.connect();
    Qna qna = new Qna();

    String sql = "select * from qna where qno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, qno);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        qna = new Qna(rs.getInt("qno"), rs.getString("title"), rs.getString("content"), rs.getString("author"), regdate, rs.getInt("visited"), rs.getInt("lev"), rs.getInt("par"), rs.getBoolean("secret"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return qna;
  }

  public int addQna(Qna qna){
    int cnt = 0;

    conn = db.connect();
    String sql = "insert into qna(title, content, author, lev, par, secret) values(?, ?, ?, ?, ?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, qna.getTitle());
      pstmt.setString(2, qna.getContent());
      pstmt.setString(3, qna.getAuthor());
      pstmt.setInt(4, qna.getLev());
      pstmt.setInt(5, qna.getPar());
      pstmt.setBoolean(6, qna.isSecret());
      cnt = pstmt.executeUpdate();

      if(qna.getLev()==0){
        pstmt.close();
        sql = "update qna set par=qno where par=0 and lev=0";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        cnt++;
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int updateQna(Qna qna){
    int cnt = 0;

    conn = db.connect();
    String sql = "update qna set title=?, content=?, author=? where qno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, qna.getTitle());
      pstmt.setString(2, qna.getContent());
      pstmt.setString(3, qna.getAuthor());
      pstmt.setInt(4, qna.getQno());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int deleteQna(int qno){
    int cnt = 0;

    conn = db.connect();
    String sql = "delete from qna where qno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, qno);
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }


  public int countUp(int qno){
    int cnt = 0;
    conn = db.connect();
    Qna qna = new Qna();

    String sql = "update qna set visited = visited+1 where qno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, qno);
      cnt = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }
}
