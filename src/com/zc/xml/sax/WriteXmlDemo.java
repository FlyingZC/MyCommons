package com.zc.xml.sax;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXmlDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 大致步骤
		 * 1.创建Document对象先表示一个空白文档
		 * 2.向Document中添加根元素
		 * 3.向根元素中根据xml文档预定的格式添加若干级子元素
		 * 4.创建XMLWriter
		 * 5.通过XMLWriter将Document写出
		 * */
		
		//1.
		Document doc=DocumentHelper.createDocument();
		//2.一个文档只能调用一次,创建一个根元素
		Element root=doc.addElement("list");
		/*
		 * Element也提供了一个与Document方法一样返回值的方法
		 * Element addElement(String name)
		 * 该方法作用是向当前标签中添加一个给定名字的子标签,并以一个Element实例表示然后将其返回
		 * */
		List<Emp> empObjList=new ReadEmp().read();
		/*
		 * Element也提供了向当前元素中添加属性的方法:
		 * Element addAttribute(String name,String value)
		 * 该方法会向当前元素中添加给定名字以及值的一个属性,返回值还是当前元素,
		 * 这样做的目的是可以方便连续对当前元素操作
		 * */
		for(Emp empObj:empObjList){
			Element emp=root.addElement("emp").addAttribute("id",String.valueOf(empObj.getId()));
			emp.addElement("id").addText(String.valueOf(empObj.getId()));
			emp.addElement("name").addText(empObj.getName());
			emp.addElement("age").addText(String.valueOf(empObj.getAge()));
			emp.addElement("gender").addText(empObj.getGender());
			emp.addElement("salary").addText(String.valueOf(empObj.getSalary()));
		}
		//OutputFormat.createPrettyPrint()方法返回一个漂亮的输出
		XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
		FileOutputStream fos = new FileOutputStream("outemp.xml");
		writer.setOutputStream(fos);
		writer.write(doc);
	}
}
