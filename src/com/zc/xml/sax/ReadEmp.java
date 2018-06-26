package com.zc.xml.sax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadEmp {
	public static void main(String[] args) {
		new ReadEmp().read();
	}
	
	public List<Emp> read(){
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("emplist.xml"));
			Element root = doc.getRootElement();
			List<Element> emps=root.elements();
			Emp empObj=null;
			List<Emp> empObjList=new ArrayList<Emp>();
			for(Element emp:emps){
				//一定要在这里new,如果在外面new,每次放入list中的是同一个对象
				empObj=new Emp();
				empObj.setId(Integer.parseInt(emp.element("id").getText()));
				empObj.setName(emp.element("name").getText());
				empObj.setAge(Integer.parseInt(emp.element("age").getText()));
				empObj.setGender(emp.elementText("gender"));
				empObj.setSalary(Integer.parseInt(emp.elementText("salary")));
				empObjList.add(empObj);
			}
			for(Emp emp:empObjList){
				System.out.println(emp);
			}
			return empObjList;
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("解析错误");
		}
	}
}
