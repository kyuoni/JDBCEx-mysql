package day0429.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx3 {

	public static void main(String[] args) {
		String sql = "insert into dept values (?,?,?)";
		// 80, HR, JEJU
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, 80);
			pstmt.setString(2, "HR");
			pstmt.setString(3, "JEJU");
			
			int i = pstmt.executeUpdate();
			if(i == 0) {
				System.out.println("부서 정보가 추가되지 않았습니다.");
			}else {
				System.out.println("80번 부서가 추가되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
