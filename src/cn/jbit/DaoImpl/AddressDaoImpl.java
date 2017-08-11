package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jbit.Dao.AddressDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Address;

public class AddressDaoImpl implements AddressDao{
	
	
	
	public Address add(Address address) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_address(userName,mobilePhone,userId,twelveProvincesAndcities,detailedAddressStreet)"
					+ "VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,address.getUserName());
			ps.setString(2,address.getMobilePhone());
			ps.setLong(3, address.getUserId());
			ps.setString(4,address.getTwelveProvincesAndcities());
			ps.setString(5,address.getDetailedAddressStreet());
			int count = ps.executeUpdate();
			
			
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select addressId from t_address order by addressId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			long aa = 0L;
			while(rs.next()){
				aa = rs.getLong("addressId");
			}
			address.setAddressId(aa);
			
			ConnectionUtil.closeResource(con, ps, null);
			return address;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer update(Address address) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE  t_address SET userName = ?,mobilePhone = ?,"
					+ "userId=?,twelveProvincesAndcities = ?,detailedAddressStreet=? "
					+ "WHERE addressId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,address.getUserName());
			ps.setString(2,address.getMobilePhone());
			ps.setLong(3, address.getUserId());
			ps.setString(4,address.getTwelveProvincesAndcities());
			ps.setString(5,address.getDetailedAddressStreet());
			ps.setLong(5, address.getAddressId());
			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Address findById(Long addressId){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_address where addressId = ?";
			Address address = null;
			ps = con.prepareStatement(sql);
			ps.setLong(1, addressId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				address = new Address();
				address.setAddressId(rs.getLong("addressId"));
				address.setUserName(rs.getString("userName"));
				address.setUserId(rs.getLong("userId"));
				address.setMobilePhone(rs.getString("mobilePhone"));
				address.setTwelveProvincesAndcities(rs.getString("twelveProvincesAndcities"));
				address.setDetailedAddressStreet(rs.getString("detailedAddressStreet"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return address;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	public Address findByuserId(Long userId,Long addressId){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_address where userId = ? and addressId = ?";
			Address address = null;
			ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, addressId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				address = new Address();
				address.setAddressId(rs.getLong("addressId"));
				address.setUserName(rs.getString("userName"));
				address.setUserId(rs.getLong("userId"));
				address.setMobilePhone(rs.getString("mobilePhone"));
				address.setTwelveProvincesAndcities(rs.getString("twelveProvincesAndcities"));
				address.setDetailedAddressStreet(rs.getString("detailedAddressStreet"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return address;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
public Address findByuserId(Long userid){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_address where userId = ?";
			Address address = null;
			ps = con.prepareStatement(sql);
			ps.setLong(1, userid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				address = new Address();
				address.setAddressId(rs.getLong("addressId"));
				address.setUserName(rs.getString("userName"));
				address.setUserId(rs.getLong("userId"));
				address.setMobilePhone(rs.getString("mobilePhone"));
				address.setTwelveProvincesAndcities(rs.getString("twelveProvincesAndcities"));
				address.setDetailedAddressStreet(rs.getString("detailedAddressStreet"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return address;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
