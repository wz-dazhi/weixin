/**
 * 
 */
package com.bwie.weixin.weather;

/**
 * @function
 * @author 王治
 * @date 2017年6月23日
 */
public class WeatherForecast {
	private String resultcode;
	private String reason;
	private Result result;
	private int error_code;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherForecast [resultcode=" + resultcode + ", reason=" + reason + ", result=" + result
				+ ", error_code=" + error_code + "]";
	}

	/**
	 * @return the resultcode
	 */
	public String getResultcode() {
		return resultcode;
	}

	/**
	 * @param resultcode
	 *            the resultcode to set
	 */
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason
	 *            the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * @return the error_code
	 */
	public int getError_code() {
		return error_code;
	}

	/**
	 * @param error_code
	 *            the error_code to set
	 */
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
}
