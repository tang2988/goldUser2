package cn.jbit.Servlet;

import java.util.List;

import cn.jbit.Dao.OrderinformationDao;
import cn.jbit.DaoImpl.OrderinformationDaoImpl;
import cn.jbit.entity.Orderinformation;


public class xie {
	public static void main(String[] args){
 
		OrderinformationDao od = new OrderinformationDaoImpl();
		List<Orderinformation> aa = od.findOrderAll();
		System.out.println(aa);
	}

}
