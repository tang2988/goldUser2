package cn.jbit.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;

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

	public ResBo addOrder(Orderinformation orderinformation,Address addre) {

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
		//TODO 保存地址
		Address addressDB = addressDao.add(addre);
		if(addressDB==null){
			resBo.setMsg("保存地址失败");
			resBo.setSuccess(false);
			return resBo;
		}
		orderinformation.setAddressId(addressDB.getAddressId());
		
		 Orderinformation count = orderinformationDao.addOrder(orderinformation);
		if (count !=null ) {
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
		Long money = account.getAccountbalance();

		// 获取下单金额
		BigDecimal aa = orderinformation.getOrderAmount();
		Long ab = new Long(aa.longValue());
		if (ab>money) {
			resBo.setMsg("余额不足");
			return resBo;
		} else {
		}
		
		account.setAccountbalance(money - ab); // 当前余额
																				// -
																				// 订单金额

		Boolean yuer = accountDao.JianKuan(account);
		if (yuer) {
			resBo.setSuccess(true);
			resBo.setMsg("下单成功");
			resBo.setData(yuer);
			return resBo;
		} else {
			resBo.setMsg("下单失败");
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
		System.out.println("提示" + aa+"----"+ bb);
	}

	public Integer updateOrder(Orderinformation orderinformation) {
		return orderinformationDao.updateOrder(orderinformation);
	}

	public Orderinformation findOrderById(Long UserId) {
		return orderinformationDao.findOrderById(UserId);
	}

}
