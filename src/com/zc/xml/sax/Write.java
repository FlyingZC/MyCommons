package com.zc.xml.sax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class Write {
	public static void main(String[] args) {
		//构建Document对象
		Document doc = DocumentHelper.createDocument();
		//添加根元素
		Element root = doc.addElement("project");
		//向根元素中添加子元素
		Element ele=root.addElement("path");
		//为元素添加属性
		ele.addAttribute("id","zcc");
		//为元素添加内容
		ele.addText("这是一个子节点");
		
		//写出
		XMLWriter writer=new XMLWriter();
		try {
			FileOutputStream fos=new FileOutputStream("out.xml");
			writer.setOutputStream(fos);
			writer.write(doc);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
