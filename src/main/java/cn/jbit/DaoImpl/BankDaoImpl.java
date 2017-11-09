package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.jbit.Dao.BankDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Bankcard;

public class BankDaoImpl implements BankDao {

	public Bankcard ins(Bankcard bankcard) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT into t_bankcard "
					+ "(card,BanknameId,bankcardStatus,UserId) "
					+ "VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, bankcard.getCard());
			ps.setString(2, bankcard.getBanknameId());
			ps.setInt(3, bankcard.getBankcardStatus());
			ps.setLong(4, bankcard.getUserId());
			int up = ps.executeUpdate();
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select bankcardId from t_bankcard order by bankcardId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while(rs.next()){
				bankcard.setBankcardId(rs.getLong("bankcardId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return bankcard;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Bankcard findBankcard(Bankcard bankcard) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Bankcard bk = null;
			String sql = "select card,BanknameId from t_bankcard WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, bankcard.getUserId());
			rs = ps.executeQuery();
			while(rs.next()){
				bk = new Bankcard();
				bk.setCard(rs.getLong("card"));
				bk.setBanknameId(rs.getString("BanknameId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return bk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Bankcard getCard(Long card) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Bankcard bk = null;
			String sql = "select card from t_bankcard WHERE card = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, card);
			rs = ps.executeQuery();
			while(rs.next()){
				bk = new Bankcard();
				bk.setCard(rs.getLong("card"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return bk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		BankDao bk = new BankDaoImpl();
		Bankcard bkk = new Bankcard();
//		bkk.setBankcardStatus(10);
//		bkk.setBanknameId("建设");
//		bkk.setCard(456465465465L);
		
		Bankcard aa = bk.getCard(441161654654656L);
		System.out.println(aa);
	}
}
