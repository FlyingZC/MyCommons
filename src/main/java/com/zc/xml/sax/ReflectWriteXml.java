package com.zc.xml.sax;

import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 通过反射自动写出xml文档
 * @author zc
 *
 */
public class ReflectWriteXml<T> {
	public static void main(String[] args) {
		//writeEvery(Emp.class);
	}
	
	public void writeEvery(T t,List<T> objList){
		//List<T> objList=(List<T>) new ReadEmp().read();
		Class<T> clazz=(Class<T>) t.getClass();
		Field[] fields=clazz.getDeclaredFields();
		//1.创建空白文档
		Document doc=DocumentHelper.createDocument();
		//2.
		Element root=doc.addElement("list");
		for(T emp:objList){
			Element clazzName=root.addElement(clazz.getName());//类名
			for(Field field:fields){
				clazzName.addElement(field.getName());
			}
		}
	}
	
}
