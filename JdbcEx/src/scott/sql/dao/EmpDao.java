package scott.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import scott.sql.dto.Emp;

public class EmpDao {
	// 1. 모든 사원의 사원번호, 이름, 직급, 입사일출력
	// select empno, ename, job, hiredate from emp;
	public List<Emp> empAll(Connection conn) {
		String sql = "select empno, ename, job, hiredate from emp";
		List<Emp> elist = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setHiredate(rs.getDate("hiredate"));

				elist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return elist;
	}// empAll
}// class
