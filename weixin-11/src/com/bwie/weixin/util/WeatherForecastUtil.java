package com.bwie.weixin.util;

import com.bwie.weixin.weather.Future;
import com.bwie.weixin.weather.WeatherForecast;
import com.google.gson.Gson;

/**
 * @function
 * @author 王治
 * @date 2017年6月23日
 */
public class WeatherForecastUtil {

	// 天气预报接口URL GET请求
	private static final String URL = "http://v.juhe.cn/weather/geo?format=2&key=d6b9e2ec408436bfeb9f5a2103950cbe&lon={lon}&lat={lat}";

	// 查询天气
	public static String selectWeather(String lon,String lat) {
		// 发起请求
		String json = HttpUtil.httpRequest(URL.replace("{lon}", lon).replace("{lat}", lat), "GET", null);
		System.out.println(json);
		Gson gson = new Gson();
		
//		FormatJsonUtil.printJson(json);
		
		// 将json转成Java对象
		WeatherForecast fromJson = gson.fromJson(json, WeatherForecast.class);
		StringBuffer buffer = new StringBuffer();
		// 拼接天气预报
		buffer.append(fromJson.getResult().getToday().getCity() + "天气预报\n\n");
		buffer.append("温度:" + fromJson.getResult().getSk().getTemp() + "℃,")
				.append("风向:" + fromJson.getResult().getSk().getWind_direction() + ",")
				.append("风力:" + fromJson.getResult().getSk().getWind_strength() + ",")
				.append("湿度:" + fromJson.getResult().getSk().getHumidity() + ",")
				.append("更新时间:" + fromJson.getResult().getSk().getTime() + "\n");

		buffer.append(
				fromJson.getResult().getToday().getDate_y() + " " + fromJson.getResult().getFuture()[0].getWeek() + " ")
				.append("(实时:" + fromJson.getResult().getSk().getTemp() + "℃)"
						+ fromJson.getResult().getFuture()[0].getTemperature() + ","
						+ fromJson.getResult().getFuture()[0].getWeather() + ","
						+ fromJson.getResult().getFuture()[0].getWind() + "\n\n");

		int index = 0;
		// 循环未来几天天气预报
		for (Future f : fromJson.getResult().getFuture()) {
			if (index == 0) {
				index++;
				continue;
			} else {
				index++;
				if (index > 4) {
					break;
				}
				buffer.append(
						f.getWeek() + " 温度:" + f.getTemperature() + "," + f.getWeather() + "," + f.getWind() + "\n\n");
			}
		}
		return buffer.toString();
	}
}
