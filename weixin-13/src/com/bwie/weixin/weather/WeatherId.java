/**
 * 
 */
package com.bwie.weixin.weather;

/**
 * @function
 * @author 王治
 * @date 2017年6月23日
 */
public class WeatherId {
	private String fa;
	private String fb;
	/**
	 * @return the fa
	 */
	public String getFa() {
		return fa;
	}
	/**
	 * @param fa the fa to set
	 */
	public void setFa(String fa) {
		this.fa = fa;
	}
	/**
	 * @return the fb
	 */
	public String getFb() {
		return fb;
	}
	/**
	 * @param fb the fb to set
	 */
	public void setFb(String fb) {
		this.fb = fb;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherId [fa=" + fa + ", fb=" + fb + "]";
	}
}
