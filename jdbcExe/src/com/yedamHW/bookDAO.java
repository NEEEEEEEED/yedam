package com.yedamHW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.EmpVO;

public class bookDAO {
		// 필드
		Connection conn;
		Statement stmt = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "book";
		String pass = "book";

		// 메소드

		// db연결
		public void connect() {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(url, user, pass);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("에러발생.");
				e.printStackTrace();
			}
		}

		// 관리자 메뉴 - 2.대여목록 조회
		public List<EmpVO> empVoList() {
			sql = "select * from emp_temp order by employee_id";
			connect();
			List<EmpVO> list = new ArrayList<EmpVO>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					EmpVO emp = new EmpVO();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setHireDate(rs.getString("hire_date"));
					emp.setSalary(rs.getInt("salary"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

		// 단건조회. (stmt)
		public EmpVO getEmp(int id) {
			sql = "select * from emp_temp where employee_id = " + id;
			connect();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					EmpVO emp = new EmpVO();
					emp.setEmployeeId(rs.getInt("employee_id"));
					emp.setFirstName(rs.getString("first_name"));
					emp.setLastName(rs.getString("last_name"));
					emp.setEmail(rs.getString("email"));
					emp.setHireDate(rs.getString("hire_date"));
					emp.setSalary(rs.getInt("salary"));
					return emp;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		// 입력. (psmt)
		public int addEmp(EmpVO emp) {
			connect();
			sql = "insert into emp_temp (employee_id,last_name,email,hire_date,job_id) " + " values (?,?,?,?,?)";
			int r = 0;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, emp.getEmployeeId());
				psmt.setString(2, emp.getLastName());
				psmt.setString(3, emp.getEmail());
				psmt.setString(4, emp.getHireDate());
				psmt.setString(5, emp.getJobId());

				r = psmt.executeUpdate(); // 처리된 건수

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return r;
		}

		// 봉급수정.
		public int updateEmp(int id, int sal) {
			sql = "update emp_temp set salary = ? where employee_id = ?";
			connect();
			int r = 0;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, sal);
				psmt.setInt(2, id);

				r = psmt.executeUpdate(); // 처리된 건수

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return r;
		}

		// 삭제.
		public int deleteEmp(int id) {
			sql = "delete from emp_temp where employee_id = ?";
			connect();
			int r = 0;
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, id);

				r = psmt.executeUpdate(); // 처리된 건수

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return r;
		}
}
