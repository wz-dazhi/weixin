/**
 * 
 */
package com.bwie.weixin.test;

import java.io.UnsupportedEncodingException;

/**
 * @function
 * @author 王治
 * @date 2017年6月20日
 */
public class Byte2048Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		int length1 = "王治".getBytes().length;
		int length2 = "王治".getBytes("gb2312").length;
		int length3 = "王治".getBytes("gbk").length;
		int length4 = "王治".getBytes("UTF-8").length;
		System.out.println(length1);
		System.out.println(length2);
		System.out.println(length3);
		System.out.println(length4);
		
		StringBuffer buffer = new StringBuffer();
		// 每行70个汉字，共682个汉字加1个英文的感叹号
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵你的手走过风风雨雨有什么困难我都陪你");
		buffer.append("不知道什么时候开始喜欢这里每个夜里都会来这里看你你长得多么美丽叫我不能不看你看不到你我就迷失了自己好想牵!.");
		System.out.println(buffer.toString().getBytes("UTF-8").length);
	}

}
