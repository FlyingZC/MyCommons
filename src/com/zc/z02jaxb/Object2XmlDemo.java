package com.zc.z02jaxb;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;  
  
//Marshaller  
/**
 * <一句话功能简述>
 * <功能详细描述>
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <customer id="100">
        <book id="1" name="哈里波特" price="100"/>
        <book id="2" name="苹果" price="50"/>
        <age>29</age>
        <name>suo</name>
    </customer>

 * 
 * @author  Administrator
 * @version  [版本号, 2016年12月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Object2XmlDemo {  
    public static void main(String[] args) {  
  
        Customer customer = new Customer();  
        customer.setId(100);  
        customer.setName("suo");  
        customer.setAge(29);  
          
        Book book = new Book();  
        book.setId("1");  
        book.setName("哈里波特");  
        book.setPrice(100);  
          
        Book book2 = new Book();  
        book2.setId("2");  
        book2.setName("苹果");  
        book2.setPrice(50);  
          
        Set<Book> bookSet = new HashSet<Book>();  
        bookSet.add(book);  
        bookSet.add(book2);  
          
        customer.setBook(bookSet);  
          
        try {  
            //1.对象序列化到xml
            File file = new File("E:\\Sfile1.xml");
            //JAXBContext 类提供到 JAXB API 的客户端入口点。它提供了管理实现 JAXB 绑定框架操作所需的 XML/Java 绑定信息的抽象，这些操作包括：解组、编组和验证。 
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            //Marshaller 类负责管理将 Java 内容树序列化回 XML 数据的过程。它提供了基本的编组方法
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();  
            // output pretty printed  设置 Marshaller 底层实现中的特定属性
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            jaxbMarshaller.marshal(customer, file);  
            // 将以 jaxbElement 为根的内容树编组到 (控制台中) 中。
            jaxbMarshaller.marshal(customer, System.out);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
    }  
    @Test
    public void test01() throws Exception{
        File file = new File("D:\\file1.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);  
        //2.将xml反序列化成对象
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);  
        System.out.println(customer);  
        
    }
    
}  