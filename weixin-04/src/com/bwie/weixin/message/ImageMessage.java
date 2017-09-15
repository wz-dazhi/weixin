/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 回复图片消息
 * @author 王治
 * @date 2017年6月17日
 */
public class ImageMessage extends BaseMessage {
	private Image Image;

	/**
	 * @return the image
	 */
	public Image getImage() {
		return Image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		Image = image;
	}
}
