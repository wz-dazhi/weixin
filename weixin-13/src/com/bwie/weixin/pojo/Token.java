/**
 * 
 */
package com.bwie.weixin.pojo;

/**
 * @function 
 * @author 王治
 * @date 2017年6月19日
 */
public class Token {
	//接口访问凭证
	private String access_token;
	//有效时长(秒)
	private Integer expires_in;

	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public Integer getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
}
