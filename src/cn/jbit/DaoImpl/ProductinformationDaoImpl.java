package cn.jbit.DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jbit.Dao.ProductinformationDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Productinformation;

public class ProductinformationDaoImpl implements ProductinformationDao {

	
	public Productinformation addProduct(Productinformation productinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_productinformation(productType,gramWeight,brand,productPrice,bepertory,detailpage,productName,productStatus)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,productinformation.getProductType());
			ps.setString(2,productinformation.getGramWeight());
			ps.setString(3, productinformation.getBrand());
			ps.setBigDecimal(4,productinformation.getProductPrice());
			ps.setInt(5,productinformation.getBepertory());
			ps.setString(6,productinformation.getDetailpage());
			ps.setString(7,productinformation.getProductName());
			ps.setInt(8, productinformation.getProductStatus());
			
			int count = ps.executeUpdate();
			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select productId from t_productinformation order by productId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while(rs.next()){
				productinformation.setProductId(rs.getLong("productId"));
			}
			ConnectionUtil.closeResource(con, ps, null);
			return productinformation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Productinformation findProById(Long productId) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Productinformation  pf =null;
			String sql = "select * from t_productinformation where productId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, productId);
			rs = ps.executeQuery();
			while(rs.next()){
				pf = new Productinformation();
				pf.setProductId(rs.getLong("productId"));
				pf.setProductType(rs.getString("productType"));
				pf.setGramWeight(rs.getString("gramWeight"));
				pf.setBrand(rs.getString("brand"));
				pf.setProductPrice(rs.getBigDecimal("productPrice"));
				pf.setBepertory(rs.getInt("bepertory"));
				pf.setDetailpage(rs.getString("detailpage"));
				pf.setProductName(rs.getString("productName"));
				pf.setProductStatus(rs.getInt("productStatus"));
				
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return pf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Productinformation> findProductionformation() {
		List<Productinformation> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "select * from t_productinformation where productStatus = 10";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Productinformation	pf = new Productinformation();
				pf.setProductId(rs.getLong("productId"));
				pf.setProductType(rs.getString("productType"));
				pf.setGramWeight(rs.getString("gramWeight"));
				pf.setBrand(rs.getString("brand"));
				pf.setProductPrice(rs.getBigDecimal("productPrice"));
				pf.setBepertory(rs.getInt("bepertory"));
				pf.setDetailpage(rs.getString("detailpage"));
				pf.setProductName(rs.getString("productName"));
				pf.setProductStatus(rs.getInt("productStatus"));
				list.add(pf);
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public Integer Update(Productinformation productinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE t_productinformation set bepertory=? WHERE productId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,productinformation.getBepertory());
			ps.setLong(2, productinformation.getProductId());
			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Productinformation> findAllPage(int pageNo ,int pageSize){
		List<Productinformation> list = new ArrayList<Productinformation>();
		try {
			
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			int gongshi = pageSize*(pageNo-1);
			String sql = " select * from t_productinformation WHERE productStatus =10 LIMIT "+gongshi +pageSize;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				 Productinformation pf = new Productinformation();
				pf.setProductId(rs.getLong("productId"));
				pf.setProductType(rs.getString("productType"));
				pf.setGramWeight(rs.getString("gramWeight"));
				pf.setBrand(rs.getString("brand"));
				pf.setProductPrice(rs.getBigDecimal("productPrice"));
				pf.setBepertory(rs.getInt("bepertory"));
				pf.setDetailpage(rs.getString("detailpage"));
				pf.setProductName(rs.getString("productName"));
				pf.setProductStatus(rs.getInt("productStatus"));
				list.add(pf);
			}	
			ConnectionUtil.closeResource(con, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public Integer UpdateAll(Productinformation productinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "update t_productinformation SET productType=?,gramWeight=?,brand=?,productPrice=?," +
					"bepertory=?,detailpage=?,productName=?,productStatus=? " +
					"WHERE productId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1,productinformation.getProductType());
			ps.setString(2, productinformation.getGramWeight());
			ps.setString(3, productinformation.getBrand());
			ps.setBigDecimal(4, productinformation.getProductPrice());
			ps.setInt(5, productinformation.getBepertory());
			ps.setString(6, productinformation.getDetailpage());
			ps.setString(7, productinformation.getProductName());
			ps.setInt(8, productinformation.getProductStatus());
			ps.setLong(9, productinformation.getProductId());
		
			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Long procount() {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select count(1) from t_productinformation";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			Long count = 0L;
			while(rs.next()){
				 count = rs.getLong("count(1)");
			}
			ConnectionUtil.closeResource(con, ps, rs);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		
	

	 
	}



}
