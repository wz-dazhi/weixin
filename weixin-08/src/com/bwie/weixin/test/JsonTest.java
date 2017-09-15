package com.bwie.weixin.test;

import com.bwie.weixin.pojo.BaseButton;
import com.bwie.weixin.pojo.Click;
import com.bwie.weixin.pojo.Composite;
import com.bwie.weixin.pojo.Menu;
import com.bwie.weixin.pojo.Sub_Button;
import com.bwie.weixin.pojo.Token;
import com.bwie.weixin.pojo.View;
import com.bwie.weixin.util.CommonUtil;
import com.bwie.weixin.util.MenuUtil;

import net.sf.json.JSONObject;

/**
 * @function
 * @author 王治
 * @date 2017年6月20日
 */
public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		Sub_Button[] sb = new Sub_Button[] {};
		Click c1 = new Click();
		c1.setType("click");
		c1.setName("天气预报");
		c1.setKey("V1001_TODAY_WEATHER");
		c1.setSub_button(sb);

//		Click c2 = new Click();
//		c2.setType("click");
//		c2.setName("歌手简介");
//		c2.setKey("V1001_TODAY_SINGER");
//		c2.setSub_button(sb);
		
		View v2 = new View();
		v2.setType("view");
		v2.setName("2048");
		v2.setUrl("http://17u4f31513.51mypc.cn/weixin-15/2048-master/index.html");
		v2.setSub_button(sb);

		View v31 = new View();
		v31.setType("view");
		v31.setName("搜索");
		v31.setUrl("http://www.soso.com/");
		v31.setSub_button(sb);

		View v32 = new View();
		v32.setType("view");
		v32.setName("视频");
		v32.setUrl("http://v.qq.com/");
		v32.setSub_button(sb);

		Click c33 = new Click();
		c33.setType("click");
		c33.setName("赞一下我们");
		c33.setKey("V1001_GOOD");
		c33.setSub_button(sb);

		Composite composite3 = new Composite();
		composite3.setName("菜单");
		composite3.setSub_button(new BaseButton[] { v31, v32, c33 });

		menu.setButton(new BaseButton[] { c1, v2, composite3 });

		JSONObject jsonObject = JSONObject.fromObject(menu);
		System.out.println(jsonObject);

		// 获取access_token
		Token token = CommonUtil.getAccessToken("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		boolean b = MenuUtil.createMenu(jsonObject.toString(), token.getAccess_token());
		System.out.println(b);
	}

}
