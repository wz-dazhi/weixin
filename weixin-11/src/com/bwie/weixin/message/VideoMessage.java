/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 回复视频消息
 * @author 王治
 * @date 2017年6月17日
 */
public class VideoMessage extends BaseMessage {
	//视频对象
	private Video Video;

	/**
	 * @return the video
	 */
	public Video getVideo() {
		return Video;
	}

	/**
	 * @param video the video to set
	 */
	public void setVideo(Video video) {
		Video = video;
	}
}
