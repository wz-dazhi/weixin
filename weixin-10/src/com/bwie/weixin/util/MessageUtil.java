/**
 * 
 */
package com.bwie.weixin.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bwie.weixin.message.Articles;
import com.bwie.weixin.message.ImageMessage;
import com.bwie.weixin.message.MusicMessage;
import com.bwie.weixin.message.NewsMessage;
import com.bwie.weixin.message.TextMessage;
import com.bwie.weixin.message.VideoMessage;
import com.bwie.weixin.message.VoiceMessage;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @function 消息处理工具类
 * @author 王治
 * @date 2017年6月17日
 */
public class MessageUtil {
	// 请求消息类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	// 事件请求类型
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	// 响应消息类型
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	// 事件类型,订阅事件和取消订阅事件
	public static final String TYPE_EVENT_SUBSCRIBE = "subscribe";
	public static final String TYPE_EVENT_UNSUBSCRIBE = "unsubscribe";

	public static WXBizMsgCrypt getWXBizMsgCrypt() {
		WXBizMsgCrypt wxBizMsgCrypt = null;
		try {
			wxBizMsgCrypt = new WXBizMsgCrypt(SignUtil.token, "gx9ACf5lRTDghr0Vx0dXdjKWVd06XUSXu27w5jI1jSp",
					"wx79d794d3611597b1");
		} catch (AesException e) {
			e.printStackTrace();
		}
		return wxBizMsgCrypt;
	}

	// 处理密文消息
	public static Map<String, String> parseJCE(HttpServletRequest request, String timeStamp, String nonce) {
		Map<String, String> map = new HashMap<>();
		InputStream inputStream = null;
		StringBuffer buffer = null;
		String len = null;
		String decryptMsg = null;
		Document document = null;
		try {// 读取微信服务器发来的加密xml
			inputStream = request.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			buffer = new StringBuffer();
			while ((len = reader.readLine()) != null) {
				buffer.append(len);
			}
			// 接收微信服务器的加密签名
			String msg_signature = request.getParameter("msg_signature");
			// 将密文解密成明文
			decryptMsg = getWXBizMsgCrypt().decryptMsg(msg_signature, timeStamp, nonce, buffer.toString());
			// 并解析解密后的xml文本
			document = DocumentHelper.parseText(decryptMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获得xml根节点
		Element root = document.getRootElement();
		// 递归遍历节点
		casecadeXml(root, map);
		return map;
	}

	// 处理明文消息
	public static Map<String, String> parse(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		// 使用IO获取document对象
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			// 读取微信服务器发来的请求,并解析接收请求xml
			document = reader.read(request.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获得xml根节点
		Element root = document.getRootElement();

		// 递归遍历节点
		casecadeXml(root, map);
		return map;
	}

	// 使用递归循环遍历子节点下的子节点
	private static void casecadeXml(Element root, Map<String, String> map) {
		List<Element> elements = root.elements();
		if (elements.size() == 0) {
			map.put(root.getName(), root.getTextTrim());
		} else {
			for (Element e : elements) {
				casecadeXml(e, map);
			}
		}
	}

	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点都增加CDATA标记
				boolean cdata = true;

				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	// 将文本消息转换成XML
	public static String messageToXMl(TextMessage textMessage) {
		xstream.alias("xml", TextMessage.class);
		return xstream.toXML(textMessage);
	}

	// 将图片消息转换成XML
	public static String messageToXMl(ImageMessage imageMessage) {
		xstream.alias("xml", ImageMessage.class);
		return xstream.toXML(imageMessage);
	}

	// 将音乐消息转换成XML
	public static String messageToXMl(MusicMessage musicMessage) {
		xstream.alias("xml", MusicMessage.class);
		return xstream.toXML(musicMessage);
	}

	// 将音频消息转换成XML
	public static String messageToXMl(VoiceMessage voiceMessage) {
		xstream.alias("xml", VoiceMessage.class);
		return xstream.toXML(voiceMessage);
	}

	// 将视频消息转换成XML
	public static String messageToXMl(VideoMessage videoMessage) {
		xstream.alias("xml", VideoMessage.class);
		return xstream.toXML(videoMessage);
	}

	// 将图文消息转换成XML
	public static String messageToXMl(NewsMessage newsMessage) {
		xstream.alias("xml", NewsMessage.class);
		xstream.alias("item", Articles.class);
		return xstream.toXML(newsMessage);
	}

}
