package com.gnjBook.model;

import com.gnjBook.db.DBC;
import com.gnjBook.db.MariaDBCon;
import com.gnjBook.dto.Delivery;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
  static DBC db = new MariaDBCon();
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  String key = "%02x";
  final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  public DeliveryDAO() {
  }

  public List<Delivery> getDeliveryList(){
    conn = db.connect();
    List<Delivery> deliveryList = new ArrayList<>();
    String sql = "select * from delivery order by dno desc";

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String etd = sdf.format(rs.getDate("etd"));
        String eta = "";
        if(rs.getDate("eta")!=null){
          eta = sdf.format(rs.getDate("eta"));
        }

        deliveryList.add(new Delivery(rs.getInt("dno"), rs.getInt("payNo"), rs.getString("memId"), rs.getString("name"), rs.getString("tel"), rs.getString("address"), rs.getString("dcom"), rs.getString("dtel"), rs.getInt("state"), etd, eta, rs.getString("dcode")));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return deliveryList;
  }

  public Delivery getDelivery(int dno){
    conn = db.connect();
    Delivery delivery = new Delivery();

    String sql = "select * from delivery where dno = ?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dno);

      rs = pstmt.executeQuery();

      if(rs.next()){
        String etd = sdf.format(rs.getDate("etd"));
        String eta = "";
        if(rs.getDate("eta")!=null){
          eta = sdf.format(rs.getDate("eta"));
        }

        delivery = new Delivery(rs.getInt("dno"), rs.getInt("payNo"), rs.getString("memId"), rs.getString("name"), rs.getString("tel"), rs.getString("address"), rs.getString("dcom"), rs.getString("dtel"), rs.getInt("state"), etd, eta, rs.getString("dcode"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return delivery;
  }

  public int addDelivery(Delivery delivery){
    int cnt = 0;

    conn = db.connect();

    String sql = "insert into delivery(pay_no, memId, name, tel, address, dcom, dtel, state, eta, dcode, dno) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, delivery.getPayNo());
      pstmt.setString(2, delivery.getMemId());
      pstmt.setString(3, delivery.getName());
      pstmt.setString(4, delivery.getTel());
      pstmt.setString(5, delivery.getAddress());
      pstmt.setString(6, delivery.getDcom());
      pstmt.setString(7, delivery.getDtel());
      pstmt.setInt(8, delivery.getState());
      if(delivery.getEta()==null){
        pstmt.setDate(9, null);
      } else {
        java.util.Date utilDate = sdf.parse(delivery.getEta());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pstmt.setDate(9, sqlDate);
      }
      pstmt.setString(10, delivery.getDcode());
      pstmt.setInt(11, delivery.getDno());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  public int updateDelivery(Delivery delivery){
    int cnt = 0;

    conn = db.connect();
    String sql = "update delivery set dcom=?, dtel=?, state=?, etd=?, eta=?, dcode=? where dno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, delivery.getDcom());
      pstmt.setString(2, delivery.getDtel());
      pstmt.setInt(3, delivery.getState());

      if(delivery.getEtd()==null){
        pstmt.setDate(4, null);
      } else {
        java.util.Date utilDate = sdf.parse(delivery.getEtd());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pstmt.setDate(4, sqlDate);
      }

      if(delivery.getEta()==null){
        pstmt.setDate(5, null);
      } else {
        java.util.Date utilDate = sdf.parse(delivery.getEta());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pstmt.setDate(5, sqlDate);
      }
      pstmt.setString(6, delivery.getDcode());
      pstmt.setInt(7, delivery.getDno());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  public int deleteDelivery(int dno){
    int cnt = 0;

    conn = db.connect();

    String sql = "delete from delivery where dno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dno);

      cnt = pstmt.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return cnt;
  }

  // 출고 후 배송 등록
  public int startDelivery(Delivery delivery){
    int cnt = 0;

    conn = db.connect();

    String sql = "update delivery set dcom=?, dtel=?, state=1, etd=current_timestamp, eta=?, dcode=? where dno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, delivery.getDcom());
      pstmt.setString(2, delivery.getDtel());
      if(delivery.getEta()==null){
        pstmt.setDate(3, null);
      } else {
        java.util.Date utilDate = sdf.parse(delivery.getEta());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pstmt.setDate(3, sqlDate);
      }
      pstmt.setString(4, delivery.getDcode());
      pstmt.setInt(5, delivery.getDno());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  // 배송 완료
  public int completeDelivery(Delivery delivery){
    int cnt = 0;

    conn = db.connect();

    String sql = "update delivery set state=2 where dno=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, delivery.getDno());

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  // 구매 확정
  public int payConfirm(int payNo){
    int cnt = 0;

    conn = db.connect();

    String sql = "update delivery set state=3 where payNo=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payNo);

      cnt = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    db.close(rs, pstmt, conn);

    return cnt;
  }

  // 특정 회원이 결제한 내역의 배송 리스트
  public Delivery getPayDeliveryList(int payNo){
    conn = db.connect();
    Delivery delivery = new Delivery();
    String sql = "select * from delivery where payNo=?";

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, payNo);
      rs = pstmt.executeQuery();

      while(rs.next()){
        String etd = sdf.format(rs.getDate("etd"));
        String eta = "";
        if(rs.getDate("eta")!=null){
          eta = sdf.format(rs.getDate("eta"));
        }


        delivery = new Delivery(rs.getInt("dno"), rs.getInt("payNo"), rs.getString("memId"), rs.getString("name"), rs.getString("tel"), rs.getString("address"), rs.getString("dcom"), rs.getString("dtel"), rs.getInt("state"), etd, eta, rs.getString("dcode"));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally{
      db.close(rs, pstmt, conn);
    }

    return delivery;
  }
}
