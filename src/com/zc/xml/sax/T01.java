package com.zc.xml.sax;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class T01 {
    public static void main(String[] args) {
        //1.获取SAXReader对象
        SAXReader reader = new SAXReader();
        try {
            //2.生成Document对象
            Document doc = reader.read(new File("D:\\myworkspace\\03mygithub\\MyMind\\mind\\ddg\\page\\page.xml"));
            //3.获取根元素
            //Element类,每一个实例代表xml文档中一个元素,即一对标签
            Element root = doc.getRootElement();
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
            System.out.println("");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
