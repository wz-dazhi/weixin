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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @function 处理http工具类
 * @author 王治
 * @date 2017年6月23日
 */
public class HttpUtil {
	
	/**
	 * http POST/GET
	 * @param requestUrl 请求地址
	 * @param requestMethod  请求方式
	 * @param outputStr  参数
	 * @return
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = null;
		try {
			// 传入要连接的URL地址
			URL url = new URL(requestUrl);
			// 打开连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod); // 设置请求方式

			// 设置允许读写
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			OutputStream oStream = conn.getOutputStream();

			if (outputStr != null) {
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
