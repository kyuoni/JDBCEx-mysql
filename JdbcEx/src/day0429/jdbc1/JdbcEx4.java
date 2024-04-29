package day0429.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx4 {

	public static void main(String[] args) {
		String sql = "update dept set deptno=?,dname=?,loc=? where deptno = 80";
		// 80, HR, JEJU 
		//update dept set loc = ? where deptno =?
		//pstmt.setString(1, "SEOUL");
		//pstmt.setInt(2,60);
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, 80);
			pstmt.setString(2, "HR");
			pstmt.setString(3, "SEOUL");
			
			int i = pstmt.executeUpdate();
			if(i == 0) {
				System.out.println("부서 정보가 변경되지 않았습니다.");
			}else {
				System.out.println("80번 부서가 변경되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
