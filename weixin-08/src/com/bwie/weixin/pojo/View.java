/**
 * 
 */
package com.bwie.weixin.pojo;

/**
 * @function 
 * @author 王治
 * @date 2017年6月20日
 */
public class View extends BaseButton {
	private String type;
	private String url;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
