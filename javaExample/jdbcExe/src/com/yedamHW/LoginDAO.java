package com.yedamHW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
	Connection conn;
	Statement stmt = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	String sql;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "book";
	String pass = "book";
	
	
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


		public List<LoginVO> LoginCheck() {
			sql = "select * from manager";
			connect();
			List<LoginVO> list = new ArrayList<LoginVO>();
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					LoginVO login = new LoginVO();
					login.setManagerId(rs.getString("manager_id"));
					login.setManagerPw(rs.getString("manager_pw"));
	
					list.add(login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
		
		
}
