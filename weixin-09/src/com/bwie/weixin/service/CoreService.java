/**
 * 
 */
package com.bwie.weixin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bwie.weixin.message.Articles;
import com.bwie.weixin.message.Music;
import com.bwie.weixin.message.MusicMessage;
import com.bwie.weixin.message.NewsMessage;
import com.bwie.weixin.message.TextMessage;
import com.bwie.weixin.util.EmojiUtil;
import com.bwie.weixin.util.MessageUtil;

/**
 * @function
 * @author 王治
 * @date 2017年6月18日
 */
public class CoreService {

	private static Logger logger = Logger.getLogger(CoreService.class);

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

		logger.info(String.format("用户的Open_id: %s ,消息类型:%s", fromUserName, msgType));
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			StringBuffer buffer = null;
			if (map.get("Content").equals("1")) {
				buffer = new StringBuffer();
				// 2048个字节
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵!.");
				textMessage.setContent(buffer.toString());
			} else if (map.get("Content").equals("2")) {
				buffer = new StringBuffer();
				// 2049个字节
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
				buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵!..");
				textMessage.setContent(buffer.toString());
			} else if (map.get("Content").equals("3")) {
				textMessage.setContent("点击进入<a href=\"https://mp.weixin.qq.com/wiki\">微信公众平台</a>");
			} else if (map.get("Content").equals("4")) {
				textMessage.setContent("亲,我想你了,你怎么才来呢?");
			} else if (map.get("Content").equals("5")) {
				textMessage.setContent("么么哒");
			} else if (map.get("Content").equals("6")) {
				textMessage.setContent("祝你生日快乐");
			} else if (map.get("Content").equals("/::D")) {
				textMessage.setContent("什么事情这么高兴呀?[疑问]/疑问/:?");
			} else if (map.get("Content").equals("/::<")) {
				textMessage.setContent("什么事情这么伤心呀?说出来让我开心一下[疑问]/疑问/:?");
			} else if (map.get("Content").equals("自行车")) {
				textMessage.setContent("这辆 " + EmojiUtil.emoji(0x1f6B2) + "怎么样");
			} else if (map.get("Content").equals("歌曲")) {
				// 创建音乐对象
				Music music = new Music();
				music.setTitle("七月上");
				music.setDescription("Jam阿敬");
				music.setMusicUrl("http://yd1503c.applinzi.com/music/Jam阿敬-七月上.mp3");
				music.setHQMusicUrl("http://yd1503c.applinzi.com/music/Jam阿敬-七月上.mp3");

				// 创建音乐消息
				MusicMessage musicMessage = new MusicMessage();
				musicMessage.setToUserName(fromUserName);
				musicMessage.setFromUserName(toUserName);
				musicMessage.setCreateTime(new Date().getTime());
				musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
				musicMessage.setMusic(music);
				return MessageUtil.messageToXMl(musicMessage);
			} else if (map.get("Content").equals("7")) {
				ArrayList<Articles> list = new ArrayList<>();
				Articles articles = new Articles();
				articles.setTitle("1503c1");
				articles.setDescription("111111111111111111111111111111111111111111");
				articles.setPicUrl("");
				articles.setUrl("https://mp.weixin.qq.com/");
				list.add(articles);
				
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setArticleCount(list.size());
				newsMessage.setArticles(list);
				
				return MessageUtil.messageToXMl(newsMessage);
			} else if (map.get("Content").equals("8")) {
				ArrayList<Articles> list = new ArrayList<>();
				Articles articles = new Articles();
				articles.setTitle("1503c1");
				articles.setDescription("111111111111111111111111111111111111111111");
				articles.setPicUrl("http://17u4f31513.51mypc.cn/weixin-09/image/4dff562e38b09b51c3aa9124ce233702.jpg");
				articles.setUrl("https://mp.weixin.qq.com/");
				Articles articles2 = new Articles();
				articles2.setTitle("1503c2");
				articles2.setDescription("222222222222222222222222222222222222222222");
				articles2.setPicUrl("http://17u4f31513.51mypc.cn/weixin-09/image/a.jpg");
				articles2.setUrl("https://www.baidu.com/");
				list.add(articles);
				list.add(articles2);
				
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
				newsMessage.setArticleCount(list.size());
				newsMessage.setArticles(list);
				
				return MessageUtil.messageToXMl(newsMessage);
			}

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

			}
		}
		return MessageUtil.messageToXMl(textMessage);
	}
}
