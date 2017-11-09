package cn.jbit.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	public Orderinformation findOrderById(Long UserId,Long orderId);
	
	public List<Orderinformation> findOrderAll(Long UserId);
	
	public List<Map<String, Object>> OrderAll(Long UserId);
	
	
	
	public Orderinformation findAllById(Long orderId);
	
	public List<Orderinformation> findAll();
	
	public ResBo delivery(Long orderId, String distributioncompany,Long trackingNumberCourierNumber);
	
	public ResBo updateShouHuo(Orderinformation orderinformation);

	public ResBo ReturnOfGoods(Orderinformation orderinformation);
	
	public ResBo ReturnOfGoodsSixty(Orderinformation orderinformation);
	
	public ResBo Thesystemorderisinvalid(Orderinformation orderinformation);
	public ResBo CancellationOfOrder(Orderinformation orderinformation);
}
