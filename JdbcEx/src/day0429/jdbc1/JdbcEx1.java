package day0429.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) {

		// 1.드라이버 로딩 - DBMS 종류 선택
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// SQL : 부서테이블에서 10번부서의 모든정보 -> select * from dept where detpno = 10
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 2. 접속(Connection 구현 객체 생성 - db URL, username, password
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");
			// 3. SQL문 전송(실행) - Statement
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept where deptno = 10");
			// 4. select문 실행시 가져온 결과물(레코드) -> java Object
			if (rs.next()) {
				int deptno = rs.getInt("deptno");// rs.get타입("컬럼명 or 컬럼인덱스");
				String dname = rs.getString("dname");
				String loc = rs.getString(3);
				System.out.printf("%d 번 부서명 : %s, 근무지 : %s\n", deptno, dname, loc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 접속 해제
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");

	}

}
