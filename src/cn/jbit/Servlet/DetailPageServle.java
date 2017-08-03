package cn.jbit.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;

public class DetailPageServle extends HttpServlet {

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
		
		String url = request.getRequestURI();
			if(url.endsWith("/detail")){
				response.setCharacterEncoding("utf-8");
				ProductinformationService productinformationService = new ProductinformationServiceImpl();
				
				Productinformation productinformation = productinformationService.findProById(1L);
				
				request.setAttribute("productinformation", productinformation);
				request.getRequestDispatcher("/WEB-INF/Jsp/DetailPage.jsp").forward(request, response);
				return;
			}
		
		
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
