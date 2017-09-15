/**
 * 
 */
package com.bwie.weixin.https;

import com.bwie.weixin.pojo.Token;
import com.bwie.weixin.util.CommonUtil;

/**
 * @function
 * @author 王治
 * @date 2017年6月19日
 */
public class HttpsTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Token token = CommonUtil.getAccessToken("wx2f9cdd6430278db7", "f34b751c34c6557d9b9220eea8f1eec0");
		System.out.println(token.getAccess_token());
		System.out.println(token.getExpires_in());
	}

}
