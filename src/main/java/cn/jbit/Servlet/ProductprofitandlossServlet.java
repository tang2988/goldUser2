package cn.jbit.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;
import cn.jbit.entity.User;
import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.api.http.PriceHttpApi;
import cn.xxh.gold.sys.api.http.ProductprofitandHttpApi;
import cn.xxh.gold.vo.PriceVo;
import cn.xxh.gold.vo.ProductProfitandLossVo;

public class ProductprofitandlossServlet extends HttpServlet {

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

		
		ProductprofitandHttpApi httpApi = new ProductprofitandHttpApi();
		PriceHttpApi priceHttpApi = new PriceHttpApi();
		
		String url = request.getRequestURI();

		if(url.endsWith("/productdetailpage")) {
			User login = (User) request.getSession().getAttribute("login");
			if(login == null){
				response.sendRedirect("../userlogin/login.do");
				return;
			}

			response.setCharacterEncoding("utf-8");
			
			
			String productId = request.getParameter("productId");
			
			ResBo resbo = priceHttpApi.findPricedo();
			System.out.println(resbo.getData());
			request.setAttribute("PriceMoney", resbo.getData());
			
			 ResBo lossVo = httpApi.findProductProfitandLossByProductId(Long.valueOf(productId));
			System.out.println(lossVo);
			request.setAttribute("lossVo", lossVo.getData());
			
			request.getRequestDispatcher("/WEB-INF/Jsp/StabilityofgoldDetailpage.jsp").forward(request, response);
			
		}else if(url.endsWith("productpage.do")){
			String page = request.getParameter("page");
			String pagesize = request.getParameter("pagesize");
			
			long pageLong = page ==null ?1L:Long.valueOf(page);
			Integer pageSizeLong = page ==null ?3:Integer.valueOf(pagesize);
			Page pg = new Page();
			pg.setPage(pageLong);
			pg.setPagesize(pageSizeLong);
		 ResBo productProfitandLossResBo = httpApi.findByPage(pg);
			System.out.println(productProfitandLossResBo);
			
			request.setAttribute("product", productProfitandLossResBo.getData());
			request.getRequestDispatcher("/WEB-INF/Jsp/ProductprofitandlossList.jsp").forward(request, response);
			
		}

	}

}
