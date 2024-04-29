package scott.sql.service;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import scott.sql.dao.EmpDao;
import scott.sql.dto.Emp;

public class EmpService {

	EmpDao dao = new EmpDao();

	public void empAll(Connection conn) {
		System.out.println("모든 사원의 정보를 확인합니다.");
		List<Emp> elist = dao.empAll(conn);
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		for (Emp e : elist) {
			System.out.printf("%d %s %s %s\n", e.getEmpno(), e.getEname(), e.getJob(), sdf.format(e.getHiredate()));
		}
		System.out.println();
	}
}
