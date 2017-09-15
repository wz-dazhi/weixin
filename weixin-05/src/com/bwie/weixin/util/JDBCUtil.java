package com.bwie.weixin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	// 1、加载驱动
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");// new Driver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2、创建连接
	private static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_yd1503c";
		String username = "wnw404nlll";
		String password = "3mm51kh105x43ymjm054kh3i13x0izmw4wlxl00w";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 修改 删除 增加
	public static void executeSQL(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
	}

	// 关闭连接
	private static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
