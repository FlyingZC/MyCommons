package com.zc.z02jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)//只要是属性都能转换为xml中的标签
//@XmlAccessorType(XmlAccessType.PROPERTY)//只有提供set,set方法的才能转换为xml重的标签
@XmlType
public class Book
{
    private String id;
    private String name;
    private int price;
    //@XmlAttribute
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    //@XmlAttribute
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    //@XmlAttribute
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    
}
