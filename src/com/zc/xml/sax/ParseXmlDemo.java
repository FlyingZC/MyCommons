package com.zc.xml.sax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析xml的大致步骤:
 * 1.创建SAXReader对象
 * 2.使用SAXReader解析xml文档并生成一个Document对象
 * 这一步就是DOM既耗时耗资源的地方
 * 因为这一步将xml文档全部解析完毕了,存入一个Document对象
 * 3.通过Document对象获取根元素
 * 4.通过根元素按照xml文档结构逐一获取子元素,最终达到遍历xml目的
 * @author zc
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		//1.获取SAXReader对象
		SAXReader reader=new SAXReader();
		try {
			//2.生成Document对象
			Document doc=reader.read(new File("emplist.xml"));
			//3.获取根元素
			//Element类,每一个实例代表xml文档中一个元素,即一对标签
			Element root=doc.getRootElement();
			/*
			 * Element对象提供了获取其表示的元素的相关内容
			 * String getName()
			 * 获取当前元素的名字(即:标签名)
			 * 
			 * List elements()
			 * 获取当前元素下的所有子元素,该集合中的每一个元素都是一个Element实例
			 * 
			 * List elements(String name)
			 * 获取当前元素下所有的同名子元素
			 * 
			 * Element element(String name)
			 * 获取当前元素下制定名字的子元素
			 * 
			 * */
			//用来保存所有员工信息的集合
			List<Emp> empObjList = new ArrayList<Emp>();
			Emp empObj=null;
			/*
			 * 获取根元素下的所有子元素
			 * 其中每一个子元素就是一个<emp>标签
			 * */
			List<Element> eles=root.elements();
			for(Element e:eles){
				empObj=new Emp();
				empObj.setId(Integer.parseInt(e.element("id").getText()));
				empObj.setName(e.element("name").getText());
				empObj.setAge(Integer.parseInt(e.element("age").getText()));
				empObj.setSalary(Integer.parseInt(e.elementText("salary")));
				empObjList.add(empObj);
			}
			
			/*
			 * Element提供了用于获取对应标签的属性
			 * Attribute attribute(String name)
			 * 获取指定名称的属性
			 * 
			 * Attribute attribute(int index)
			 * 获取指定下标的属性
			 * 
			 * Attribute的每一个实例都可以表示某个标签中的一个属性
			 * 
			 * */
			

			System.out.println(empObjList);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
