package cn.jbit.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.AddressDao;
import cn.jbit.Dao.OrderinformationDao;
import cn.jbit.Dao.ProductinformationDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.AddressDaoImpl;
import cn.jbit.DaoImpl.OrderinformationDaoImpl;
import cn.jbit.DaoImpl.ProductinformationDaoImpl;
import cn.jbit.Service.OrderinformationService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.Address;
import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;

public class OrderinformationServiceImpl implements OrderinformationService {

	AccountDao accountDao = new AccountDaoImpl();
	OrderinformationDao orderinformationDao = new OrderinformationDaoImpl();
	ProductinformationDao productinformationDao = new ProductinformationDaoImpl();
	AddressDao addressDao = new AddressDaoImpl();

	public ResBo addOrder(Orderinformation orderinformation, Address addre) {

		ResBo resBo = new ResBo();
		// 根据产品ID查询
		Productinformation productinformation = productinformationDao.findProById(orderinformation
				.getProductId());

		// 获取库存
		Integer kucun = productinformation.getBepertory();

		// 获取下单数量
		Integer shuliang = orderinformation.getQuantity();

		// 判断
		if (shuliang > kucun) {
			resBo.setMsg("库存不足");
			resBo.setSuccess(false);
			return resBo;
		}
		// TODO 保存地址
		Address addressDB = addressDao.add(addre);
		if (addressDB == null) {
			resBo.setMsg("保存地址失败");
			resBo.setSuccess(false);
			return resBo;
		}
		orderinformation.setAddressId(addressDB.getAddressId());

		Orderinformation count = orderinformationDao.addOrder(orderinformation);
		if (count != null) {
			// 库存赋值
			productinformation.setBepertory(kucun - orderinformation.getQuantity()); // 库存-数量

			Integer productin = productinformationDao.Update(productinformation);

			if (productin > 0) {
				resBo.setSuccess(true);
				resBo.setMsg("下单成功");
				resBo.setData(orderinformation);
				return resBo;
			} else if (productin > 0) {
				resBo.setMsg("成功");
			} else {
				resBo.setMsg("下单失败");
			}
		}
		return resBo;
	}

	public ResBo pay(Orderinformation orderinformation) {
		ResBo resBo = new ResBo();
		// 获取用户数据
		Account account = accountDao.findAccount(orderinformation.getUserId());

		// 获取用户余额
		BigDecimal money = account.getAccountbalance();

		// 获取下单金额
		BigDecimal aa = orderinformation.getOrderAmount();
		Long my = new Long(money.longValue()); // 用户余额
		Long lg = new Long(aa.longValue()); // 下单
		if (lg > my) {
			resBo.setMsg("余额不足");
			return resBo;
		} else { 
		}

		account.setAccountbalance(new BigDecimal(my - lg)); // 当前余额
															// -
															// 订单金额

		Boolean yuer = accountDao.JianKuan(account);
		if (yuer) {
			orderinformation.setOrderStatus(20);
			orderinformation.setTimeofpayment(new Date());
			Integer count = orderinformationDao.updatePayOrder( orderinformation);
			if(count>0){
				resBo.setSuccess(true);
				resBo.setMsg("支付成功");
				resBo.setData(yuer);
				return resBo;
			}else{
				resBo.setSuccess(false);
				resBo.setMsg("支付失败");
			}
			
		} else {
			resBo.setSuccess(false);
			resBo.setMsg("支付失败");
		}

		return resBo;

	}

	public static void main(String[] args) {
		OrderinformationService orderinformationService = new OrderinformationServiceImpl();

		Orderinformation orderinformation = new Orderinformation();
		orderinformation.setProductId(1L);
		orderinformation.setQuantity(1);
		orderinformation.setOrderAmount(new BigDecimal(1000.00));
		orderinformation.setOrderStatus(10);
		orderinformation.setOrderTime(new Date());
		orderinformation.setTimeofpayment(null);
		orderinformation.setDeliverytime(null);
		orderinformation.setReceivingtime(null);
		orderinformation.setFailuretime(null);
		orderinformation.setCauseoffailure("失败");
		orderinformation.setAddressId(1L);
		orderinformation.setInvoiceInformation("12312312");
		orderinformation.setUserId(1L);
		orderinformation.setDistributioncompany("顺丰");
		orderinformation.setTrackingNumberCourierNumber(1111111111111L);
		orderinformation.setRemark("慢点");
		orderinformation.setPaymentMethod("银行");
		Address addre = new Address();
		addre.setUserId(1L);
		addre.setDetailedAddressStreet("白石洲");
		addre.setMobilePhone("15012847930");
		addre.setTwelveProvincesAndcities("广东省深圳市南山区");
		addre.setUserName("xxh");
		ResBo aa = orderinformationService.addOrder(orderinformation, addre);
		ResBo bb = orderinformationService.pay(orderinformation);
		System.out.println("提示" + aa + "----" + bb);
	}

	public Integer updateOrder(Orderinformation orderinformation) {
		return orderinformationDao.updateOrder(orderinformation);
	}

	public Orderinformation findOrderById(Long UserId,Long orderId) {
		return orderinformationDao.findOrderById(UserId,orderId);
	}

	public List<Orderinformation> findOrderAll(Long UserId) {
		return orderinformationDao.findOrderAll(UserId);
	}

	public List<Map<String, Object>> OrderAll(Long UserId) {
		List<Map<String, Object>> lst = orderinformationDao.OrderAll(UserId);
		for (Map<String, Object> rowMap : lst) {
			Integer orderStatus = (Integer) rowMap.get("orderStatus");
			// 状态：10下单成功；20支付成功；30已发货；40已收货；90失败'
			switch (orderStatus) {
			case 10:
				rowMap.put("orderStatusStr", "下单成功");
				break;
			case 20:
				rowMap.put("orderStatusStr", "支付成功");
				break;
			case 30:
				rowMap.put("orderStatusStr", "已发货");
				break;
			case 40:
				rowMap.put("orderStatusStr", "已收货");
				break;
			case 90:
				rowMap.put("orderStatusStr", "失败");
				break;
			default:
				throw new RuntimeException("此状态不能识别"+orderStatus);
			}
		}
		return lst;

	}

	public Orderinformation findAllById(Long orderId) {
		return orderinformationDao.findAllById(orderId);
	}
	
	public List<Orderinformation> findAll() {
		return orderinformationDao.findAll();
	}

	public Integer delivery(Long orderId, String distributioncompany,
			Long trackingNumberCourierNumber) {
		 Orderinformation order = new Orderinformation();
		 order.setOrderId(orderId);
		 order.setDistributioncompany(distributioncompany);
		 order.setTrackingNumberCourierNumber(trackingNumberCourierNumber);
		 order.setOrderStatus(30);
		 order.setDeliverytime(new Date());
		return orderinformationDao.delivery(order);
	}

	public Integer updateShouHuo(Orderinformation orderinformation) {
		
		return orderinformationDao.updateShouHuo(orderinformation );
	}

	


}
