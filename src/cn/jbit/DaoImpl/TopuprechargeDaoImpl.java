package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.jbit.Dao.TopuprechargeDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Topuprecharge;


public class TopuprechargeDaoImpl implements TopuprechargeDao {
	
	public Integer rechargeRecord(Topuprecharge topuprecharge){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_topuprecharge "
					+ "(recharmoney,UserId,rechargeTime,succeedTime,rechargeStatus,banklistId) "
					+ "VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, topuprecharge.getRecharmoney());
			ps.setLong(2, topuprecharge.getUserId());
			ps.setTimestamp(3, new Timestamp(topuprecharge.getRechargeTime().getTime()));
			ps.setTimestamp(4, new Timestamp(topuprecharge.getSucceedTime().getTime()));
			ps.setInt(5, topuprecharge.getRechargeStatus());
			ps.setLong(6, topuprecharge.getBanklistId());
			int cz = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return cz;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
