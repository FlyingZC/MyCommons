package com.zc.test;

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
        Map<String,List<String>> allowPlaceholderMap = new HashMap<String,List<String>>();
        buildPlaceholderMap(allowPlaceholderMap, str);
        if (allowPlaceholderMap != null && allowPlaceholderMap.containsKey(replaceObjClazz.getSimpleName()))
        {
            // 寻找要替换的属性
            String replaceKey =null;// allowPlaceholderMap.get(replaceObjClazz.getSimpleName());
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
    
    Map<String,List<String>> buildPlaceholderMap(Map<String,List<String>> allowPlaceholderMap, String placeholderString)
    {
        if (StringUtils.isNotEmpty(placeholderString))
        {
            //String[] placeholderArray = placeholderString.split("\\|");
            String[] placeholderClassArray = placeholderString.split(",");
            for (String everyClass : placeholderClassArray)
            {
                //DataDefinition:tableName|realTableName|dbSource
                String[] eachKeyValue = everyClass.split(":");
                if(eachKeyValue.length == 2)
                {
                    String className = eachKeyValue[0];
                    String[] fieldNames = eachKeyValue[1].split("\\|");
                    if(allowPlaceholderMap.containsKey(className))
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
}
