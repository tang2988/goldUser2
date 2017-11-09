package cn.jbit.Servlet;

import java.io.IOException;

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

public class MediaServlet extends HttpServlet {

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

			String url = "http://localhost:8080/hsdgold-console-pc/mediaa/findAll";
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
			String url = "http://localhost:8080/hsdgold-console-pc/mediaa/findById?mediaId="
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
			String url = "http://localhost:8080/hsdgold-console-pc/mediaa/findAll";
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
