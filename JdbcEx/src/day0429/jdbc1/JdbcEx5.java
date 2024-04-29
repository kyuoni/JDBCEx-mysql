package day0429.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcEx5 {

	public static void main(String[] args) {
		String sql = "delete from dept where deptno=?";
		//스캐너로 부서 번호 입력 받아서 해당 부서 삭제
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호를 입력하시면 해당 부서가 삭제됩니다. ");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println("부서번호 > ");
			pstmt.setInt(1, sc.nextInt());
			
			System.out.println("정말 삭제하시겠습니까?(yes/no)");
			if(sc.next().equals("yes")) {
				
			
			int i = pstmt.executeUpdate();
			
			if(i == 0) {
				System.out.println("입력하신 부서는 존재하지 않습니다.");
			}else {
				System.out.println("부서 삭제 성공");
			}
			}else {
				System.out.println("삭제를 취소합니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

}
