package com.zc.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class T01String
{
    @Test
    public void test01()
    {
        //1A00001
        String batchNum = String.valueOf(1+1);
        String deviceType = "A";
        //批次号五位,不足前面补0
        if (StringUtils.isNotEmpty(batchNum) && batchNum.length() < 5)
        {
            StringBuilder sb = new StringBuilder(batchNum);
            for (int i = 0; i < 5 - batchNum.length(); i++)
            {
                sb.insert(0, "0");
            }
            sb.insert(0, "1" + deviceType);
            batchNum = sb.toString();
        }
        System.out.println(batchNum);
    }
    
    @Test
    public void test02()
    {
        String str ="CPM.CPM_PRODUCTINFO.PRODUCTID";
        System.out.println(str.substring(str.lastIndexOf(".")+1));
    }
    
    @Test
    public void testOrdrBy()
    {
        System.out.println(addTableAlias4OrderBy("tableName.ID asc,tableName.Name desc,tableName.age"));
        System.out.println(addTableAlias4OrderBy("tableName.ID"));
        //System.out.println(addTableAlias4OrderBy("ID"));
    }
    
    /**
     * 为order by 添加 表别名
     * @param allOrderBy
     * @return
     */
    private String addTableAlias4OrderBy(String allOrderBy)
    {
        Map<String,String> tableAliasCacheMap =new HashMap<String,String>();
        tableAliasCacheMap.put("tableName", "tableAlias");
        
        if(StringUtils.isBlank(allOrderBy))
        {
            return null;
        }
        String[] orderByArray = allOrderBy.split(",");
        StringBuilder sb = new StringBuilder();
        for(String eachOrderBy : orderByArray)
        {
            String[] eachOrderByArray = eachOrderBy.split("\\.");
            String tableName = eachOrderByArray[0];
            String tableAlias = tableAliasCacheMap.get(tableName);
            sb.append(tableAlias).append(".").append(eachOrderByArray[1]).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
