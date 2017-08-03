package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;

public class AccountDaoImpl implements AccountDao{
	public List<Account>findUser(){
		List<Account> list = new ArrayList<Account>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs =null;
			Account ac = null;
			String sql = "select * from t_account";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
					ac = new Account();
				ac.setAccountId(rs.getLong("accountId"));
				ac.setTotalAssets(rs.getLong("TotalAssets"));
				ac.setAccumulatedIncome(rs.getInt("AccumulatedIncome"));
				ac.setFrozenCapital(rs.getLong("FrozenCapital"));
				ac.setFrostgold(rs.getLong("Frostgold"));
				ac.setAccountbalance(rs.getLong("Accountbalance"));
				ac.setGoldgrammage(rs.getInt("Goldgrammage"));
				ac.setGoldpresentvalue(rs.getInt("Goldpresentvalue"));
				ac.setAccountStatusl(rs.getInt("AccountStatus"));
				ac.setUserId(rs.getLong("UserId"));
				list.add(ac);
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Account findAccount(Long UserId) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql  = "select * from t_account where UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1,UserId);
			rs = ps.executeQuery();
			Account ac = new Account();
			while(rs.next()){
				ac.setUserId(rs.getLong("UserId"));
				ac.setTotalAssets(rs.getLong("TotalAssets"));
				ac.setAccumulatedIncome(rs.getInt("AccumulatedIncome"));
				ac.setFrozenCapital(rs.getLong("FrozenCapital"));
				ac.setFrostgold(rs.getLong("Frostgold"));
				ac.setAccountbalance(rs.getLong("Accountbalance"));
				ac.setGoldgrammage(rs.getInt("Goldgrammage"));
				ac.setGoldpresentvalue(rs.getInt("Goldpresentvalue"));
				ac.setAccountStatusl(rs.getInt("AccountStatus"));
			}
			ConnectionUtil.closeResource(con, ps,rs);
			return ac;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean JianKuan(Account account){
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE t_account SET Accountbalance =? where UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, account.getAccountbalance());
			ps.setLong(2, account.getUserId());
			
			int ab = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			if(ab>0){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		AccountDao accountDao = new AccountDaoImpl(); 
		List<Account> aa = accountDao.findUser();
		System.out.println(aa);
	}
}
