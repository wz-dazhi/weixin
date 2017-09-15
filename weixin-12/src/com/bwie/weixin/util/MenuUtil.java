package com.bwie.weixin.util;

import net.sf.json.JSONObject;

/**
 * @function 菜单处理
 * @author 王治
 * @date 2017年6月20日
 */
public class MenuUtil {

	// 创建 POST请求
	private static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 查询 GET请求
	private static final String MENU_SELECT_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	// 删除GET请求
	private static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	// 删除菜单
	public static String deleteMenu(String access_token) {
		String requestUrl = MENU_DELETE_URL.replace("ACCESS_TOKEN", access_token);
		return CommonUtil.httpsRequest(requestUrl, "GET", null);
	}

	// 查询菜单
	public static String selectMenu(String access_token) {
		String requestUrl = MENU_SELECT_URL.replace("ACCESS_TOKEN", access_token);
		return CommonUtil.httpsRequest(requestUrl, "GET", null);
	}

	// 创建菜单
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
