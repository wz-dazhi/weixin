package com.bwie.weixin.test;

import org.apache.log4j.Logger;

/**
 * @function
 * @author 王治
 * @date 2017年6月19日
 */
public class LoggerTest {
	private static Logger logger = Logger.getLogger(LoggerTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		logger.error("ERROR");
	}

}
