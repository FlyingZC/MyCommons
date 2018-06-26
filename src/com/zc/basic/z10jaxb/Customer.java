package com.zc.basic.z10jaxb;

import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
  
/**
 * <一句话功能简述>
 * <功能详细描述>
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <customer id="100">
        <book>
            <id>2</id>
            <name>苹果</name>
            <price>50</price>
        </book>
        <book>
            <id>1</id>
            <name>哈里波特</name>
            <price>100</price>
        </book>
        <age>29</age>
        <name>suo</name>
    </customer>
 * @author  Flyin
 * @version  [版本号, 2017年3月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@XmlRootElement //将Java类或枚举类型映射到XML元素 
public class Customer {  
    String name;  
    int age;  
    int id;  
    @XmlElement(name="book")
    Set<Book> bookSet;
    
    @XmlElement  //将Java类的一个元素子节点映射到与属性同名的一个XML元素.只能作用于基本数据类型<name>suo</name>
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
      
    @XmlElement  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
    @XmlAttribute  //将Java类的一个属性映射到与属性同名的一个XML属性,<customer id="100">
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
      
    @Override  
    public String toString() {  
        return "Customer [id=" + id + ",name=" + name + ",age=" + age + "]";  
    }
    public void setBook(Set<Book> bookSet)
    {
        this.bookSet=bookSet;
    }  
    
    public Set<Book> getBookSet(){
        return bookSet;
    }
}  