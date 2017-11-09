package cn.jbit.Servlet;

import java.io.IOException;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class NoticeServlet extends HttpServlet {

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

		String  url = "http://localhost:8080/hsdgold-console-pc/notice/notice.do";
		//http://localhost:8080/hsdgold-console-pc/notice/notice.do
		
		CloseableHttpClient chc = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(url);
		
		CloseableHttpResponse hrs = chc.execute(get);
	
		
		System.out.println(hrs.getStatusLine().toString());
		
		 String json = EntityUtils.toString(hrs.getEntity());
		 
		 JSONObject jsonObject = JSONObject.parseObject(json);
		 
		 List<Map> maplist = JSONArray.parseArray(jsonObject.get("maplist")+"",Map.class);
		 
		 request.setAttribute("maplistt", maplist);
		 request.getRequestDispatcher("/WEB-INF/Jsp/Pingtaigonggao.jsp").forward(request, response);
		 
		
	}
}
