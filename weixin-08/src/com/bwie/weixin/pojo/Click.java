package com.bwie.weixin.pojo;

/**
 * @function 
 * @author 王治
 * @date 2017年6月20日
 */
public class Click extends BaseButton {
	private String type;
	private String key;
	private Sub_Button[] sub_button;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the sub_button
	 */
	public Sub_Button[] getSub_button() {
		return sub_button;
	}
	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(Sub_Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
