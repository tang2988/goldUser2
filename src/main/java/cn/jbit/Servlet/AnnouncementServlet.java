package cn.jbit.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cn.xxh.ResourcesUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class AnnouncementServlet extends HttpServlet {

	String consolepcUrl = "";

	public void init() throws ServletException {

		Properties propertie = ResourcesUtil
				.getPropertiesFromFile("config-console-pc.properties");
		consolepcUrl = propertie.getProperty("consolepcUrl");
		if (consolepcUrl == null) {

			throw new RuntimeException(
					"config-console-pc.properties找不到consolepcUrl配置项");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
			if(uri.endsWith("findAll.html")){
				
			
		
		String  url = consolepcUrl+"Announcement/findAllApi.do";
		//http://localhost:8080/hsdgold-console-pc/notice/notice.do
		
		CloseableHttpClient chc = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(url);
		
		CloseableHttpResponse hrs = chc.execute(get);
		
		 String json = EntityUtils.toString(hrs.getEntity());
		 
		 JSONObject jsonObject = JSONObject.parseObject(json);
		 
		 List<Map> list = JSONArray.parseArray(jsonObject.get("list")+"", Map.class);
		 
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("/WEB-INF/Jsp/HezuoHuoban.jsp").forward(request, response);
			}else{
				response.sendRedirect("/WEB-INF/Jsp/Pingtaigonggao.jsp");
			}
		
	}
}
