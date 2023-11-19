package com.gnjBook.db;

import java.sql.*;

public class DBC {
  private String DRIVER;
  private String DNS = "localhost:";
  private String PORT;
  private String DB = "myroobook";
  private String USER = "root";
  private String PASS = "1234";
  private String URL;
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;


  public DBC() {
  }

  public void setDRIVER(String DRIVER) {
    this.DRIVER = DRIVER;
  }

  public void setDNS(String DNS) {
    this.DNS = DNS;
  }

  public void setPORT(String PORT) {
    this.PORT = PORT;
  }

  public void setTABLE(String DB) {
    this.DB = DB;
  }

  public void setUSER(String USER) {
    this.USER = USER;
  }

  public void setPASS(String PASS) {
    this.PASS = PASS;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public String getDRIVER() {
    return DRIVER;
  }

  public String getDNS() {
    return DNS;
  }

  public String getPORT() {
    return PORT;
  }

  public String getDB() {
    return DB;
  }

  public String getUSER() {
    return USER;
  }

  public String getPASS() {
    return PASS;
  }

  public String getURL() {
    return URL;
  }

  public Connection connect() {
    try {
      Class.forName(DRIVER);
      this.conn = DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (Exception e){
      e.printStackTrace();
    }
    return this.conn;
  }

  public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
    try{
      if(rs!=null){
        rs.close();
      }
      if(pstmt!=null){
        pstmt.close();
      }
      if(conn!=null){
        conn.close();
      }
    }catch(SQLException e){
      throw new RuntimeException(e);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
