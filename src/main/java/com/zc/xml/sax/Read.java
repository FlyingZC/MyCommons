package com.zc.xml.sax;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Read {
	public static void main(String[] args) {
		readXML();
	}
	
	public static void readXML(){
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		try {
			//读取指定文件
			Document doc = reader.read(new File("emplist.xml"));
			//获取根元素
			Element root = doc.getRootElement();
			//获取当前元素下的指定名字的子元素
			Element e = root.element("emp");
			System.out.println(e);
			//获取当前元素下所有子元素
			List<Element> es = root.elements();
			for(Element ee:es){
				System.out.println(ee);
			}
			//获取当前元素的元素名
			String eleName = e.getName();
			System.out.println(eleName);
			//获取当前元素的文本节点(起始标记与结束标记之间的文本)
			String txt=e.getText();
			System.out.println(txt);
			//获取当前元素的指定属性
			Attribute attr2=e.attribute("atr1");
			System.out.println(attr2);
			Attribute attr = e.attribute(0);
			System.out.println(attr);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("读取文件失败");
		}
	}
	
	
	
}
