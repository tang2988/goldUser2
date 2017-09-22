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
import cn.jbit.entity.Address;
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
				ac.setTotalAssets(rs.getBigDecimal("TotalAssets"));
				ac.setAccumulatedIncome(rs.getBigDecimal("AccumulatedIncome"));
				ac.setFrozenCapital(rs.getBigDecimal("FrozenCapital"));
				ac.setFrostgold(rs.getBigDecimal("Frostgold"));
				ac.setAccountbalance(rs.getBigDecimal("Accountbalance"));
				ac.setGoldgrammage(rs.getBigDecimal("Goldgrammage"));
				ac.setGoldpresentvalue(rs.getBigDecimal("Goldpresentvalue"));
				ac.setAccountStatus(rs.getInt("AccountStatus"));
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
				ac.setTotalAssets(rs.getBigDecimal("TotalAssets"));
				ac.setAccumulatedIncome(rs.getBigDecimal("AccumulatedIncome"));
				ac.setFrozenCapital(rs.getBigDecimal("FrozenCapital"));
				ac.setFrostgold(rs.getBigDecimal("Frostgold"));
				ac.setAccountbalance(rs.getBigDecimal("Accountbalance"));
				ac.setGoldgrammage(rs.getBigDecimal("Goldgrammage"));
				ac.setGoldpresentvalue(rs.getBigDecimal("Goldpresentvalue"));
				ac.setAccountStatus(rs.getInt("AccountStatus"));
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
			String sql = "UPDATE t_account SET Accountbalance =?,FrozenCapital=? where UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setBigDecimal(1, account.getAccountbalance());
			ps.setBigDecimal(2, account.getFrozenCapital());
			ps.setLong(3, account.getUserId());
			
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
public Account addAccount(Account account) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_account"
					+ "(TotalAssets,AccumulatedIncome,FrozenCapital,"
					+ "Frostgold,Accountbalance,Goldgrammage,Goldpresentvalue,AccountStatus,UserId)"
					+ "VALUES(?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setBigDecimal(1,account.getTotalAssets());
			ps.setBigDecimal(2,account.getAccumulatedIncome());
			ps.setBigDecimal(3, account.getFrozenCapital());
			ps.setBigDecimal(4,account.getFrostgold());
			ps.setBigDecimal(5,account.getAccountbalance());
			ps.setBigDecimal(6, account.getGoldgrammage());
			ps.setBigDecimal(7, account.getGoldpresentvalue());
			ps.setInt(8, account.getAccountStatus());
			ps.setLong(9, account.getUserId());
			int count = ps.executeUpdate();
			
			
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select accountId from t_account order by accountId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			
			while(rs.next()){
				account.setAccountId(rs.getLong("accountId"));
			}
			
			
			ConnectionUtil.closeResource(con, ps, null);
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Integer updateFrozenCapital(Account account) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "update t_account SET FrozenCapital= ? WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setBigDecimal(1, account.getFrozenCapital());
			ps.setLong(2, account.getUserId());
			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		AccountDao accountDao = new AccountDaoImpl(); 
		List<Account> aa = accountDao.findUser();
		System.out.println(aa);
	}
}
