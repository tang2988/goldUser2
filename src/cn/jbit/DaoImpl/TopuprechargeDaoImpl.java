package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jbit.Dao.TopuprechargeDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Topuprecharge;


public class TopuprechargeDaoImpl implements TopuprechargeDao {
	
	public Topuprecharge rechargeRecord(Topuprecharge topuprecharge){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_topuprecharge "
					+ "(recharmoney,UserId,rechargeTime,rechargeStatus,banklistId) "
					+ "VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setBigDecimal(1, topuprecharge.getRecharmoney());
			ps.setLong(2, topuprecharge.getUserId());
			ps.setTimestamp(3, new Timestamp(topuprecharge.getRechargeTime().getTime()));
			ps.setInt(4, topuprecharge.getRechargeStatus());
			ps.setLong(5, topuprecharge.getBanklistId());
			int cz = ps.executeUpdate();
			
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select banklistId from t_topuprecharge order by banklistId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while(rs.next()){
				topuprecharge.setBanklistId(rs.getLong("banklistId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return topuprecharge;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Topuprecharge> findAll(int pageNo, int pageSize) {
		List<Topuprecharge> list = new ArrayList<Topuprecharge>();
		try {
			Connection con = ConnectionUtil.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs  = null;
			int gongshi = pageSize*(pageNo-1);
			String sql = "select * from t_topuprecharge LIMIT "+gongshi+","+pageSize;
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				 Topuprecharge topuprecharge = new Topuprecharge();
				 topuprecharge.setBanklistId(rs.getLong("banklistId"));
				 topuprecharge.setRechargeId(rs.getLong("rechargeId"));
				 topuprecharge.setRecharmoney(rs.getBigDecimal("recharmoney"));
				 topuprecharge.setRechargeTime((rs.getTimestamp("rechargeTime")));
				 topuprecharge.setUserId(rs.getLong("UserId"));
				 topuprecharge.setSucceedTime(rs.getTimestamp("succeedTime"));
				 topuprecharge.setRechargeStatus(rs.getInt("rechargeStatus"));
				 topuprecharge.setErrorTime(rs.getTimestamp("errorTime"));
				 list.add(topuprecharge);
			}
			ConnectionUtil.closeResource(con, ps, rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Long findCount() {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select count(1) from t_topuprecharge";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			Long lg = 0L;
			while(rs.next()){
				lg = rs.getLong("count(1)");
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return lg;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Map<String, Object>> findAllaccountAndtopuprecharge(int pageno,int pageSize) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			int gongshi = pageSize * (pageno-1);
			String sql = "select t_account.Accountbalance,t_account.AccountStatus,t_account.accountId," +
					"t_topuprecharge.banklistId,t_topuprecharge.rechargeId,t_topuprecharge.recharmoney," +
					"t_topuprecharge.UserId,t_topuprecharge.rechargeTime,t_topuprecharge.succeedTime," +
					"t_topuprecharge.rechargeStatus,t_topuprecharge.errorTime from t_topuprecharge  " +
					"INNER JOIN t_account  ON t_topuprecharge.UserId = t_account.UserId LIMIT "+gongshi+","+pageSize;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("Accountbalance", rs.getBigDecimal("Accountbalance"));
				map.put("AccountStatus", rs.getInt("AccountStatus"));
				map.put("accountId", rs.getLong("accountId"));
				map.put("banklistId", rs.getLong("banklistId"));
				map.put("rechargeId", rs.getLong("rechargeId"));
				map.put("recharmoney", rs.getBigDecimal("recharmoney"));
				map.put("UserId", rs.getLong("UserId"));
				map.put("rechargeTime", rs.getTimestamp("rechargeTime"));
				map.put("succeedTime", rs.getTimestamp("succeedTime"));
				map.put("rechargeStatus", rs.getInt("rechargeStatus"));
				map.put("errorTime", rs.getTimestamp("errorTime"));
				list.add(map);
			}
			ConnectionUtil.closeResource(con, ps, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		
		TopuprechargeDao dao = new TopuprechargeDaoImpl();
		  List<Topuprecharge> aa = dao.findAll(1, 2);
		 System.out.println(aa);
	}

}
