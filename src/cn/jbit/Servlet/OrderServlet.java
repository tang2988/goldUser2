package cn.jbit.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.OrderinformationService;
import cn.jbit.ServiceImpl.OrderinformationServiceImpl;
import cn.jbit.entity.Orderinformation;

import com.alibaba.fastjson.JSONObject;


public class OrderServlet extends HttpServlet {

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

		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		OrderinformationService orderinformationService = new OrderinformationServiceImpl();
		if(url.endsWith("findAll.do")){
			
			
		
		 List<Orderinformation> list = orderinformationService.findAll();
		System.out.println(list);
		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("Rows", list);
		 jsonObject.put("Total", list.size());
		 
		 System.out.println(jsonObject);
		 
		response.getWriter().write(jsonObject.toJSONString());
		}else if(url.endsWith("delivery.do")){
			String orderId = request.getParameter("orderId");
			String distributioncompany = request.getParameter("distributioncompany");
			String trackingNumberCourierNumber = request.getParameter("trackingNumberCourierNumber");
			//http://localhost:8080/goldUser2/order/delivery.do？orderId=1&distributioncompany=圆通&trackingNumberCourierNumber=123
			Integer order = orderinformationService.delivery(Long.valueOf(orderId) , distributioncompany, Long.valueOf(trackingNumberCourierNumber));
			if(order>0){
				 JSONObject jsonObject = new JSONObject();
				 jsonObject.put("isOk", true);
				 jsonObject.put("msg", "发货成功");
				 System.out.println(jsonObject);
					response.getWriter().write(jsonObject.toJSONString());
			}else{
				 JSONObject jsonObject = new JSONObject();
				 jsonObject.put("isOk", false);
				 jsonObject.put("msg", "发货失败");
				 System.out.println(jsonObject);
					response.getWriter().write(jsonObject.toJSONString());
			}
		}else if(url.endsWith("findOne.do")){
			String orderrId = request.getParameter("orderrId");
			//http://localhost:8080/goldUser2/order/findOne.do?orderrId=
			  Orderinformation order = orderinformationService.findAllById(Long.valueOf(orderrId));
			 JSONObject jsonObject = new JSONObject();
			 jsonObject.put("order", order);
			 response.getWriter().write(jsonObject.toJSONString());
		}
	}
}
