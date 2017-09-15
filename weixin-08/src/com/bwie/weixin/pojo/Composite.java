/**
 * 
 */
package com.bwie.weixin.pojo;

/**
 * @function 
 * @author 王治
 * @date 2017年6月20日
 */
public class Composite extends BaseButton {
	private BaseButton[] sub_button;

	/**
	 * @return the sub_button
	 */
	public BaseButton[] getSub_button() {
		return sub_button;
	}

	/**
	 * @param sub_button the sub_button to set
	 */
	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}
}
