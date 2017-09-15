/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 
 * @author 王治
 * @date 2017年6月17日
 */
public class Image {
	//通过素材管理中的接口上传多媒体文件，得到的id。
	private String MediaId;

	/**
	 * @return the mediaId
	 */
	public String getMediaId() {
		return MediaId;
	}

	/**
	 * @param mediaId the mediaId to set
	 */
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
