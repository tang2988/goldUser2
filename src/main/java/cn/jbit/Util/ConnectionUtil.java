package cn.jbit.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionUtil {
	public static java.sql.Connection getConnection() {
		try {
			// 先注册驱动com.mysql.jdbc.Driver
			DriverManager.registerDriver(new Driver());
			// 获取
			String url = "jdbc:mysql://localhost:3306/golddb?useUnicode=true&characterEncoding=utf8";
			java.sql.Connection conn = DriverManager.getConnection(url, "root", "root");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void closeResource(Connection con, PreparedStatement ps, ResultSet rs)
			throws SQLException {
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
	}
	
	
	
}
