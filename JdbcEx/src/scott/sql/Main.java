package scott.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import scott.sql.service.EmpService;

public class Main {

	public static void main(String[] args) {
		EmpService service = new EmpService();
		
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madangdb", "madang", "madang");){
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				System.out.println("메뉴선택");
				System.out.println("=======================");
				System.out.println("1. 2. 3. 4. 7. 종료");
				System.out.println("=======================");
				
				int menu = scan.nextInt();
				
				if(menu == 1) {
					service.empAll(conn);
				}else if(menu ==7) {
					System.out.println("프로그램 종료");
					break;
				}//if
			}//while
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
