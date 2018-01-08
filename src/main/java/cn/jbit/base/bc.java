package cn.jbit.base;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.entity.Account;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class bc {

	public static void main(String[] args) {

		/*
		 * //注册驱动，反射方式加载 Class.forName("com.mysql.jdbc.Driver"); //设置url String
		 * url = "jdbc:mysql://127.0.0.1:3306/day08";//person是数据库名，连接是数据库须要开启
		 * //设置用户名 String username = "root"; //设置密码 String password = "root";
		 * //获得连接对象 Connection con = DriverManager.getConnection(url, username,
		 * password);
		 */
		// System.out.println(con);
		bc.find();

	}

	public static List<Account> find() {
		
		try {
			List<Account> list = new ArrayList<>();
			DriverManager.registerDriver(new Driver());
			// 获取
			String url = "jdbc:mysql://localhost:3306/golddb?useUnicode=true&characterEncoding=utf8";
			java.sql.Connection conn = DriverManager.getConnection(url, "root",
					"root");
			// 获得执行者对象
			/* String sql = "select Accountbalance from t_account "; */
			PreparedStatement ps = conn
					.prepareStatement("select * from t_account");
			// 获得结果集
			ResultSet rs = ps.executeQuery();

			// 结果集处理，
			while (rs.next()) {

				Account ac = new Account();
				ac.setUserId(rs.getLong("UserId"));
				ac.setTotalAssets(rs.getBigDecimal("TotalAssets"));
				ac.setAccumulatedIncome(rs.getBigDecimal("AccumulatedIncome"));

				ac.setFrozenCapital(rs.getBigDecimal("FrozenCapital"));
				ac.setFrostgold(rs.getBigDecimal("Frostgold"));
				ac.setAccountbalance(rs.getBigDecimal("Accountbalance"));
				ac.setGoldgrammage(rs.getBigDecimal("Goldgrammage"));
				ac.setGoldpresentvalue(rs.getBigDecimal("Goldpresentvalue"));
				ac.setAccountStatus(rs.getInt("AccountStatus"));
				

				/*
				 * BigDecimal baa = rs.getBigDecimal("Accountbalance");
				 * System.out.println(baa);
				 */
				list.add(ac);
				System.out.println(ac);
		
				
				
			}

			// 释放资源
			rs.close();
			ps.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
