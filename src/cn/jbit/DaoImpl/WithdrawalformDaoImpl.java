package cn.jbit.DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jbit.Dao.WithdrawalformDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Withdrawalform;

public class WithdrawalformDaoImpl implements WithdrawalformDao {

	public Withdrawalform insert(Withdrawalform withdrawalform) {

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT into t_withdrawalform"
					+ "(rechargeStatus,withdrawdMoneny,applyfortime,UserId)VALUES"
					+ "(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, withdrawalform.getRechargeStatus());
			ps.setBigDecimal(2, withdrawalform.getWithdrawdMoneny());
			ps.setTimestamp(3, new Timestamp(withdrawalform.getApplyfortime().getTime()));
			ps.setLong(4, withdrawalform.getUserId());
			int count = ps.executeUpdate();

			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select withdrawalId from t_withdrawalform   order by withdrawalId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while (rs.next()) {
				withdrawalform.setWithdrawalId(rs.getLong("withdrawalId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return withdrawalform;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Map<String, Object>> findAll(int pageNo, int pageSize) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			int gongshi = pageSize * (pageNo-1);
			String sql = "select t_account.Accountbalance,t_account.FrozenCapital,t_account.AccountStatus,t_account.accountId,t_withdrawalform.withdrawalId,t_withdrawalform.rechargeStatus,t_withdrawalform.withdrawdMoneny,t_withdrawalform.applyfortime,t_withdrawalform.succeedtime,t_withdrawalform.errortime,t_withdrawalform.UserId from t_withdrawalform INNER JOIN t_account ON t_withdrawalform.UserId = t_account.UserId LIMIT "+gongshi+","+pageSize;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("Accountbalance", rs.getBigDecimal("Accountbalance"));
				map.put("accountId", rs.getLong("accountId"));
				map.put("AccountStatus", rs.getInt("AccountStatus"));
				map.put("withdrawalId", rs.getLong("withdrawalId"));
				map.put("rechargeStatus", rs.getInt("rechargeStatus"));
				map.put("withdrawdMoneny", rs.getBigDecimal("withdrawdMoneny"));
				map.put("applyfortime", rs.getTimestamp("applyfortime"));
				map.put("succeedtime", rs.getTimestamp("succeedtime"));
				map.put("errortime", rs.getTimestamp("errortime"));
				map.put("UserId", rs.getLong("UserId"));
				map.put("FrozenCapital", rs.getLong("FrozenCapital"));
				list.add(map);
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
			String sql = "select count(1) from t_withdrawalform";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			Long lg = 0L;
			while (rs.next()) {
				lg = rs.getLong("count(1)");
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return lg;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Integer updatestatusbysuccesstime(Withdrawalform withdrawalform) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "update t_withdrawalform SET rechargeStatus=?,succeedtime=? where withdrawalId = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, withdrawalform.getRechargeStatus());
			ps.setTimestamp(2, new Timestamp(withdrawalform.getSucceedtime().getTime()));
			ps.setLong(3, withdrawalform.getWithdrawalId());
			int ts = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return ts;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	public Withdrawalform findById(Long withdrawalId) {
		List<Withdrawalform> list = new ArrayList<Withdrawalform>();
		try {
			Connection con = ConnectionUtil.getConnection();

			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_withdrawalform  where withdrawalId =?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, withdrawalId);
			rs = ps.executeQuery();
			Withdrawalform withdrawalform = new Withdrawalform();
			while (rs.next()) {
				
				withdrawalform.setWithdrawalId(rs.getLong("withdrawalId"));
				withdrawalform.setWithdrawdMoneny(rs
						.getBigDecimal("withdrawdMoneny"));
				withdrawalform.setSucceedtime((rs.getTimestamp("succeedtime")));
				withdrawalform.setUserId(rs.getLong("UserId"));
				withdrawalform.setErrortime(rs.getTimestamp("errortime"));
				withdrawalform.setRechargeStatus(rs.getInt("rechargeStatus"));
				withdrawalform.setApplyfortime(rs.getTimestamp("applyfortime"));
				list.add(withdrawalform);
				
			}
			ConnectionUtil.closeResource(con, ps, rs);
			
			return withdrawalform;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	

	
	public static void main(String[] args) {
		WithdrawalformDao wd = new WithdrawalformDaoImpl();
		 List<Map<String, Object>> aa = wd.findAll(2, 3);
		 System.out.println(aa);
	}
}
