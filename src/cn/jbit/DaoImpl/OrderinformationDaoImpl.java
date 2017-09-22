package cn.jbit.DaoImpl;

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

import cn.jbit.Dao.OrderinformationDao;
import cn.jbit.Util.ConnectionUtil;
import cn.jbit.entity.Orderinformation;

public class OrderinformationDaoImpl implements OrderinformationDao {

	public Orderinformation addOrder(Orderinformation orderinformation) {

		try {

			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "INSERT INTO t_orderinformation"
					+ "(productId,quantity,orderAmount,orderStatus,orderTime,"
					+ "timeofpayment,deliverytime,receivingtime,failuretime,"
					+ "causeoffailure,addressId,invoiceInformation,userId,distributioncompany,"
					+ "trackingNumberCourierNumber,remark,paymentMethod)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, orderinformation.getProductId());
			ps.setInt(2, orderinformation.getQuantity());
			ps.setBigDecimal(3, orderinformation.getOrderAmount());
			ps.setInt(4, orderinformation.getOrderStatus());
			ps.setTimestamp(5, new Timestamp(orderinformation.getOrderTime().getTime()));
			ps.setTimestamp(6, null);
			ps.setTimestamp(7, null);
			ps.setTimestamp(8, null);
			ps.setTimestamp(9, null);
			ps.setString(10, orderinformation.getCauseoffailure());
			ps.setLong(11, orderinformation.getAddressId());
			ps.setString(12, orderinformation.getInvoiceInformation());
			ps.setLong(13, orderinformation.getUserId());
			ps.setString(14, orderinformation.getDistributioncompany());
			ps.setLong(15, orderinformation.getTrackingNumberCourierNumber());
			ps.setString(16, orderinformation.getRemark());
			ps.setString(17, orderinformation.getPaymentMethod());

			int count = ps.executeUpdate();

			ResultSet rs = null;
			PreparedStatement pss = null;
			String sql2 = "select orderId from t_orderinformation order by orderId desc limit 1";
			pss = con.prepareStatement(sql2);
			rs = pss.executeQuery();
			while (rs.next()) {
				orderinformation.setOrderId(rs.getLong("orderId"));
			}

			
			ConnectionUtil.closeResource(con, ps, null);
			return orderinformation;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Orderinformation> findOrderDefeated() {
		List<Orderinformation> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_orderinformation WHERE orderStatus =10 AND orderTime <ADDDATE(NOW(),INTERVAL -10 MINUTE)";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				Orderinformation order = new Orderinformation();
				order.setOrderId(rs.getLong("orderId"));
				order.setProductId(rs.getLong("productId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderAmount(rs.getBigDecimal("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				order.setOrderTime(rs.getDate("orderTime"));
				order.setTimeofpayment(rs.getDate("timeofpayment"));
				order.setDeliverytime(rs.getDate("deliverytime"));
				order.setReceivingtime(rs.getDate("receivingtime"));
				order.setFailuretime(rs.getDate("failuretime"));
				order.setCauseoffailure(rs.getString("causeoffailure"));
				order.setAddressId(rs.getLong("addressId"));
				order.setInvoiceInformation(rs.getString("invoiceInformation"));
				order.setUserId(rs.getLong("userId"));
				order.setDistributioncompany(rs.getString("distributioncompany"));
				order.setTrackingNumberCourierNumber(rs.getLong("trackingNumberCourierNumber"));
				order.setRemark(rs.getString("remark"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				list.add(order);

			}

			ConnectionUtil.closeResource(con, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Orderinformation findOrderById(Long UserId,Long orderId) {

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Orderinformation order = null;
			String sql = "select * from t_orderinformation Where userId = ? and t_orderinformation.orderId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, UserId);
			ps.setLong(2, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {

				order = new Orderinformation();
				order.setOrderId(rs.getLong("orderId"));
				order.setProductId(rs.getLong("productId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderAmount(rs.getBigDecimal("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				order.setOrderTime(rs.getDate("orderTime"));
				order.setTimeofpayment(rs.getDate("timeofpayment"));
				order.setDeliverytime(rs.getDate("deliverytime"));
				order.setReceivingtime(rs.getDate("receivingtime"));
				order.setFailuretime(rs.getDate("failuretime"));
				order.setCauseoffailure(rs.getString("causeoffailure"));
				order.setAddressId(rs.getLong("addressId"));
				order.setInvoiceInformation(rs.getString("invoiceInformation"));
				order.setUserId(rs.getLong("userId"));
				order.setDistributioncompany(rs.getString("distributioncompany"));
				order.setTrackingNumberCourierNumber(rs.getLong("trackingNumberCourierNumber"));
				order.setRemark(rs.getString("remark"));
				order.setPaymentMethod(rs.getString("paymentMethod"));

			}

			ConnectionUtil.closeResource(con, ps, rs);
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Orderinformation> findOrderAll(Long UserId) {
		List<Orderinformation> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Orderinformation order = null;
			String sql = "select * from t_orderinformation Where userId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, UserId);
			rs = ps.executeQuery();
			while (rs.next()) {

				order = new Orderinformation();
				order.setOrderId(rs.getLong("orderId"));
				order.setProductId(rs.getLong("productId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderAmount(rs.getBigDecimal("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				order.setOrderTime(rs.getDate("orderTime"));
				order.setTimeofpayment(rs.getDate("timeofpayment"));
				order.setDeliverytime(rs.getDate("deliverytime"));
				order.setReceivingtime(rs.getDate("receivingtime"));
				order.setFailuretime(rs.getDate("failuretime"));
				order.setCauseoffailure(rs.getString("causeoffailure"));
				order.setAddressId(rs.getLong("addressId"));
				order.setInvoiceInformation(rs.getString("invoiceInformation"));
				order.setUserId(rs.getLong("userId"));
				order.setDistributioncompany(rs.getString("distributioncompany"));
				order.setTrackingNumberCourierNumber(rs.getLong("trackingNumberCourierNumber"));
				order.setRemark(rs.getString("remark"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				list.add(order);
			}

			ConnectionUtil.closeResource(con, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer updateOrder(Orderinformation orderinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE t_orderinformation  set  orderStatus = ?,failuretime =? ,causeoffailure = ? where orderId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderinformation.getOrderStatus());
			ps.setTimestamp(2, new Timestamp(orderinformation.getFailuretime().getTime()));
			ps.setString(3, orderinformation.getCauseoffailure());
			ps.setLong(4, orderinformation.getOrderId());

			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	
	
	public Integer updatePayOrder(Orderinformation orderinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE t_orderinformation  set  orderStatus = ?,timeofpayment =?   where orderId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderinformation.getOrderStatus());
			ps.setTimestamp(2, new Timestamp(orderinformation.getTimeofpayment().getTime()));
			ps.setLong(3, orderinformation.getOrderId());

			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public List<Map<String, Object>> OrderAll(Long UserId) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "select t_orderinformation.orderId,t_orderinformation.orderTime,"
					+ "t_productinformation.gramWeight,t_orderinformation.orderStatus,"
					+ "t_orderinformation.quantity,"
					+ "t_productinformation.productName from t_orderinformation "
					+ "INNER JOIN t_productinformation ON t_orderinformation.productId = t_productinformation.productId "
					+ "WHERE UserId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, UserId);
			rs = ps.executeQuery();
			while (rs.next()) {

				Map<String, Object> row = new HashMap<String, Object>();
				row.put("gramWeight", rs.getString("gramWeight"));
				row.put("productName", rs.getString("productName"));
				row.put("orderId", rs.getLong("orderId"));
				row.put("orderTime", rs.getDate("orderTime"));
				row.put("quantity", rs.getInt("quantity"));
				row.put("orderStatus", rs.getInt("orderStatus"));

				list.add(row);
			}

			ConnectionUtil.closeResource(con, ps, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Orderinformation> findAll(){
		List<Orderinformation> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_orderinformation";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Orderinformation order = new Orderinformation();
				order.setOrderId(rs.getLong("orderId"));
				order.setProductId(rs.getLong("productId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderAmount(rs.getBigDecimal("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				order.setOrderTime(rs.getDate("orderTime"));
				order.setTimeofpayment(rs.getDate("timeofpayment"));
				order.setDeliverytime(rs.getDate("deliverytime"));
				order.setReceivingtime(rs.getDate("receivingtime"));
				order.setFailuretime(rs.getDate("failuretime"));
				order.setCauseoffailure(rs.getString("causeoffailure"));
				order.setAddressId(rs.getLong("addressId"));
				order.setInvoiceInformation(rs.getString("invoiceInformation"));
				order.setUserId(rs.getLong("userId"));
				order.setDistributioncompany(rs.getString("distributioncompany"));
				order.setTrackingNumberCourierNumber(rs.getLong("trackingNumberCourierNumber"));
				order.setRemark(rs.getString("remark"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				list.add(order);
			}
			ConnectionUtil.closeResource(con, ps, rs);
		}
		 catch (SQLException e) {
			e.printStackTrace();
	}
		return list;
		
}
	
	public Orderinformation findAllById(Long orderId){
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_orderinformation where orderId = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, orderId);
			rs = ps.executeQuery();
			while(rs.next()){
				Orderinformation order = new Orderinformation();
				order.setOrderId(rs.getLong("orderId"));
				order.setProductId(rs.getLong("productId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setOrderAmount(rs.getBigDecimal("orderAmount"));
				order.setOrderStatus(rs.getInt("orderStatus"));
				order.setOrderTime(rs.getDate("orderTime"));
				order.setTimeofpayment(rs.getDate("timeofpayment"));
				order.setDeliverytime(rs.getDate("deliverytime"));
				order.setReceivingtime(rs.getDate("receivingtime"));
				order.setFailuretime(rs.getDate("failuretime"));
				order.setCauseoffailure(rs.getString("causeoffailure"));
				order.setAddressId(rs.getLong("addressId"));
				order.setInvoiceInformation(rs.getString("invoiceInformation"));
				order.setUserId(rs.getLong("userId"));
				order.setDistributioncompany(rs.getString("distributioncompany"));
				order.setTrackingNumberCourierNumber(rs.getLong("trackingNumberCourierNumber"));
				order.setRemark(rs.getString("remark"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				list.add(order);
			}
			ConnectionUtil.closeResource(con, ps, rs);
		}
		 catch (SQLException e) {
			e.printStackTrace();
	}
		return list.get(0);
		
}

	public Integer delivery(Orderinformation orderinformation){
	
			
			try {
				Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = null;
				
				String sql = "update t_orderinformation set orderStatus=?,deliverytime=?,distributioncompany=?,trackingNumberCourierNumber=? WHERE orderId =?";
				
				ps = con.prepareStatement(sql);
				ps.setInt(1, orderinformation.getOrderStatus());
				ps.setTimestamp(2, new Timestamp(orderinformation.getDeliverytime().getTime()));
				ps.setString(3, orderinformation.getDistributioncompany());
				ps.setLong(4, orderinformation.getTrackingNumberCourierNumber());
				ps.setLong(5, orderinformation.getOrderId());
				int count = ps.executeUpdate();
				
				ConnectionUtil.closeResource(con, ps, null);
				return count;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	
		return null;
		
	}
	
	public static void main(String[] args) {
		OrderinformationDao of = new OrderinformationDaoImpl();
		  
		  List<Orderinformation> aa = of.findAll();
		System.out.println(aa);
	}
	
	public List<Map<String, Object>> findAll1(){
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select * from t_orderinformation";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("orderId",rs.getLong("orderId"));
				map.put("productId",rs.getLong("productId"));
				map.put("quantity",rs.getInt("quantity"));
				map.put("orderAmount",rs.getBigDecimal("orderAmount"));
				map.put("orderStatus",rs.getInt("orderStatus"));
				map.put("orderTime",rs.getDate("orderTime"));
				map.put("timeofpayment",rs.getDate("timeofpayment"));
				map.put("orderId",rs.getDate("deliverytime"));
				map.put("orderId",rs.getDate("receivingtime"));
				map.put("orderId",rs.getDate("failuretime"));
				map.put("orderId",rs.getString("causeoffailure"));
				map.put("orderId",rs.getLong("addressId"));
				map.put("orderId",rs.getString("invoiceInformation"));
				map.put("orderId",rs.getLong("userId"));
				map.put("orderId",rs.getString("distributioncompany"));
				map.put("orderId",rs.getLong("trackingNumberCourierNumber"));
				map.put("orderId",rs.getString("remark"));
				map.put("orderId",rs.getString("paymentMethod"));
				list.add(map);
			}
			ConnectionUtil.closeResource(con, ps, rs);
		}
		 catch (SQLException e) {
			e.printStackTrace();
	}
		return null;
		
	}
	public Integer updateShouHuo(Orderinformation orderinformation) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = null;
			String sql = "UPDATE t_orderinformation SET orderStatus =? ,receivingtime=? where orderId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderinformation.getOrderStatus());
			ps.setTimestamp(2, new Timestamp(orderinformation.getReceivingtime().getTime()));
			ps.setLong(3, orderinformation.getOrderId());

			int count = ps.executeUpdate();
			ConnectionUtil.closeResource(con, ps, null);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
