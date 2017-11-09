package cn.jbit.DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.Date;

import cn.jbit.Dao.TradeflowtableDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Tradeflowtable;

public class TradeflowtableDaoImpl implements TradeflowtableDao {

	public Tradeflowtable addTrade(Tradeflowtable tradeflowtable) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_tradeflowtable (businessId,businessdescription,money,type,businesstype,createTime)VALUES(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, tradeflowtable.getBusinessId());
			ps.setString(2, tradeflowtable.getBusinessdescription());
			ps.setBigDecimal(3, tradeflowtable.getMoney());
			ps.setInt(4, tradeflowtable.getType());
			ps.setInt(5,tradeflowtable.getBusinesstype());
			ps.setTimestamp(6, new Timestamp(tradeflowtable.getCreateTime().getTime()));

			int aa = ps.executeUpdate();
			
			
			ResultSet rs = null;
			PreparedStatement psm =null;
			String SQL = "select transactionId from t_tradeflowtable order by transactionId desc limit 1";
			psm = con.prepareStatement(SQL);
			rs = psm.executeQuery();
			while(rs.next()){
				tradeflowtable.setTransactionId(rs.getLong("transactionId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return tradeflowtable;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	public static void main(String[] args) {
		TradeflowtableDao dao = new TradeflowtableDaoImpl();
		Tradeflowtable tradeflowtable = new Tradeflowtable();
		tradeflowtable.setBusinessdescription("xx");
		tradeflowtable.setBusinessId(1L);
		tradeflowtable.setBusinesstype(10);
		tradeflowtable.setMoney(new BigDecimal(100));
		tradeflowtable.setType(10);
		tradeflowtable.setCreateTime(new Date());
		Tradeflowtable aa = dao.addTrade(tradeflowtable);
		System.out.println(aa);
	}

}
