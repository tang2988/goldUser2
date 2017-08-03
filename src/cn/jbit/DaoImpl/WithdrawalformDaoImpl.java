package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.jbit.Dao.WithdrawalformDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Withdrawalform;

public class WithdrawalformDaoImpl implements WithdrawalformDao {
	
	public Withdrawalform insert(Withdrawalform withdrawalform){
		
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT into t_withdrawalform"
					+ "(rechargeStatus,withdrawdMoneny,applyfortime,succeedtime,errortime,UserId)VALUES"
					+ "(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, withdrawalform.getRechargeStatus());
			ps.setBigDecimal(2, withdrawalform.getWithdrawdMoneny());
			ps.setTimestamp(3, new Timestamp(withdrawalform.getApplyfortime().getTime()));
			ps.setTimestamp(4, new Timestamp(withdrawalform.getSucceedtime().getTime()));
			ps.setTimestamp(5, new Timestamp(withdrawalform.getErrortime().getTime()));
			ps.setLong(6, withdrawalform.getUserId());
			int count = ps.executeUpdate();
			
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select withdrawalId from t_withdrawalform   order by withdrawalId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while(rs.next()){
				withdrawalform.setWithdrawalId(rs.getLong("withdrawalId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return withdrawalform;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
		
	
}
