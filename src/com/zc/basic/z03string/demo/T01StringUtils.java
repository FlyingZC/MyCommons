package com.zc.basic.z03string.demo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * <一句话功能简述>测试commons.lang.StringUtils
 * <功能详细描述>
 * 
 * @author  Flyin
 * @version  [版本号, 2017年3月4日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T01StringUtils
{
    /** <isEmpty>:""和null均返回true
     * 字符串为null,或字符串长度为0
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testIsEmpty()
    {
        String str1 = "";
        String str2 = null;
        //String str3;使用之前必须初始化
        System.out.println(StringUtils.isEmpty(str1));//true
        System.out.println(StringUtils.isEmpty(str2));//true
        //System.out.println(StringUtils.isEmpty(str3));
        System.out.println(StringUtils.isNotEmpty(str1));//false
        System.out.println(!StringUtils.isEmpty(str1));//false
    }

    /**
     *isBlank判断是否为空白,null和""和" "和"\t\n"等均返回true 
     */
    @Test
    public void testIsBlank()
    {
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("        "));
        System.out.println(StringUtils.isBlank("\t \n \f \r"));
        //一个退格键不算空白,false
        System.out.println(StringUtils.isBlank("\b"));
    }

    /**
     * 去除前导后置空白
     * trimToNull:会返回真的null,不是字符串null
     * trimToEmpty
     * */
    @Test
    public void trimToNullOrTrimToEmpty()
    {
        System.out.println(StringUtils.trimToNull("  "));//null
        System.out.println(StringUtils.trimToNull(" 1  2 "));//1  2
        System.out.println(StringUtils.trimToEmpty("   "));//空白
        System.out.println(StringUtils.trimToEmpty(" 1 2 "));
    }
}
