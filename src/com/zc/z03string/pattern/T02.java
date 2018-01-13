package com.zc.z03string.pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class T02
{
    @Test
    public void test05sb()
    {
        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put("myDataSource", "http://localhostlocalhostlocalhostlocalhost");
        keyValueMap.put("myFieldData", "http://myFiDataResult");
        keyValueMap.put("myDataDefinition", "http://myDataDefinition");
        String str = "abc${myDataSource}${myDataSource}def${myFieldData}ghi${myDataSource}opq${myDataSource}hij${myDataSource}";
        Matcher m = Pattern.compile("\\${1}\\{\\w+\\}").matcher(str);
        while (m.find())
        {
            //也是不含尾巴,即匹配的group子串  下标在start到end-1之间
            System.out.println(m.group() + "->" + m.start() + "->" + m.end());
            //${myFieldData}->21->35
            String keyInMap = str.substring(m.start() + 2, m.end() - 1);
            //虽然group每次只匹配一个满足的子串,但是replace替换掉了所有相同的子串
            str = str.replace("${" + keyInMap + "}", keyValueMap.get(keyInMap));
            //若 reset(str):使用一个新的字符串 进行匹配,若reset():则还是用当前已经编译的字符串从头再次匹配.这里使用reset(str)重新编译一个字符串进行匹配
            m.reset(str);
            System.out.println(str);
        }
        System.out.println(str);
    }

    @Test
    public void testSplit()
    {
        Map<String, String> map = new HashMap<String, String>();
        String str = "DataSource:src|FieldData:src|DataDefinition:tableName|Column:seqName";
        String[] arr = str.split("\\|");
        System.out.println(Arrays.toString(arr));
        for (String every : arr)
        {
            String[] eachKeyValue = every.split(":");
            map.put(eachKeyValue[0], eachKeyValue[1]);
        }
        System.out.println(map);
    }

    @Test
    public void testExp()
    {
        //String str ="${Schema}.CPM_SYSTEMPARAM.id";
        String str = "${Schema}.CPM_SYSTEMPARAM|${Schema}.CPM_CHANNEL";
        Matcher m = Pattern.compile("\\${1}\\{\\w+\\}").matcher(str);

        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put("Schema", "test");

        while (m.find())
        {
            //也是不含尾巴
            System.out.println(m.group() + "->" + m.start() + "->" + m.end());
            //${myFieldData}->21->35
            String keyInMap = str.substring(m.start() + 2, m.end() - 1);
            str = str.replace("${" + keyInMap + "}", keyValueMap.get(keyInMap));
            //若 reset(str):使用一个新的字符串 进行匹配,若reset():则还是用当前已经编译的字符串从头再次匹配
            m.reset(str);
            System.out.println(str);
        }
        // str.replaceAll("$\\{\\w+\\}", );
        //System.out.println(sb.toString());
        System.out.println(str);
    }

    @Test
    public void test01()
    {
        Integer i = null;
        String.valueOf(i + 1);
    }

}
