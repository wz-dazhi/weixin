/**
 * 
 */
package com.bwie.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.bwie.weixin.pojo.Token;

import net.sf.json.JSONObject;

/**
 * @function
 * @author 王治
 * @date 2017年6月19日
 */
public class CommonUtil {
	
	//获取access_token url (GET)
	private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static Token getAccessToken(String appid,String secret){
		Token token = new Token();
		String requestUrl = TOKEN_URL.replace("APPID", appid).replace("APPSECRET", secret);
		String jsonString = httpsRequest(requestUrl, "GET", null);

		System.out.println(jsonString);
		
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		token.setAccess_token(jsonObject.getString("access_token"));
		token.setExpires_in(jsonObject.getInt("expires_in"));
		return token;
	}
	
	/**
	 * 处理HTTPS请求 GET/POST
	 * @param requestUrl  请求地址
	 * @param requestMethod  请求方式
	 * @param outputStr  参数
	 * @return
	 */
	public static String httpsRequest(String requestUrl,String requestMethod,String outputStr) {
		StringBuffer buffer = null;
		try {
			// 创建SSLContext
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = { new MyX509TrustManager() };
			// 初始化
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 获取SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setSSLSocketFactory(ssf);
			conn.connect();

			if (outputStr != null) {
				OutputStream oStream = conn.getOutputStream();
				oStream.write(outputStr.getBytes("utf-8"));
				oStream.flush();
				oStream.close();
			}
			// 读取服务器端返回的内容
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			buffer = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
