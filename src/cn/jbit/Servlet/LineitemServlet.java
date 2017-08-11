package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import cn.jbit.entity.Address;
import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;
import cn.jbit.entity.User;

public class LineitemServlet extends HttpServlet {

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
		String orderId = request.getParameter("orderId");
		
		response.setCharacterEncoding("utf-8");
		OrderinformationService os = new OrderinformationServiceImpl();
		ProductinformationService ps = new ProductinformationServiceImpl();
		AddressService as = new AddressServiceImpl();
		
		Orderinformation orderinformation = os.findOrderById(login.getUserId(),Long.valueOf(orderId));
		
		Productinformation productinformation = ps.findProById(orderinformation.getProductId());
		
		Address address = as.findByuserId(login.getUserId(),orderinformation.getAddressId());
		
		request.setAttribute("orderinformation", orderinformation);
		request.setAttribute("productinformation", productinformation);
		request.setAttribute("address", address);
		request.getRequestDispatcher("/WEB-INF/Jsp/Lineitem.jsp").forward(request, response);
		
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

		
	}

}
