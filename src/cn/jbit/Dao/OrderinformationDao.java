package cn.jbit.Dao;

import java.util.List;
import java.util.Map;

import cn.jbit.entity.Orderinformation;


public interface OrderinformationDao {
	
	public Orderinformation addOrder(Orderinformation orderinformation);
	
	
	public List<Orderinformation> findOrderDefeated();
	
	public Integer updateOrder(Orderinformation orderinformation);
	
	public Integer updatePayOrder(Orderinformation orderinformation) ;
	
	public Orderinformation findOrderById(Long UserId,Long orderId);
	
	public List<Orderinformation> findOrderAll(Long UserId);
	
	public List<Map<String, Object>> OrderAll(Long UserId);
	
	
	
	
}
