	package cn.jbit.Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;

public class ProductinServlet extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		ProductinformationService productinformationService = new ProductinformationServiceImpl();
		String url = request.getRequestURI();
		if(url.endsWith("updateProduct")){
			Productinformation productinformation = new Productinformation();
//		http://localhost:8080/goldUser2/prod/updateProduct?productId=1&productType=2&gramWeight=12&brand=13&productPrice=12&bepertory=12&detailpage=12&productName=123&productStatus=10
			String productId  = request.getParameter("productId");
			String productType = request.getParameter("productType");
			String gramWeight = request.getParameter("gramWeight");
			String brand = request.getParameter("brand");
			String productPrice = request.getParameter("productPrice");
			String bepertory = request.getParameter("bepertory");
			String detailpage = request.getParameter("detailpage");
			String productName = request.getParameter("productName");
			String productStatus = request.getParameter("productStatus");
			productinformation.setProductId(Long.valueOf(productId));
			productinformation.setProductType(productType);
			productinformation.setGramWeight(gramWeight);
			productinformation.setBrand(brand);
			productinformation.setProductPrice(new BigDecimal(productPrice));
			productinformation.setBepertory(Integer.valueOf(bepertory));
			productinformation.setDetailpage(detailpage);
			productinformation.setProductName(productName);
			productinformation.setProductStatus(Integer.valueOf(productStatus));
			productinformationService.UpdateAll(productinformation );
			JSONObject jsonObject = new JSONObject();
			response.getWriter().write(jsonObject.toJSONString());
			
		}else if(url.endsWith("addProduct")){
			 Productinformation productinformation = new Productinformation();
			 String productType = request.getParameter("productType");
				String gramWeight = request.getParameter("gramWeight");
				String brand = request.getParameter("brand");
				String productPrice = request.getParameter("productPrice");
				String bepertory = request.getParameter("bepertory");
				String detailpage = request.getParameter("detailpage");
				String productName = request.getParameter("productName");
				String productStatus = request.getParameter("productStatus");
				productinformation.setProductType(productType);
				productinformation.setGramWeight(gramWeight);
				productinformation.setBrand(brand);
				productinformation.setProductPrice(new BigDecimal(productPrice));
				productinformation.setBepertory(Integer.valueOf(bepertory));
				productinformation.setDetailpage(detailpage);
				productinformation.setProductName(productName);
				productinformation.setProductStatus(Integer.valueOf(productStatus));
				productinformationService.addProduct(productinformation );
				JSONObject jsonObject = new JSONObject();
				response.getWriter().write(jsonObject.toJSONString());
				
			
			
		}else if(url.endsWith("findAll")){
			
			String  pageNo = request.getParameter("pageNo");
			String  pageSize = request.getParameter("pageSize");;
			List<Productinformation> list = productinformationService.findAllPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
			Long count = productinformationService.procount();
			JSONObject json = new JSONObject();
			json.put("Rows", list);
			json.put("Total", count);
			response.getWriter().write(json.toJSONString());
			
		}else if(url.endsWith("findAllById")){
			String productId = request.getParameter("productId");
			 Productinformation product = productinformationService.findProById(Long.valueOf(productId));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("product", product);
			response.getWriter().write(jsonObject.toJSONString());
		}
		
		
		 
	}

}
