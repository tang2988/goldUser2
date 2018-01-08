package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Driver;

public class Test1 {
	
	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new Driver());
			 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/xxh", "root", "root");
			  PreparedStatement ps = con.prepareStatement("select * from t_user");
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				 
				   Map<String,Object> map = new HashMap<String, Object>();
				   map.put("realName", rs.getString(2));
				   System.out.println(map.get("realName"));
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
