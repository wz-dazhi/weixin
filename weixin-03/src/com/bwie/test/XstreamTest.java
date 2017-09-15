/**
 * 
 */
package com.bwie.test;

import java.io.Writer;

import com.bwie.model.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @function 
 * @author 王治
 * @date 2017年6月17日
 */
public class XstreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例对象
		Student s = new Student();
		s.setName("王治");
		s.setInfo("王治aaaaaaaaaa");
		//创建XStream对象
		//XStream xStream = new XStream();
		
		//设置别名
		xstream.alias("student", Student.class);
		String xml = xstream.toXML(s);  //将对象转换成xml格式
		System.out.println(xml);  //打印xml格式数据
	}
	
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点都增加CDATA标记
				boolean cdata = true;

				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});


}
