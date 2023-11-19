package com.gnjBook.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MariaDBCon extends DBC {
  final String DRIVER = "org.mariadb.jdbc.Driver";
  final String PORT = "3306/";
  final String URL = "jdbc:mariadb://"+super.getDNS()+PORT+super.getDB();

  public MariaDBCon() {
    super();
    super.setDRIVER(this.DRIVER);
    super.setPORT(this.PORT);
    super.setURL(this.URL);
  }

  @Override
  public Connection connect() {
    return super.connect();
  }

  @Override
  public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
    super.close(rs, pstmt, conn);
  }
}
