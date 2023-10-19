package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcExe {
	public static void main(String[] args) {
		//jdbc 오라클 데이터 CRUD작업.
		//1. ojdbc6.jar라이브러리 추가
		//2. connection 객체 : db연결 query실행 or 실행결과 통로.
		Connection conn;
		
		//쿼리문 해석 객체 생성
		Statement stmt = null;
		//결과값 받는 set 컬렉션 프레임워크
		ResultSet rs = null;
		
		String sql = "insert into employees(employee_id,JOB_ID, last_name, email, hire_date)"
				+"values(300,'IT_PROG','홍','HONG', sysdate)";
		
//		sql = "delete from employees where employee_id = 300";
		sql = "update employees set first_name = 'Gil-Dong' where employee_id = 300";
		
		//jdbc driver 정상.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 에러.");
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pass = "hr";
		try {                                  //URL, 유저명, PW
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공!!!!!!!!!!!!!!!!!!!");
			
			stmt = conn.createStatement();	//쿼리실행, 처리결과 객체.
			//insert,update,delete
			int r = stmt.executeUpdate(sql);
			//select
			rs = stmt.executeQuery("select * from employees order by employee_id");
			
			while(rs.next()) {
				System.out.println("사원번호 : "+ rs.getInt("employee_id") +
						" | 이름 : " + rs.getString("first_name")+
						" | 이메일 : " + rs.getString("email")+
						" | 급여 : " + rs.getInt("salary"));
			}
			System.out.println("end of records");
		} catch (SQLException e) {
			System.out.println("처리실패ㅠㅠ");
			e.printStackTrace();
		}
		
		
	}
}
