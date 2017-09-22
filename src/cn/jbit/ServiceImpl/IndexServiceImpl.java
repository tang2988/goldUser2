package cn.jbit.ServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class IndexServiceImpl {

	public List<Map> doGet() {

		String announcement_url = "http://localhost:8080/hsdgold-console-pc/Announcement/findAllApi.do";
		CloseableHttpClient hc = HttpClientBuilder.create().build();
		HttpGet req = new HttpGet(announcement_url);
		CloseableHttpResponse res;
		List<Map> mapList = new ArrayList<Map>();
		try {
			res = hc.execute(req);
			String announcement_jsonStr = EntityUtils.toString(res.getEntity());

			JSONObject announcement_json = JSONObject
					.parseObject(announcement_jsonStr);
			mapList = JSONArray.parseArray(announcement_json.get("list") + "",
					Map.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapList;
	}

}
