/**
 * 
 */
package com.bwie.weixin.weather;

/**
 * @function 
 * @author 王治
 * @date 2017年6月23日
 */
public class Future {
	private String temperature;
	private String weather;
	private WeatherId weather_id;
	private String wind;
	private String week;
	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}
	/**
	 * @return the weather_id
	 */
	public WeatherId getWeather_id() {
		return weather_id;
	}
	/**
	 * @param weather_id the weather_id to set
	 */
	public void setWeather_id(WeatherId weather_id) {
		this.weather_id = weather_id;
	}
	/**
	 * @return the wind
	 */
	public String getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Future [temperature=" + temperature + ", weather=" + weather + ", weather_id=" + weather_id + ", wind="
				+ wind + ", week=" + week + "]";
	}

}
