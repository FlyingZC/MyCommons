package com.zc.basic.z03string.pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class T01RegexPattern
{
    /**
     * 使用 正则表达式 解析的${xxx}占位符
     */
    @Test
    public void test01PlaceholderRegex()
    {
        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put("myDataSource", "http://localhostlocalhostlocalhostlocalhost");
        keyValueMap.put("myFieldData", "http://myFiDataResult");
        keyValueMap.put("myDataDefinition", "http://myDataDefinition");
        String str = "abc${myDataSource}${myDataSource}def${myFieldData}ghi${myDataSource}opq${myDataSource}hij${myDataSource}";
        Matcher m = Pattern.compile("\\${1}\\{\\w+\\}").matcher(str);
        while (m.find())
        {
            // 也是含头不含尾,即匹配的group子串  下标在start到end-1之间
            System.out.println(m.group() + "->" + m.start() + "->" + m.end());
            // ${myFieldData}->21->35
            String keyInMap = str.substring(m.start() + 2, m.end() - 1);
            // 虽然group每次只匹配一个满足的子串,但是replace替换掉了所有相同的子串
            str = str.replace("${" + keyInMap + "}", keyValueMap.get(keyInMap));
            // 若 reset(str):使用一个新的字符串 进行匹配,若reset():则还是用当前已经编译的字符串从头再次匹配.这里使用reset(str)重新编译一个字符串进行匹配
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
}
