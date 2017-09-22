package cn.jbit.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class IndexServlet extends HttpServlet {

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
		
		
		List<Map> mapList;
		
		try {
			String announcement_url ="http://localhost:8080/hsdgold-console-pc/Announcement/findAllApi.do";
			CloseableHttpClient hc = HttpClientBuilder.create().build();
			HttpGet req = new HttpGet(announcement_url);
			CloseableHttpResponse res = hc.execute(req);
			String announcement_jsonStr = EntityUtils.toString(res.getEntity());
			
			JSONObject announcement_json = JSONObject.parseObject(announcement_jsonStr);
			  mapList = JSONArray.parseArray(announcement_json.get("list")+"", Map.class);
			  
		} catch (Exception e) {
			mapList = new ArrayList<Map>();
		}
		ProductinformationService ps = new ProductinformationServiceImpl();
		  List<Productinformation> listt = ps.findAllPage(1, 3);
		  
		 
		  
		  String url = "http://localhost:8080/hsdgold-console-pc/mediaa/findAll";
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response2 = httpClient.execute(get);
			String entity = EntityUtils.toString(response2.getEntity());
			JSONObject jsonObject = JSONObject.parseObject(entity);
			JSONArray array = JSONArray.parseArray(jsonObject.get("list") + "");


			request.setAttribute("media", array);
		  
		  
		request.setAttribute("listt",listt);
		request.setAttribute("announcementlist",mapList );
		 request.getRequestDispatcher("/index.jsp").forward(request, response);
		 
		 
	}

}
