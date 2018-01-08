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

public class NoticeByIdServlet extends HttpServlet {

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

		String noticecId = request.getParameter("noticecId");
		
		String  url = consolepcUrl+"notice/noticeId.do?noticecId="+noticecId;
		
		
		CloseableHttpClient chc = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(url);
		
		CloseableHttpResponse hrs = chc.execute(get);
		
		
		System.out.println(hrs.getStatusLine().toString());
		
		 String entity = EntityUtils.toString(hrs.getEntity());
		 
		 JSONObject json = JSONObject.parseObject(entity);
		 
		 
		   
		   
		   request.setAttribute("json", json);
		   request.getRequestDispatcher("/WEB-INF/Jsp/PingtaibyId.jsp").forward(request, response);
		
		 
		
	}
}
