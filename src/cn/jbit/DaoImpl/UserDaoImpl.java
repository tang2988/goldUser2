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
			return us;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
public User findUserById(Long userId){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			User  us =null;
			String sql = "select * from t_user WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
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
			return us;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User Zhuce(User user){
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			
			String sql = "INSERT INTO t_user (password,mobilePhone,userStatus)VALUES(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getMobilePhone());
			ps.setInt(3, user.getUserStatus());
			
			int zc = ps.executeUpdate();
			
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select UserId from t_user order by UserId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getLong("UserId"));
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
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
	
	
	public User findPassword(Long id){
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT Password from t_user WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			User us = null;
			while(rs.next()){
				us = new User();
				us.setPassword(rs.getString("Password"));

				
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return us;
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
	
	public User transactionPwd(Long uid){
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT transactionPwd from t_user WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, uid);
			rs = ps.executeQuery();
			User us = null;
			while(rs.next()){
				us = new User();
				us.setPassword(rs.getString("transactionPwd"));
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return us;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public User getpassword(String password) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			User user = null;
			String sql = "SELECT Password from t_user where Password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setMobilePhone(rs.getString("Password"));
			}
			
			ConnectionUtil.closeResource(con, ps, rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		User user = new User();
		user.setPassword("123123123");
		user.setMobilePhone("123123123123");
		user.setUserStatus(10);
		 User aa = ud.Zhuce(user);
		 
System.out.println(aa);
	}


}
