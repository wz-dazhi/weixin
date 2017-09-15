/**
 * 
 */
package com.bwie.weixin.message;

/**
 * @function 回复语音消息
 * @author 王治
 * @date 2017年6月17日
 */
public class VoiceMessage extends BaseMessage {
	//语音对象
	private Voice Voice;

	/**
	 * @return the voice
	 */
	public Voice getVoice() {
		return Voice;
	}

	/**
	 * @param voice the voice to set
	 */
	public void setVoice(Voice voice) {
		Voice = voice;
	}
}
