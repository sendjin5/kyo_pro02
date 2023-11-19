package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Fileboard;
import com.gnjBook.dto.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileboardDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public FileboardDAO() {
  }



  public List<Fileboard> getFileboardList(){
    List<Fileboard> fileboardList = new ArrayList<>();
    conn = db.connect();
    String sql = "select * from fileboard order by regdate desc";
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()){
        Fileboard fileboard = new Fileboard();
        String regdate = sdf.format(rs.getDate("regdate"));
        fileboard.setNo(rs.getInt("no"));
        fileboard.setTitle(rs.getString("title"));
        fileboard.setContent(rs.getString("content"));
        fileboard.setFilename1(rs.getString("filename1"));
        fileboard.setFilename2(rs.getString("filename2"));
        fileboard.setFilename3(rs.getString("filename3"));
        fileboard.setRegdate(regdate);
        fileboard.setVisited(rs.getInt("visited"));
        fileboardList.add(fileboard);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      db.close(rs, pstmt, conn);
    }
    return fileboardList;
  }


  public Fileboard getFileboard(int no){
    conn = db.connect();
    Fileboard fileboard = new Fileboard();

    String sql = "select * from fileboard where no=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, no);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String regdate = sdf.format(rs.getDate("regdate"));
        fileboard.setNo(rs.getInt("no"));
        fileboard.setTitle(rs.getString("title"));
        fileboard.setContent(rs.getString("content"));
        fileboard.setFilename1(rs.getString("filename1"));
        fileboard.setFilename2(rs.getString("filename2"));
        fileboard.setFilename3(rs.getString("filename3"));
        fileboard.setRegdate(regdate);
        fileboard.setVisited(rs.getInt("visited"));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return fileboard;
  }



  public int fileboardUpload(Fileboard fileboard){
    int cnt = 0;
    conn = db.connect();
    String sql = "insert into fileboard(title, content, filename1, filename2, filename3) values (?,?,?,?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, fileboard.getTitle());
      pstmt.setString(2, fileboard.getContent());
      pstmt.setString(3, fileboard.getFilename1());
      pstmt.setString(4, fileboard.getFilename2());
      pstmt.setString(5, fileboard.getFilename3());
      cnt = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      db.close(rs, pstmt, conn);
    }
    return cnt;
  }



  public int addFileboard(Fileboard fileboard){
    int cnt = 0;

    conn = db.connect();
    String sql = "insert into fileboard(title, content) values(?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, fileboard.getTitle());
      pstmt.setString(2, fileboard.getContent());
      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }


  public int deleteFileboard(int no){
    int cnt = 0;

    conn = db.connect();
    String sql = "delete from fileboard where no=?";

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
    Fileboard fileboard = new Fileboard();

    String sql = "update fileboard set visited = visited+1 where no=?";

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
