package cn.jbit.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;

public class ProductinformationServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	
	 *
	 */
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		ProductinformationService productinformationService = new ProductinformationServiceImpl();
		String url = request.getRequestURI();
		if(url.endsWith("xxh")){
			
			 String pageNo = request.getParameter("pageNo");
			 String pagesize = request.getParameter("pagesize");
		 List<Productinformation> pft = productinformationService.findProductionformation();
		
			
			if (pageNo == null) {
				pageNo = "1";
			}

			if (pagesize == null) {
				pagesize = "4";
			}
			Long count = productinformationService.procount();
			long pageCount = count % Integer.valueOf(pagesize) == 0 ? count
					/ Integer.valueOf(pagesize) : count
					/ Integer.valueOf(pagesize) + 1;
			
			request.setAttribute("pageCount", pageCount);
			
			long beginPageNo = 1;
			long endPageNo = pageCount;
			request.setAttribute("beginPageNo", beginPageNo);
			request.setAttribute("endPageNo", endPageNo);
			request.setAttribute("pft", pft);
		 request.getRequestDispatcher("/WEB-INF/Jsp/Chanping.jsp").forward(request, response);
		}
	}

}
