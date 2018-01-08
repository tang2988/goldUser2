package cn.jbit.Servlet;

import java.io.IOException;
import java.util.ArrayList;
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

import cn.jbit.Service.ProductinformationService;
import cn.jbit.ServiceImpl.ProductinformationServiceImpl;
import cn.jbit.entity.Productinformation;
import cn.xxh.ResourcesUtil;
import cn.xxh.gold.common.utils.ResBo;
import cn.xxh.gold.sys.api.http.ProductprofitandHttpApi;
import cn.xxh.gold.vo.ProductProfitandLossVo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class IndexServlet extends HttpServlet {
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

		List<Map> mapList;

		try {
			String announcement_url = consolepcUrl
					+ "Announcement/findAllApi.do";
			CloseableHttpClient hc = HttpClientBuilder.create().build();
			HttpGet req = new HttpGet(announcement_url);
			CloseableHttpResponse res = hc.execute(req);
			String announcement_jsonStr = EntityUtils.toString(res.getEntity());

			JSONObject announcement_json = JSONObject
					.parseObject(announcement_jsonStr);
			mapList = JSONArray.parseArray(announcement_json.get("list") + "",
					Map.class);

		} catch (Exception e) {
			mapList = new ArrayList<Map>();
		}
		ProductinformationService ps = new ProductinformationServiceImpl();
		List<Productinformation> listt = ps.findAllPage(1, 3);

		List<Map> map;
		try {
			String url = consolepcUrl+"mediaa/findAll";
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response2 = httpClient.execute(get);
			String entity = EntityUtils.toString(response2.getEntity());
			JSONObject jsonObject = JSONObject.parseObject(entity);
			map = JSONArray.parseArray(jsonObject.get("list") + "", Map.class);

		} catch (Exception e) {
			map = new ArrayList<Map>();
		}

		ProductprofitandHttpApi http = new ProductprofitandHttpApi();
		ResBo listproduct = http.findByStatus();
		System.out.println(listproduct);
		request.setAttribute("media", map);
		request.setAttribute("listproduct", listproduct.getData());

		request.setAttribute("listt", listt);
		request.setAttribute("announcementlist", mapList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
