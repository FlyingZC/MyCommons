package com.zc.xml.xpath;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class T01XPath
{
    public static void main(String[] args) throws Exception
    {
        // 加载document.xml
        DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
        // 开启验证
        bf.setValidating(true);
        bf.setNamespaceAware(false);
        bf.setIgnoringComments(true);
        bf.setIgnoringElementContentWhitespace(false);
        bf.setCoalescing(false);
        bf.setExpandEntityReferences(true);
        
        // 创建documentBuilder
        DocumentBuilder documentBuilder = bf.newDocumentBuilder();
        // 设置异常处理对象
        documentBuilder.setErrorHandler(new ErrorHandler()
        {
            
            public void warning(SAXParseException exception) throws SAXException
            {
                System.out.println("warning:" +exception.getMessage());
            }
            
            public void fatalError(SAXParseException exception) throws SAXException
            {
                System.out.println("fatalError:" +exception.getMessage());                
            }
            
            public void error(SAXParseException exception) throws SAXException
            {
                System.out.println("error:" +exception.getMessage());                
            }
        });
        
        // 文档加载到一个Document对象中
       Document doc = documentBuilder.parse("emplist.xml");
       
       // 创建XPathFactory
       XPathFactory factory = XPathFactory.newInstance();
       // 创建XPath对象
       XPath xpath = factory.newXPath();
       // 编译xPath表达式(先编译表达式再执行,多次执行效率会高)
       XPathExpression expr = xpath.compile("list/emp");
       // expr.evaluate(上下文, xpath表达式的返回类型)
       // xpath表达式的返回类型 有 nodeset,boolean,number,string 和Node五种
       Object result = expr.evaluate(doc, XPathConstants.NODESET);
       
       NodeList nodes = (NodeList) result;
       
       for (int i = 0; i < nodes.getLength(); i++) 
       {
           System.out.println(nodes.item(i).getNodeValue());
       }
       
       
    }
}
