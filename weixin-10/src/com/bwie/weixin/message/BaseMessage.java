/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 所有消息的基类,抽取了公共的部分
 * @author 王治
 * @date 2017年6月17日
 */
public class BaseMessage {
	//开发者微信号
	private String ToUserName;
	//发送方帐号（一个OpenID）
	private String FromUserName;
	//消息创建时间 （整型）
	private long CreateTime;
	//消息类型
	private String MsgType;
	
	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return ToUserName;
	}
	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return FromUserName;
	}
	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	/**
	 * @return the createTime
	 */
	public long getCreateTime() {
		return CreateTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return MsgType;
	}
	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
