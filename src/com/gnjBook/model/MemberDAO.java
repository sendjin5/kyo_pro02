package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Member;
import com.gnjBook.util.AES256;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  String key = "%02x";
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public MemberDAO() {
  }



  public boolean loginMember(String id, String pw){
    conn = db.connect();

    String sql = "select * from member where id = ? and state=1";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String decrypt = AES256.decryptAES256(rs.getString("pw"), key);
        if(decrypt.equals(pw)){
          return true;
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
    return false;
  }

  public boolean checkId(String id){
    conn = db.connect();

    String sql = "select * from member where id = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }
  }

  public List<Member> getMemberList(){
    conn = db.connect();
    List<Member> memberList = new ArrayList<>();
    String sql = "select * from member";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String decrypt = AES256.decryptAES256(rs.getString("pw"), key);
        String birth = sdf.format(rs.getDate("birth"));
        String regdate = sdf.format(rs.getDate("regdate"));
        memberList.add(new Member(rs.getString("id"), decrypt, rs.getString("name"), rs.getString("email"), rs.getString("tel"), birth, rs.getString("address"), rs.getString("postcode"), regdate, rs.getInt("point"), rs.getString("grade")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return memberList;
  }

  public Member getMember(String id){
    conn = db.connect();
    Member member = new Member();

    String sql = "select * from member where id = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if(rs.next()){
        String decrypt = AES256.decryptAES256(rs.getString("pw"), key);
        String birth = sdf.format(rs.getDate("birth"));
        member = new Member(rs.getString("id"), decrypt, rs.getString("name"), rs.getString("email"), rs.getString("tel"), birth, rs.getString("address"), rs.getString("postcode"), rs.getString("regdate"), rs.getInt("point"), rs.getString("grade"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return member;
  }

  public int addMember(Member member){
    int cnt = 0;

    conn = db.connect();

    String sql = "insert into member(id, pw, name, email, tel, birth, address, postcode, point, grade) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, member.getId());
      String encrypt = AES256.encryptAES256(member.getPw(), key);
      pstmt.setString(2, encrypt);

      pstmt.setString(3, member.getName());
      pstmt.setString(4, member.getEmail());
      pstmt.setString(5, member.getTel());
      Date birth = sdf.parse(member.getBirth());
      java.util.Date utilDate = sdf.parse(member.getBirth());
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      pstmt.setDate(6, sqlDate);
      pstmt.setString(7, member.getAddress());
      pstmt.setString(8, member.getPostcode());
      pstmt.setInt(9, member.getPoint());
      pstmt.setString(10, member.getGrade());


      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int memberUpdate(Member member){
    int cnt = 0;

    conn = db.connect();
    String sql = "update member set pw=?, name=?, email=?, tel=?, birth=?, address=?, postcode=?, point=?, grade=? where id=?";

    try {
      pstmt = conn.prepareStatement(sql);
      String encrypt = AES256.encryptAES256(member.getPw(), key);
      pstmt.setString(1, encrypt);
      pstmt.setString(2, member.getName());
      pstmt.setString(3, member.getEmail());
      pstmt.setString(4, member.getTel());
      java.util.Date utilDate = sdf.parse(member.getBirth());
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      pstmt.setDate(5, sqlDate);
      pstmt.setString(6, member.getAddress());
      pstmt.setString(7, member.getPostcode());
      pstmt.setInt(8, member.getPoint());
      pstmt.setString(9, member.getGrade());
      pstmt.setString(10, member.getId());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  public int deleteMember(String id){
    int cnt = 0;

    conn = db.connect();

    String sql = "delete from member where id=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);

      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  public int resignMember(String id){
    int cnt = 0;

    conn = db.connect();

    String sql = "update member set state=0 where id=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);

      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

}
