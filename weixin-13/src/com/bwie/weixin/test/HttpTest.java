/**
 * 
 */
package com.bwie.weixin.test;

import com.bwie.weixin.util.WeatherForecastUtil;

/**
 * @function
 * @author 王治
 * @date 2017年6月23日
 */
public class HttpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String weather = WeatherForecastUtil.selectWeather();
		System.out.println(weather);
	}

}
