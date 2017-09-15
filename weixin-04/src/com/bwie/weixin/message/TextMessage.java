/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 回复文本消息
 * @author 王治
 * @date 2017年6月17日
 */
public class TextMessage extends BaseMessage {
	//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	private String Content;

	/**
	 * @return the content
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		Content = content;
	}
}
