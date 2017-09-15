/**
 * 
 */
package com.bwie.weixin.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bwie.weixin.message.TextMessage;
import com.bwie.weixin.util.MessageUtil;
import com.bwie.weixin.util.WeatherForecastUtil;

/**
 * @function
 * @author 王治
 * @date 2017年6月18日
 */
public class CoreService {
	
	//获取用户 纬度，如：39.933748
	private static String LAT = "";
	//获取用户 经度，如：116.39277
	private static String LON = "";

	public static String processRequest(HttpServletRequest request) {
		Map<String, String> map = MessageUtil.parse(request);
		// 来自用户的消息,发送方帐号（一个OpenID）
		String fromUserName = map.get("FromUserName");
		// 公众号的ID
		String toUserName = map.get("ToUserName");
		// 消息类型
		String msgType = map.get("MsgType");

		TextMessage textMessage = new TextMessage();
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setCreateTime(new Date().getTime());
		

		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			textMessage.setContent("您发送的是一个文本消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			textMessage.setContent("您发送的是一个图片消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			textMessage.setContent("您发送的是一个链接消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			textMessage.setContent("您发送的是一个地理位置消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
			textMessage.setContent("您发送的是一个视频消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			textMessage.setContent("您发送的是一个音频消息");
		} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			String event = map.get("Event");
			if (event.equals(MessageUtil.TYPE_EVENT_SUBSCRIBE)) {
				textMessage.setContent("欢迎关注");
			} else if (event.equals(MessageUtil.TYPE_EVENT_UNSUBSCRIBE)) {

			} else if (event.equals(MessageUtil.TYPE_EVENT_LOCATION)) {
				LAT = map.get("Latitude");
				LON = map.get("Longitude");
				System.out.println("lat111 -->" + LAT + "lon111--->" + LON);
			} else if (event.equals(MessageUtil.TYPE_EVENT_CLICK)) {
				String key = map.get("EventKey");
				if (key.equals("V1001_TODAY_WEATHER")) {
					System.out.println("lat -->" + LAT + "lon--->" + LON);
					if (!"".equals(LAT) && !"".equals(LON)) {
						textMessage.setContent(WeatherForecastUtil.selectWeather(LON, LAT));
					} else {
						textMessage.setContent("您没有提供地理位置信息,目前查询不了天气");
					}
				} else if (key.equals("V1001_TODAY_SINGER")) {
					textMessage.setContent("二狗,湖北人,2017年中国好嗓门冠军");
				} else if (key.equals("V1001_GOOD")) {
					textMessage.setContent("谢谢您的赞");
				}
			}
		}
		return MessageUtil.messageToXMl(textMessage);
	}
}
