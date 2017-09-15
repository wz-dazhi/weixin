/**
 * 
 */
package com.bwie.weixin.util;

import net.sf.json.JSONObject;

/**
 * @function
 * @author 王治
 * @date 2017年6月20日
 */
public class MenuUtil {

	private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	public static boolean createMenu(String json, String access_token) {
		boolean result = false;
		String requestUrl = MENU_CREATE_URL.replace("ACCESS_TOKEN", access_token);
		String httpsRequest = CommonUtil.httpsRequest(requestUrl, "POST", json);
		System.out.println("---->" + httpsRequest);
		JSONObject jsonObject = JSONObject.fromObject(httpsRequest);
		if (jsonObject != null) {
			int errcode = jsonObject.getInt("errcode");
			String errmsg = jsonObject.getString("errmsg");
			System.out.println("errcode:" + errcode + "errmsg:" + errmsg);
			if (errcode == 0) {
				result = true;
			}
		}

		return result;
	}
}
