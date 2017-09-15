/**
 * 
 */
package com.bwie.weixin.weather;

/**
 * @function 
 * @author 王治
 * @date 2017年6月23日
 */
public class Sk {
	private String temp;
	private String wind_direction;
	private String wind_strength;
	private String humidity;
	private String time;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sk [temp=" + temp + ", wind_direction=" + wind_direction + ", wind_strength=" + wind_strength
				+ ", humidity=" + humidity + ", time=" + time + "]";
	}

	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * @param temp
	 *            the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

	/**
	 * @return the wind_direction
	 */
	public String getWind_direction() {
		return wind_direction;
	}

	/**
	 * @param wind_direction
	 *            the wind_direction to set
	 */
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}

	/**
	 * @return the wind_strength
	 */
	public String getWind_strength() {
		return wind_strength;
	}

	/**
	 * @param wind_strength
	 *            the wind_strength to set
	 */
	public void setWind_strength(String wind_strength) {
		this.wind_strength = wind_strength;
	}

	/**
	 * @return the humidity
	 */
	public String getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity
	 *            the humidity to set
	 */
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
}
