/**
 * 
 */
package com.bwie.weixin.weather;

import java.util.Arrays;

/**
 * @function 
 * @author 王治
 * @date 2017年6月23日
 */
public class Result {
	private Sk sk;
	private Today today;
	private Future[] future;
	/**
	 * @return the sk
	 */
	public Sk getSk() {
		return sk;
	}
	/**
	 * @param sk the sk to set
	 */
	public void setSk(Sk sk) {
		this.sk = sk;
	}
	/**
	 * @return the today
	 */
	public Today getToday() {
		return today;
	}
	/**
	 * @param today the today to set
	 */
	public void setToday(Today today) {
		this.today = today;
	}
	/**
	 * @return the future
	 */
	public Future[] getFuture() {
		return future;
	}
	/**
	 * @param future the future to set
	 */
	public void setFuture(Future[] future) {
		this.future = future;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [sk=" + sk + ", today=" + today + ", future=" + Arrays.toString(future) + "]";
	}

}
