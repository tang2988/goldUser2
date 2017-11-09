package cn.jbit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.Dao.BanklistDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Banklist;

public class BanklistDaoImpl implements BanklistDao {
	
	public List<Banklist> findAll(){
		List<Banklist> lst = new ArrayList<Banklist>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_banklist";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Banklist bk = new Banklist();
				bk.setBanklistId(rs.getLong("banklistId"));
				bk.setBanklistStatus(rs.getInt("banklistStatus"));
				bk.setBankname(rs.getString("Bankname"));
				bk.setImageUrl(rs.getString("ImageUrl"));
				bk.setOnlinebanking(rs.getString("Onlinebanking"));
				
				lst.add(bk);	
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return lst;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}