package com.bwie.weixin.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bwie.weixin.message.Articles;
import com.bwie.weixin.message.NewsMessage;
import com.bwie.weixin.weather.Future;
import com.bwie.weixin.weather.WeatherForecast;
import com.google.gson.Gson;

/**
 * @function
 * @author 王治
 * @date 2017年6月23日
 */
public class WeatherForecastUtil {

	// 项目跟路径
	private static final String PROJECT_ROOT = "http://17u4f31513.51mypc.cn/weixin-15/images/";

	// 天气预报接口URL GET请求
	private static final String URL = "http://v.juhe.cn/weather/geo?format=2&key=d6b9e2ec408436bfeb9f5a2103950cbe&lon={lon}&lat={lat}";

	// UC天气预报网址
	private static final String UC_URL = "http://m.weather.com.cn/mtown/index?lat={lat}&lon={lon}";

	// 查询天气
	public static NewsMessage selectWeather(String lon, String lat) {
		// 发起请求
		String json = HttpUtil.httpRequest(URL.replace("{lon}", lon).replace("{lat}", lat), "GET", null);
		String ucurl = UC_URL.replace("{lon}", lon).replace("{lat}", lat);
		System.out.println(json);
		Gson gson = new Gson();

		// FormatJsonUtil.printJson(json);

		// 将json转成Java对象
		WeatherForecast fromJson = gson.fromJson(json, WeatherForecast.class);
		StringBuffer buffer = new StringBuffer();
		// 拼接天气预报
		buffer.append("\n\n" + fromJson.getResult().getToday().getCity() + "天气预报\n");

		buffer.append(
				fromJson.getResult().getToday().getDate_y() + " " + fromJson.getResult().getFuture()[0].getWeek() + " ")
				.append("(实时:" + fromJson.getResult().getSk().getTemp() + "℃)"
						+ fromJson.getResult().getFuture()[0].getTemperature() + ","
						+ fromJson.getResult().getFuture()[0].getWeather() + ","
						+ fromJson.getResult().getFuture()[0].getWind() + "\n\n");

		Articles article1 = new Articles();
		article1.setTitle(buffer.toString());
		article1.setPicUrl(PROJECT_ROOT + "top.jpg");
		article1.setDescription("");
		article1.setUrl(ucurl);

		List<Articles> articles = new ArrayList<>();
		articles.add(article1);

		int index = 0;
		// 循环未来几天天气预报
		for (Future f : fromJson.getResult().getFuture()) {
			Articles article2 = new Articles();
			StringBuffer buffer2 = new StringBuffer();
			if (index == 0) {
				index++;
				continue;
			} else {
				index++;
				if (index > 4) {
					break;
				}
				buffer2.append(
						f.getWeek() + " 温度:" + f.getTemperature() + "," + f.getWeather() + "," + f.getWind() + "\n\n");
				article2.setTitle(buffer2.toString());
				article2.setPicUrl(PROJECT_ROOT + "weather_zhenyu.png");
				article2.setDescription("");
				article2.setUrl(ucurl);
				articles.add(article2);
			}
		}

		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setArticleCount(articles.size());
		newsMessage.setArticles(articles);
		newsMessage.setCreateTime(new Date().getTime());

		return newsMessage;
	}
}
