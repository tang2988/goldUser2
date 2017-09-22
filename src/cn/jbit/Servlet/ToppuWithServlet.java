package cn.jbit.Servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.jbit.Service.TopuprechargeService;
import cn.jbit.Service.WithdrawalformService;
import cn.jbit.ServiceImpl.TopuprechargeServiceImpl;
import cn.jbit.ServiceImpl.WithdrawalformServiceImpl;
import cn.jbit.entity.Topuprecharge;
import cn.jbit.entity.Withdrawalform;



public class ToppuWithServlet extends HttpServlet {

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
		TopuprechargeService ts = new TopuprechargeServiceImpl();
		WithdrawalformService ws = new WithdrawalformServiceImpl();
		String uri = request.getRequestURI();
		if(uri.endsWith("topup")){
				String pageno = request.getParameter("pageno");
				String pagesize = request.getParameter("pagesize");
				   List<Map<String, Object>> list = ts.findAllaccountAndtopuprecharge(Integer.valueOf(pageno), Integer.valueOf(pagesize));
				  Long count = ts.findCount();
				  JSONObject json = new JSONObject();
				  json.put("Rows", list);
				  json.put("Total", count);
				  System.out.println(json);
				  response.getWriter().write(json.toJSONString());
		}else if(uri.endsWith("withform")){
			String pageno = request.getParameter("pageno");
			String pagesize = request.getParameter("pagesize");
			   List<Map<String, Object>> list = ws.findAll(Integer.valueOf(pageno), Integer.valueOf(pagesize));
			  Long count = ws.findCount();
			  JSONObject json = new JSONObject();
			  json.put("Rows", list);
			  json.put("Total", count);
			  System.out.println(json);
			  response.getWriter().write(json.toJSONString());
		}else if(uri.endsWith("updateStatusSuccesstime")){
			String withdrawalId = request.getParameter("withdrawalId");
			String  rechargeStatus = request.getParameter("rechargeStatus");
			 Integer up = ws.updatestatusbysuccesstime(Long.valueOf(withdrawalId), Integer.valueOf(rechargeStatus), new Date());
			 JSONObject json = new JSONObject();
			 response.getWriter().write(json.toJSONString());
			
		}else if(uri.endsWith("findById")){
			String withdrawalId = request.getParameter("withdrawalId");
			 Withdrawalform list = ws.findById(Long.valueOf(withdrawalId));
			JSONObject jsonId = new JSONObject();
			jsonId.put("list", list);
			response.getWriter().write(jsonId.toJSONString());
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
