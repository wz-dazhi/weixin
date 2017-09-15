/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 回复音乐消息
 * @author 王治
 * @date 2017年6月17日
 */
public class MusicMessage extends BaseMessage {
	//音乐对象
	private Music Music;

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return Music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		Music = music;
	}
}
