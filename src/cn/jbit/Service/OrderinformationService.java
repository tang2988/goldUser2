package cn.jbit.Service;

import java.util.List;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Address;
import cn.jbit.entity.Orderinformation;

public interface OrderinformationService {
	
	/**
	 * 添加订单记录
	 * @param orderinformation
	 * @return
	 */
	public ResBo addOrder(Orderinformation orderinformation,Address addre);
	
	public ResBo pay(Orderinformation orderinformation);
	
	public Integer updateOrder(Orderinformation orderinformation);
	
	public Orderinformation findOrderById(Long UserId);
	
	public List<Orderinformation> findOrderAll();

}
