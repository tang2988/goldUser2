package cn.jbit.Servlet;

import java.io.IOException;
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

public class MediaServlet extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		if (uri.endsWith("findAll")) {
			String pageNo = request.getParameter("pageNo");
			String pagesize = request.getParameter("pagesize");
			
			if (pageNo == null) {
				pageNo = "1";
			}

			if (pagesize == null) {
				pagesize = "2";
			}
			
			int pageNoI = Integer.valueOf(pageNo);
			int pagesizeI = Integer.valueOf(pagesize);

			String url = consolepcUrl+"mediaa/findAll";
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response2 = httpClient.execute(get);
			String entity = EntityUtils.toString(response2.getEntity());
			JSONObject jsonObject = JSONObject.parseObject(entity);
			JSONArray array = JSONArray.parseArray(jsonObject.get("list") + "");

			Long count = 15L;
			long pageCount = count % Integer.valueOf(pagesize) == 0 ? count
					/ Integer.valueOf(pagesize) : count
					/ Integer.valueOf(pagesize) + 1;

			request.setAttribute("array", array);
			request.setAttribute("pageCount", pageCount);
			
			long beginPageNo = 1;
			long endPageNo = pageCount;
			request.setAttribute("beginPageNo", beginPageNo);
			request.setAttribute("endPageNo", endPageNo);
			
			request.getRequestDispatcher("/WEB-INF/Jsp/media.jsp").forward(
					request, response);

		} else if (uri.endsWith("findByid")) {

			String mediaId = request.getParameter("mediaId");
			String url = consolepcUrl+"mediaa/findById?mediaId="
					+ mediaId;
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse closeresponse = httpClient.execute(get);
			String entity = EntityUtils.toString(closeresponse.getEntity());
			JSONObject json = JSONObject.parseObject(entity);
			// request.setAttribute("jso", json.get("noticeTimeFmt"));
			request.setAttribute("json", json);
			request.getRequestDispatcher("/WEB-INF/Jsp/medianr.jsp").forward(
					request, response);
		} else if (uri.endsWith("zixun")) {
			String url = consolepcUrl+"mediaa/findAll";
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response2 = httpClient.execute(get);
			String entity = EntityUtils.toString(response2.getEntity());
			JSONObject jsonObject = JSONObject.parseObject(entity);
			JSONArray array = JSONArray.parseArray(jsonObject.get("list") + "");

			request.setAttribute("array", array);

			request.getRequestDispatcher("/index.jsp").forward(request,
					response);

		} 
	}

}
