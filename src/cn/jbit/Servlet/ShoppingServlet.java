package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.jbit.Service.OrderinformationService;
import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.OrderinformationServiceImpl;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;
import cn.jbit.entity.User;

public class ShoppingServlet extends HttpServlet {

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
		
		
		OrderinformationService orderinformationService = new OrderinformationServiceImpl();
		List<Map<String, Object>> mapList = orderinformationService.OrderAll(login.getUserId());
		
		List<Orderinformation> list = orderinformationService.findOrderAll(login.getUserId());
/*		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().write(json.toJSONString());*/
		request.setAttribute("mapList", mapList);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/Jsp/ShoppingOrder.jsp").forward(request, response);
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
