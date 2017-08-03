package cn.jbit.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.AddressService;
import cn.jbit.Service.OrderinformationService;
import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.AddressServiceImpl;
import cn.jbit.ServiceImpl.OrderinformationServiceImpl;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Address;
import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;
import cn.jbit.entity.User;

public class ConfirmAnorderServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User login = (User) request.getSession().getAttribute("login");
		if(login == null){
			response.sendRedirect("../userlogin/login.do");
			return;
		}
		
		String product = request.getParameter("product");
		String shuliang = request.getParameter("shuliang");
		ProductinformationService productinformationService = new ProductinformationServiceImpl();
		
		Productinformation productin = productinformationService.findProById(Long.valueOf(product));
		
		AddressService addressService = new AddressServiceImpl();
		
		Address ad = addressService.findByuserId(login.getUserId());
		
		 BigDecimal price = productin.getProductPrice();
		 
		 BigDecimal shulian = new BigDecimal(shuliang);
		 
		 BigDecimal ab = shulian.multiply(price);
		
		request.setAttribute("productin", productin);
		request.setAttribute("ad", ad);
		request.getRequestDispatcher("/WEB-INF/Jsp/ConfirmAnorder.jsp").forward(request, response);

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String url = request.getRequestURI();
			if(url.endsWith("/confirm.do")){
				
				User login = (User) request.getSession().getAttribute("login");
				if(login == null){
					response.sendRedirect("../userlogin/login.do");
					return;
				}
				
				String name = request.getParameter("name");
				String mobliPhone = request.getParameter("mobliPhone");
				String select = request.getParameter("select");
				String address = request.getParameter("address");
				String fapiao = request.getParameter("fapiao");
				String Kuaidi = request.getParameter("Kuaidi");
				String Beizhu = request.getParameter("Beizhu");
				
				select = new String(select.getBytes("iso-8859-1"),"utf-8");
				Kuaidi = new String(Kuaidi.getBytes("iso-8859-1"),"utf-8");
				select = new String(select.getBytes("iso-8859-1"),"utf-8");
				if(name==null || name.equals("") & mobliPhone==null || mobliPhone.equals("")){
					response.sendRedirect("confirm/confirm.do");
				}
				AddressService addressService = new AddressServiceImpl();
				OrderinformationService orderinformationService = new OrderinformationServiceImpl();
				Address addres = new Address();
				addres.setMobilePhone(mobliPhone);
				addres.setTwelveProvincesAndcities(select);
				addres.setDetailedAddressStreet(address);
				addres.setUserId(login.getUserId());
				addres.setUserName(name);
				Orderinformation orderinformation = new Orderinformation();
				orderinformation.setProductId(1L);
				orderinformation.setQuantity(1);
				orderinformation.setOrderAmount(new BigDecimal(2000));
				orderinformation.setOrderStatus(10);
				orderinformation.setOrderTime(new Date());
				orderinformation.setCauseoffailure("222");
				orderinformation.setAddressId(10L);
				orderinformation.setInvoiceInformation(fapiao);
				orderinformation.setUserId(login.getUserId());
				orderinformation.setDistributioncompany(Kuaidi);
				orderinformation.setTrackingNumberCourierNumber(111111123123L);
				orderinformation.setRemark(Beizhu);
				orderinformation.setPaymentMethod("支付方式");
				ResBo aa = orderinformationService.addOrder(orderinformation, addres);
				if(aa.getMsg()!=null){
					request.setAttribute("aa","成功");
					request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response);
				}else{
					response.sendRedirect("confirm/confirm.do");
				}
		}else if(url.endsWith("/Pay.do")){
			OrderinformationService ofs = new OrderinformationServiceImpl();
			Orderinformation orderinformation = new Orderinformation();
			ofs.pay(orderinformation );
		}
			
	}

}