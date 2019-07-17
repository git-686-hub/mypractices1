package com.pagecge.practices.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author 李志忠
 * 
 */
public final class HttpUtil {

  /**
   * 向指定URL发送GET方法的请求
   * @throws Exception 
   */
  public static String sendGet(String url)
      throws Exception {
    CloseableHttpResponse response = null;
    HttpGet httpGet = null;
    String result = null;
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {

      // 新建Http get请求
      httpGet = new HttpGet(url);
      RequestConfig requestConfig = RequestConfig.custom()
    		  .setConnectTimeout(30 * 1000)
    		  .setSocketTimeout(30 * 1000)
    		  .build();
      httpGet.setConfig(requestConfig);
//      httpGet.addHeader("Content-type", "application/json; charset=utf-8");
//      httpGet.setHeader("Accept", "application/json");
      // 处理请求，得到响应
      response = httpclient.execute(httpGet);
      // 检验返回码
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != 200) {
        httpGet.abort();
        throw new RuntimeException("HttpClient,error status code :" + statusCode);
      }
      // 返回结果
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        result = EntityUtils.toString(entity, "utf-8");
      }
      EntityUtils.consume(entity);
    } catch (Exception e) {
      throw e;
    } finally {
      if (response != null) {
        response.close();
      }
      httpclient.close();
    }

    return result;
  }
  
  public static void main(String[] args) {
	  String url = "https://hq.appsflyer.com/export/id1369704496/installs_report/v5?api_token=98864ca1-60e2-4c75-acaf-3d2966a7bb02&from=2019-07-03+16%3A00&to=2019-07-03+17%3A00&timezone=Asia/Hong_Kong&additional_fields=install_app_store,contributor1_match_type,contributor2_match_type,contributor3_match_type,match_type,device_category,gp_referrer,gp_click_time,gp_install_begin,amazon_aid,keyword_match_type";
	try {
		System.out.println(sendGet(url));
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
}
