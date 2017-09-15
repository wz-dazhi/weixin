package com.bwie.dom4j.tesst;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @function
 * @author 王治
 * @date 2017年6月17日
 */
public class Dom4jTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 使用IO获取document对象
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
//			document = reader.read("src/test.xml"); // 读取xml文件
			document = reader.read("src/test2.xml");   
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获得xml根节点
		Element root = document.getRootElement();
//		 parseXml(root);   //一级子节点

		//递归遍历节点
		casecadeXml(root);
		
	}

	//使用递归循环遍历子节点下的子节点
	private static void casecadeXml(Element root) {
		List<Element> elements = root.elements();
		if (elements.size() == 0) {
			System.out.println(root.getName() + "-->" + root.getTextTrim()); 
		}else {
			for (Element e : elements) {
				casecadeXml(e);
			}
		}
	}

	// 没有二级以上的子节点获取方法
	private static void parseXml(Element root) {
		// 获得跟节点下的所有子节点
		List<Element> elements = root.elements();
		// 遍历所有子节点
		for (Element e : elements) {
			System.out.println(e.getName() + "--->" + e.getTextTrim());
		}
	}

}












