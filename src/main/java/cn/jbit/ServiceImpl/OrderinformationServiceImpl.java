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
import cn.jbit.entity.OrderinformationConstant;
import cn.jbit.entity.OrderinformationConstant2;
import cn.jbit.entity.Productinformation;

public class OrderinformationServiceImpl implements OrderinformationService {

	AccountDao accountDao = new AccountDaoImpl();
	OrderinformationDao orderinformationDao = new OrderinformationDaoImpl();
	ProductinformationDao productinformationDao = new ProductinformationDaoImpl();
	AddressDao addressDao = new AddressDaoImpl();

	public ResBo addOrder(Orderinformation orderinformation, Address addre) {
		ResBo resBo = new ResBo();

		/**** 检查用户账户是否可交易 */
		Account account = accountDao.findAccount(orderinformation.getUserId());
		if (account.getAccountStatus().equals(20)) {

			resBo.setMsg("用户不可交易，下单失败");
			resBo.setSuccess(false);
			return resBo;
		}

		// 根据产品ID查询
		Productinformation productinformation = productinformationDao
				.findProById(orderinformation.getProductId());

		/***************** 获取库存 */
		// 获取下单数量
		Integer shuliang = orderinformation.getQuantity();
		Integer kucun = productinformation.getBepertory();
		// 判断
		if (shuliang > kucun) {
			resBo.setMsg("库存不足");
			resBo.setSuccess(false);
			return resBo;
		}

		/****** 保存地址 */
		Address addressDB = addressDao.add(addre);
		if (addressDB == null) {
			resBo.setMsg("保存地址失败");
			resBo.setSuccess(false);
			return resBo;
		}
		orderinformation.setAddressId(addressDB.getAddressId());

		/************* 下单 */
		// 下单
		Orderinformation count = orderinformationDao.addOrder(orderinformation);
		if (count != null) {
			// 库存赋值
			productinformation.setBepertory(kucun
					- orderinformation.getQuantity()); // 库存-数量

			Integer productin = productinformationDao
					.Update(productinformation);

			if (productin > 0) {
				resBo.setSuccess(true);
				resBo.setMsg("下单成功");
				resBo.setData(orderinformation);
				return resBo;
			} else {
				resBo.setSuccess(false);
				resBo.setMsg("下单失败");
				return resBo;
			}
		} else {
			resBo.setSuccess(false);
			resBo.setMsg("下单失败");
		}

		return resBo;
	}

	public ResBo pay(Orderinformation orderinformation) {

		ResBo resBo = new ResBo();

		Orderinformation orderId = orderinformationDao
				.OrderById(orderinformation.getOrderId());

		// 状态已下单
		if (orderId.getOrderStatus() == 10) {

			/****** 检查账户余额 */
			// 获取用户数据
			Account account = accountDao.findAccount(orderId.getUserId());
			// 获取用户余额
			BigDecimal money = account.getAccountbalance();
			// 获取下单金额
			BigDecimal Amount = orderId.getOrderAmount();
			Long my = new Long(money.longValue()); // 用户余额
			Long lg = new Long(Amount.longValue()); // 下单金额
			if (lg > my) {
				resBo.setMsg("余额不足");
				resBo.setSuccess(false);
				return resBo;
			}

			/****** 支付成功 */
			account.setAccountbalance(money.subtract(Amount)); // 账户余额 - 订单金额
			// 修改扣减账户余额
			Boolean yuer = accountDao.JianKuan(account);
			if (yuer) {
				// 修改订单状态 已支付
				orderinformation.setOrderStatus(20);
				orderinformation.setTimeofpayment(new Date());
				Integer count = orderinformationDao
						.updatePayOrder(orderinformation);
				if (count > 0) {
					resBo.setSuccess(true);
					resBo.setMsg("支付成功");
					resBo.setData(yuer);
					return resBo;
				} else {
					resBo.setSuccess(false);
					resBo.setMsg("支付失败");
				}

			} else {
				resBo.setSuccess(false);
				resBo.setMsg("支付失败");
			}
		}
		return resBo;
	}

	public static void main(String[] args) {
		OrderinformationService orderinformationService = new OrderinformationServiceImpl();

		Orderinformation orderinformation = new Orderinformation();
		orderinformation.setOrderId(55L);
		ResBo aab = orderinformationService
				.Thesystemorderisinvalid(orderinformation);
		System.out.println(aab);

	}

	public Integer updateOrder(Orderinformation orderinformation) {
		return orderinformationDao.updateOrder(orderinformation);
	}

	public Orderinformation findOrderById(Long UserId, Long orderId) {
		return orderinformationDao.findOrderById(UserId, orderId);
	}

	public List<Orderinformation> findOrderAll(Long UserId) {
		return orderinformationDao.findOrderAll(UserId);
	}

	public List<Map<String, Object>> OrderAll(Long UserId) {
		List<Map<String, Object>> lst = orderinformationDao.OrderAll(UserId);
		for (Map<String, Object> rowMap : lst) {
			Integer orderStatus = (Integer) rowMap.get("orderStatus");
			// 状态：10下单成功；20支付成功；30已发货；40已收货；50已退货；60退货申请;90失败'
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
			case 50:
				rowMap.put("orderStatusStr", "已退货");
				break;
			case 60:
				rowMap.put("orderStatusStr", "退货申请");
				break;
			case 70:
				rowMap.put("orderStatusStr", "订单已经超时");
			case 90:
				rowMap.put("orderStatusStr", "失败");
				break;
			default:
				throw new RuntimeException("此状态不能识别" + orderStatus);
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

	public ResBo delivery(Long orderId, String distributioncompany,
			Long trackingNumberCourierNumber) {
		ResBo resBo = new ResBo();

		Orderinformation OrderId = orderinformationDao.OrderById(orderId); // 订单ID

		/** 检查订单状态是否已支付 */
		if (OrderId.getOrderStatus() == 20) {

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 发货 */
		Orderinformation order = new Orderinformation();
		order.setOrderId(orderId);
		order.setDistributioncompany(distributioncompany);
		order.setTrackingNumberCourierNumber(trackingNumberCourierNumber);
		order.setOrderStatus(30);
		order.setDeliverytime(new Date());
		orderinformationDao.delivery(order);

		return resBo;
	}

	public ResBo updateShouHuo(Orderinformation orderinformation) {
		ResBo resBo = new ResBo();

		Orderinformation OrderId = orderinformationDao
				.OrderById(orderinformation.getOrderId()); // 订单ID

		/** 检查状态是否已发货 */
		if (OrderId.getOrderStatus() == 30) {

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 已收货 */
		orderinformation.setOrderStatus(40);
		orderinformation.setReceivingtime(new Date());
		// 保存状态已收货 收货时间
		orderinformationDao.updateShouHuo(orderinformation);

		return resBo;
	}

	/*
	 * 
	 * 退货
	 */
	public ResBo ReturnOfGoods(Orderinformation orderinformation) {
		ResBo resBo = new ResBo();
		Orderinformation orderbyId = orderinformationDao
				.OrderById(orderinformation.getOrderId());

		/** 检查订单状态：已退货申请 */
		if (orderbyId.getOrderStatus() == 60) {

		} else {
			resBo.setSuccess(false);
			resBo.setMsg("退货失败");
			return resBo;
		}

		/** 退货成功 */
		orderinformation.setOrderStatus(50);
		Integer orderstatus = orderinformationDao
				.ReturnOfGoods(orderinformation);
		if (orderstatus > 0) {

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		// 根据产品ID查询
		Productinformation productinformation = productinformationDao
				.findProById(orderbyId.getProductId());
		// 获取库存
		Integer kucun = productinformation.getBepertory();
		// 库存赋值
		productinformation.setBepertory(kucun + orderbyId.getQuantity()); // 库存+数量
		Integer productin = productinformationDao.Update(productinformation);
		if (productin > 0) {
			Account moneyy = accountDao.findAccount(orderbyId.getUserId());
			BigDecimal balance = moneyy.getAccountbalance(); // 账户余额
			moneyy.setAccountbalance(balance.add(orderbyId.getOrderAmount()));
			Boolean updatemoney = accountDao.JianKuan(moneyy);
			if (updatemoney) {
				resBo.setSuccess(true);
				resBo.setMsg("成功");
				return resBo;
			} else {
				resBo.setSuccess(false);
				resBo.setMsg("失败");
				return resBo;
			}
		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
	}

	public ResBo ReturnOfGoodsSixty(Orderinformation orderinformation) {
		ResBo resBo = new ResBo();

		// 获取订单ID
		Orderinformation orderbyId = orderinformationDao
				.OrderById(orderinformation.getOrderId());
		/** 检查订单状态：已支付、已发货、已收货 */
		if (orderbyId.getOrderStatus() == 40
				|| orderbyId.getOrderStatus() == 30
				|| orderbyId.getOrderStatus() == 20) {

		} else {
			resBo.setMsg("退货失败");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 检查订单状态：已支付 */
		if (orderbyId.getOrderStatus() == 20) {
			// 根据产品ID查询
			Productinformation productinformation = productinformationDao
					.findProById(orderbyId.getProductId());
			// 获取库存
			Integer kucun = productinformation.getBepertory();
			// 库存赋值
			productinformation.setBepertory(kucun + orderbyId.getQuantity()); // 库存+数量
			Integer productin = productinformationDao
					.Update(productinformation);
			if (productin > 0) {
				Account moneyy = accountDao.findAccount(orderbyId.getUserId());
				BigDecimal balance = moneyy.getAccountbalance(); // 账户余额
				moneyy.setAccountbalance(balance.add(orderbyId.getOrderAmount()));
				Boolean updatemoney = accountDao.JianKuan(moneyy);
				if (updatemoney) {
					resBo.setSuccess(true);
					resBo.setMsg("成功退货");
					return resBo;
				} else {
					resBo.setSuccess(false);
					resBo.setMsg("失败");
					return resBo;
				}
			} else {
				resBo.setMsg("失败");
				resBo.setSuccess(false);
				return resBo;
			}

		} else {
			orderinformation.setOrderStatus(60);
			Integer tuihuoshenqing = orderinformationDao
					.ReturnOfGoodsSixty(orderinformation);
			if (tuihuoshenqing > 0) {
				resBo.setMsg("退货申请中");
				resBo.setSuccess(true);
			} else {
				resBo.setMsg("失败");
				resBo.setSuccess(false);
			}

		}
		return resBo;

	}

	public ResBo Thesystemorderisinvalid(Orderinformation orderinformation) {
		Orderinformation orderId = orderinformationDao
				.findAllById(orderinformation.getOrderId());
		ResBo resBo = new ResBo();

		/** 订单状态=已下单 */
		if (orderId.getOrderStatus() == 10) {

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}

		/** 下单时间超过1小时 */
		Date date = new Date(); // 实例化时间对象
		long time = date.getTime(); // 获取时间
		if (time - orderId.getOrderTime().getTime() > 3600 * 100) {

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		/** 订单作废 */
		orderinformation.setOrderStatus(OrderinformationConstant.orderStatus_70);
		Integer status = orderinformationDao.Thesystemorderisinvalid(orderinformation);
		if (status > 0) {
			// 根据产品ID查询
			Productinformation productinformation = productinformationDao.findProById(orderId.getProductId());
			// 获取库存
			Integer kucun = productinformation.getBepertory();
			// 库存+数量
			productinformation.setBepertory(kucun + orderId.getQuantity());
			// 保存修改
			Integer productin = productinformationDao.Update(productinformation);
			if (productin > 0) {
				resBo.setMsg("成功");
				resBo.setSuccess(true);
				return resBo;
			} else {
				resBo.setMsg("失败");
				resBo.setSuccess(false);
				return resBo;
			}
		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
	}

	public ResBo CancellationOfOrder(Orderinformation orderinformation) {
		ResBo resBo = new ResBo();
		Orderinformation orderid = orderinformationDao
				.findAllById(orderinformation.getOrderId()); // 根据订单ID查询全部
		/** 订单状态=已下单 */
		if (orderid.getOrderStatus() == 10) { // 获取状态 已下单

		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
		
		/** 成功取消订单 */
		Productinformation productinformation = productinformationDao
				.findProById(orderid.getProductId()); // 获取产品ID
		Integer kucun = productinformation.getBepertory(); // 获取库存
		productinformation.setBepertory(kucun + orderid.getQuantity()); // 库存+
																		// 库存赋值
		Integer productin = productinformationDao.Update(productinformation); // 修改产品库存
		if (productin > 0) {
			orderinformation.setOrderStatus(80); // 修改订单状态 已超时
			Integer status = orderinformationDao
					.CancellationOfOrder(orderinformation);
			if (status > 0) {
				resBo.setMsg("成功");
				resBo.setSuccess(true);
				return resBo;
			} else {
				resBo.setMsg("失败");
				resBo.setSuccess(false);
				return resBo;
			}
		} else {
			resBo.setMsg("失败");
			resBo.setSuccess(false);
			return resBo;
		}
	}
}
