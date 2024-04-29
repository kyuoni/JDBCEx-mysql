package day0429.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionEx {
	  public static void main(String[] args) {
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      boolean commit = false;
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");

	         stmt = conn.createStatement();

	         conn.setAutoCommit(false);// 트랜잭션 시작
	         
	         stmt.addBatch("insert into test2 values ('abc1011','1111')");
	         stmt.addBatch("insert into test2 values ('abc2022','2222')");
	         stmt.addBatch("insert into test2 values ('abc3033','3333')");
	         stmt.addBatch("insert into test2 values ('abc4044','4444')");

	         int[] updateCounts = stmt.executeBatch();

	         commit = true;
	         conn.commit();
	         conn.setAutoCommit(commit);
	         
	         rs = stmt.executeQuery("select * from test2");
	         while (rs.next()) {
	            String id = rs.getString("id");
	            String pw = rs.getString("password");
	            System.out.println(id + " : " + pw);
	         }
	      } catch (SQLException e) {
	         //e.printStackTrace();
	      } finally {
	         try {
	            if(!commit) conn.rollback();
	            if (rs != null)   rs.close();
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      System.out.println("end");
	   

	}
}
