package com.zc.basic.z03string.pattern;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class T03Reg
{
    @Test
    public void test01()
    {
        Class<? extends Object> replaceObjClazz = this.getClass();
        String str = "DataSource:src,FieldData:src,DataDefinition:tableName|realTableName|dbSource,Column:seqName,FieldData:condition,DeleteForm:tableNames";
        Map<String, List<String>> allowPlaceholderMap = new HashMap<String, List<String>>();
        buildPlaceholderMap(allowPlaceholderMap, str);
        if (allowPlaceholderMap != null && allowPlaceholderMap.containsKey(replaceObjClazz.getSimpleName()))
        {
            // 寻找要替换的属性
            String replaceKey = null;// allowPlaceholderMap.get(replaceObjClazz.getSimpleName());
            Field[] fields = replaceObjClazz.getDeclaredFields();
            for (Field eachField : fields)
            {
                if (eachField.getName().equalsIgnoreCase(replaceKey))
                {
                    //replacePropertiesWithReg(eachField);
                }
            }
        }
    }

    Map<String, List<String>> buildPlaceholderMap(Map<String, List<String>> allowPlaceholderMap,
            String placeholderString)
    {
        if (StringUtils.isNotEmpty(placeholderString))
        {
            //String[] placeholderArray = placeholderString.split("\\|");
            String[] placeholderClassArray = placeholderString.split(",");
            for (String everyClass : placeholderClassArray)
            {
                //DataDefinition:tableName|realTableName|dbSource
                String[] eachKeyValue = everyClass.split(":");
                if (eachKeyValue.length == 2)
                {
                    String className = eachKeyValue[0];
                    String[] fieldNames = eachKeyValue[1].split("\\|");
                    if (allowPlaceholderMap.containsKey(className))
                    {
                        allowPlaceholderMap.get(className).addAll(new ArrayList<String>(Arrays.asList(fieldNames)));
                    }
                    else
                    {
                        allowPlaceholderMap.put(className, new ArrayList<String>(Arrays.asList(fieldNames)));
                    }
                }
                //placeholderMap.put(eachKeyValue[0], eachKeyValue[1]);
            }
            //return placeholderMap;
        }
        return null;
    }

    // ===============以下为tomcat,boostrap中的实现.替换掉字符串中所有${}里的内容为真实内容
    @Test
    public void test()
    {
        Map<String, String> repMap = new HashMap<String, String>();
        repMap.put("catalina.base", "catalinaBaseDir");
        repMap.put("catalina.home", "catalinaHomeDir");
        System.out.println(new T03Reg().replace(
                "${catalina.base}/lib,${catalina.base}/lib/*.jar,${catalina.home}/lib,${catalina.home}/lib/*.jar",
                repMap));
    }

    /**将${catalina.home}等替换成具体的路径
     * System property replacement in the given string.
     * 
     * @param str The original string
     * @return the modified string
     */
    protected String replace(String str, Map<String, String> repMap)
    {
        // Implementation is copied from ClassLoaderLogManager.replace(),
        // but added special processing for catalina.home and catalina.base.
        String result = str;
        int pos_start = str.indexOf("${");
        if (pos_start >= 0)
        {
            StringBuilder builder = new StringBuilder();
            int pos_end = -1;
            while (pos_start >= 0)
            {
                builder.append(str, pos_end + 1, pos_start);
                pos_end = str.indexOf('}', pos_start + 2);
                if (pos_end < 0)
                {
                    pos_end = pos_start - 1;
                    break;
                }
                String propName = str.substring(pos_start + 2, pos_end);
                String replacement;
                if (propName.length() == 0)
                {
                    replacement = null;
                }
                else
                {
                    replacement = repMap.get(propName);
                }
                if (replacement != null)
                {
                    builder.append(replacement);
                }
                else
                {
                    builder.append(str, pos_start, pos_end + 1);
                }
                pos_start = str.indexOf("${", pos_end + 1);
            }
            builder.append(str, pos_end + 1, str.length());
            result = builder.toString();
        }
        return result;
    }
}
