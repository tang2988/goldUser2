package cn.jbit.Servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Dao.UserDao;
import cn.jbit.DaoImpl.UserDaoImpl;
import cn.jbit.Service.AccountService;
import cn.jbit.ServiceImpl.AccountServiceImpl;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.api.http.OrderSteadyprofitHttpApi;
import cn.xxh.gold.vo.TableOrderAndproductAndOrderIdVo;

import com.alibaba.fastjson.JSON;

public class OrdersteadyprofitServlet extends HttpServlet {
	String md5_salt = "123456";

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User login = (User) request.getSession().getAttribute("login");
		if (login == null) {
			response.sendRedirect("../userlogin/login.do");
			return;
		}
		OrderSteadyprofitHttpApi api = new OrderSteadyprofitHttpApi();
		
		String url = request.getRequestURI();
		if (url.endsWith("orderAndProfit")) {
			  ResBo resBo = api.findOrderAndPrductprofitUserId(login.getUserId(),md5_salt);
			request.setAttribute("andProductVoList", resBo.getData());
			request.getRequestDispatcher("/WEB-INF/Jsp/OrdersteadyprofitList.jsp").forward(request, response);
		
		}else if(url.endsWith("TheOrderDetails.do")){
			
			String  orderId = request.getParameter("orderId");
			
			
			 ResBo resBo = api.OrderAndProductprofitUserIdAndOrderId(login.getUserId(), Long.valueOf(orderId),md5_salt);
			 
			
			request.setAttribute("orderProductVo", resBo.getData());
			request.getRequestDispatcher("/WEB-INF/Jsp/TheOrderDetails.jsp").forward(request, response);
		
		}else if(url.endsWith("CancelOrder.do")){
			String  orderId = request.getParameter("orderId");
			 ResBo cancelOrder = api.CancelOrder(Long.valueOf(orderId),md5_salt);
			 if(cancelOrder.isSuccess()){
				 request.setAttribute("res", cancelOrder.getMsg());
				 request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response);
				
			 }else{
				 response.sendRedirect("/WEB-INF/Jsp/error.jsp");
			}
			
		}else if(url.endsWith("Pay.do")){
		String orderId = request.getParameter("orderId");
		String transactionPwd = request.getParameter("transactionPwd");
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findUserById(login.getUserId());
		if(transactionPwd.equals(user.getTransactionPwd())){
			ResBo resbo = api.Pay(Long.valueOf(orderId), login.getUserId(),md5_salt);
			 if(resbo.isSuccess()){
				 request.setAttribute("res", resbo.getMsg());
				 request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response);
				 return;
			 }
		}
			 response.sendRedirect("/WEB-INF/Jsp/error.jsp");
	}
			 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User login = (User) request.getSession().getAttribute("login");
		if (login == null) {
			response.sendRedirect("../userlogin/login.do");
			return;
		}

		OrderSteadyprofitHttpApi api = new OrderSteadyprofitHttpApi();
		

		String url = request.getRequestURI();
		// 稳赢金下单
		if (url.endsWith("OrderAdd")) {

			// 产品ID
			String productId = request.getParameter("productId");
			// 下单金额
			String totalOrder = request.getParameter("totalOrder");

			
			// 下单
			ResBo resbo = api.addorder(Long.valueOf(productId),login.getUserId(), new BigDecimal(totalOrder),md5_salt);
			if (resbo.isSuccess()) {
					
				
				JSON json = (JSON) JSON.toJSON(resbo.getData());
				  TableOrderAndproductAndOrderIdVo tableOrderAndproductAndOrderIdVo = JSON.toJavaObject(json, TableOrderAndproductAndOrderIdVo.class);
				 ResBo tableOrderAndproductAndOrderIdRes = api.tableOrderAndproductAndOrderId(tableOrderAndproductAndOrderIdVo.getOrderId());
				 request.setAttribute("res", tableOrderAndproductAndOrderIdRes.getData());
				 
				 AccountService as = new AccountServiceImpl();
				 Account account = as.findAccount(login.getUserId());
				 request.setAttribute("account", account);
				 
				 request.setAttribute("resbo", resbo.getData());
				request.getRequestDispatcher(
						"/WEB-INF/Jsp/OrdersteadyprofitPay.jsp").forward(
						request, response);
				
			} else {

				response.sendRedirect("/WEB-INF/Jsp/error.jsp");
			}

		}
			
	}

}
