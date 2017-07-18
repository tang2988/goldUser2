package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jbit.Dao.UserDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.User;

public class UserDaoImpl implements UserDao {
	
	public User login(User user){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			User  us =null;
			String sql = "select * from t_user where mobilePhone = ? and Password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getMobilePhone());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while(rs.next()){
				us = new User();
				us.setUserId(rs.getLong("UserId"));
				us.setRealName(rs.getString("RealName"));
				us.setPassword(rs.getString("Password"));
				us.setTransactionPwd(rs.getString("transactionPwd"));
				us.setMobilePhone(rs.getString("mobilePhone"));
				us.setUserStatus(rs.getInt("UserStatus"));
				us.setIdcardNo(rs.getString("idcardNo"));
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Integer Zhuce(User user){
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			
			String sql = "INSERT INTO t_user "
					+ "(RealName,Password,transactionPwd,mobilePhone,UserStatus,idcardNo)values"
					+ "(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getRealName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getTransactionPwd());
			ps.setString(4, user.getMobilePhone());
			ps.setInt(5, user.getUserStatus());
			ps.setString(6, user.getIdcardNo());
			int zc = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return zc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer Update(User user){
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			
			String sql = "UPDATE t_user SET RealName = ?,idcardNo = ? WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getRealName());
			ps.setString(2, user.getIdcardNo());
			ps.setLong(3, user.getUserId());
			int up = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return up;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer UpdatePwd(User user){
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			
			String sql = " update t_user SET transactionPwd = ? WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getTransactionPwd());
			ps.setLong(2, user.getUserId());
			int upn = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return upn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findNameId(Long UserId){
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			User user = null;
			String sql = "select RealName,idcardNo from t_user where UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, UserId);
			rs = ps.executeQuery();
			while(rs.next()){
				 user = new User();
				 user.setRealName(rs.getString("RealName"));
				 user.setIdcardNo(rs.getString("idcardNo"));

			}
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public User getMobliePhone(String mobilePhone) {

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			User user = null;
			String sql = "SELECT mobilePhone from t_user where mobilePhone=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mobilePhone);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setMobilePhone(rs.getString("mobilePhone"));
			}
			
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	
	public User findPassword(String Password){
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT Password from t_user WHERE Password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Password);
			rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setPassword(rs.getString("Password"));
				
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Integer UpdatePassword(User user){
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
		
			String sql = "update t_user SET Password = ? where UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setLong(2, user.getUserId());
			int upn = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return upn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		User aa = ud.login(user);
		 
		 
		
//		boolean aa = ud.login("15012812811", "123123");
		System.out.println(aa);
	}


}
