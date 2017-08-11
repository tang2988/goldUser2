package cn.jbit.Dao;

import java.util.List;

import cn.jbit.entity.Orderinformation;


public interface OrderinformationDao {
	
	public Orderinformation addOrder(Orderinformation orderinformation);
	
	
	public List<Orderinformation> findOrderDefeated();
	
	public Integer updateOrder(Orderinformation orderinformation);
	
	public Orderinformation findOrderById(Long UserId);
	
	public List<Orderinformation> findOrderAll();
	
	
}
