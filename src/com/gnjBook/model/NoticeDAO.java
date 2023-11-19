package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public NoticeDAO() {
  }

  public List<Notice> getNoticeList(){
    conn = db.connect();
    List<Notice> noticeList = new ArrayList<>();
    String sql = "select * from notice order by regdate desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        noticeList.add(new Notice(rs.getInt("no"), rs.getString("title"), rs.getString("content"), sdf.format(rs.getDate(("regdate"))), rs.getInt("visited")));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return noticeList;
  }

  public Notice getNotice(int no){
    conn = db.connect();
    Notice notice = new Notice();

    String sql = "select * from notice where no=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);
      rs = pstmt.executeQuery();

      if(rs.next()){
        notice = new Notice(rs.getInt("no"), rs.getString("title"), rs.getString("content"), sdf.format(rs.getDate(("regdate"))), rs.getInt("visited"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return notice;
  }

  public int addNotice(Notice notice){
    int cnt = 0;

    conn = db.connect();
    String sql = "insert into notice(title, content) values(?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, notice.getTitle());
      pstmt.setString(2, notice.getContent());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int updateNotice(Notice notice){
    int cnt = 0;

    conn = db.connect();
    String sql = "update notice set title=?, content=? where no=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, notice.getTitle());
      pstmt.setString(2, notice.getContent());
      pstmt.setInt(3, notice.getNo());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int deleteNotice(int no){
    int cnt = 0;

    conn = db.connect();
    String sql = "delete from notice where no=?";

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

  public int countUp(int no){
    int cnt = 0;
    conn = db.connect();
    Notice notice = new Notice();

    String sql = "update notice set visited = visited+1 where no=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);
      cnt = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }
}
