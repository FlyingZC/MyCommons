package com.zc.zcascade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.alibaba.fastjson.JSON;

public class TestCase
{
    //由原始数据得到的organ(原始数据   根就一个Organ,当然也可以为多个)
    private static final Organ originalOrgan;

    //由原始数据得到的organList.这个数据应该是这个例子最初的数据,里面包含多个organ,且每个都不包含子节点
    private List<Organ> originalOrganList = new ArrayList<Organ>();

    //父id  和   多个子节点    的映射
    private Map<String, List<Organ>> supId2Organ = new HashMap<String, List<Organ>>();

    static
    {
        //源jsonStr数据
        String organListStr = "{\n\t\"id\": \"0100\",\n\t\"childOrgList\": [\n\t\t{\n\t\t\t\"id\": \"0103\",\n\t\t\t\"childOrgList\": [\n\t\t\t\t{\n\t\t\t\t\t\"id\": \"0110\",\n\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\"address\": \"\u5357\u4EAC\u5206\u884C\u6C5F\u5B81\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0103\",\n\t\t\t\t\t\"name\": \"\u676D\u5DDE\u94F6\u884C\u5357\u4EAC\u5206\u884C\u6C5F\u5B81\u652F\u884C\",\n\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}, {\n\t\t\t\t\t\"id\": \"0112\",\n\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\"address\": \"\u5357\u4EAC\u5206\u884C\u9F13\u697C\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0103\",\n\t\t\t\t\t\"name\": \"\u676D\u5DDE\u94F6\u884C\u5357\u4EAC\u5206\u884C\u9F13\u697C\u652F\u884C\",\n\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}\n\t\t\t],\n\t\t\t\"level\": \"2\",\n\t\t\t\"address\": \"\u5174\u5B89\u76DF\",\n\t\t\t\"porgname\": \"\",\n\t\t\t\"porgid\": \"0100\",\n\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5174\u5B89\u76DF\u5206\u884C\",\n\t\t\t\"y\": \"2\",\n\t\t\t\"xy\": \"2,2\",\n\t\t\t\"x\": \"2\",\n\t\t\t\"orgLevel\": \"\"\n\t\t}, {\n\t\t\t\"id\": \"0105\",\n\t\t\t\"childOrgList\": [\n\t\t\t\t{\n\t\t\t\t\t\"id\": \"0101\",\n\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\"address\": \"\u6DF1\u5733\u5206\u884C\u9F99\u5C97\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0105\",\n\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u6DF1\u5733\u5206\u884C\u9F99\u5C97\u652F\u884C\",\n\t\t\t\t\t\"y\": \"4\",\n\t\t\t\t\t\"xy\": \"3,4\",\n\t\t\t\t\t\"x\": \"3\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}, {\n\t\t\t\t\t\"id\": \"0102\",\n\t\t\t\t\t\"childOrgList\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"id\": \"0202\",\n\t\t\t\t\t\t\t\"childOrgList\": [\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\"id\": \"0201\",\n\t\t\t\t\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\t\t\t\t\"level\": \"5\",\n\t\t\t\t\t\t\t\t\t\"address\": \"\u4E2D\u56FD\u65E5\u672C\",\n\t\t\t\t\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\t\t\t\t\"porgid\": \"0202\",\n\t\t\t\t\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u65E5\u672C\u5206\u884C\",\n\t\t\t\t\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t],\n\t\t\t\t\t\t\t\"level\": \"4\",\n\t\t\t\t\t\t\t\"address\": \"\u4E2D\u56FD\u6D66\u53E3\",\n\t\t\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\t\t\"porgid\": \"0102\",\n\t\t\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5357\u4EAC\u6D66\u53E3\u652F\u884C\",\n\t\t\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t\t\t}\n\t\t\t\t\t],\n\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\"address\": \"\u6DF1\u5733\u5206\u884C\u9F99\u534E\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0105\",\n\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u6DF1\u5733\u5206\u884C\u9F99\u534E\u652F\u884C\",\n\t\t\t\t\t\"y\": \"3\",\n\t\t\t\t\t\"xy\": \"3,3\",\n\t\t\t\t\t\"x\": \"3\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}, {\n\t\t\t\t\t\"id\": \"6666\",\n\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\"address\": \"\u7F8E\u56FD\u767D\u5BAB\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0105\",\n\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u7F8E\u56FD\u5206\u884C\",\n\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}\n\t\t\t],\n\t\t\t\"level\": \"1\",\n\t\t\t\"address\": \"\u5317\u4EAC\u4E2D\u5173\u6751\",\n\t\t\t\"porgname\": \"\",\n\t\t\t\"porgid\": \"0100\",\n\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5206\u884C\",\n\t\t\t\"y\": \"\",\n\t\t\t\"xy\": \"null,null\",\n\t\t\t\"x\": \"\",\n\t\t\t\"orgLevel\": \"\"\n\t\t}, {\n\t\t\t\"id\": \"0106\",\n\t\t\t\"childOrgList\": [\n\t\t\t\t{\n\t\t\t\t\t\"id\": \"0107\",\n\t\t\t\t\t\"childOrgList\": [\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"id\": \"0109\",\n\t\t\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\t\t\"address\": \"\u5357\u4EAC\u5206\u884C\u6816\u971E\",\n\t\t\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\t\t\"porgid\": \"0107\",\n\t\t\t\t\t\t\t\"name\": \"\u676D\u5DDE\u94F6\u884C\u5357\u4EAC\u5206\u884C\u6816\u971E\u652F\u884C\",\n\t\t\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"id\": \"0111\",\n\t\t\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\t\t\"address\": \"\u5357\u4EAC\u5206\u884C\u7384\u6B66\",\n\t\t\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\t\t\"porgid\": \"0107\",\n\t\t\t\t\t\t\t\"name\": \"\u676D\u5DDE\u94F6\u884C\u5357\u4EAC\u5206\u884C\u7384\u6B66\u652F\u884C\",\n\t\t\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"id\": \"0108\",\n\t\t\t\t\t\t\t\"childOrgList\": [],\n\t\t\t\t\t\t\t\"level\": \"3\",\n\t\t\t\t\t\t\t\"address\": \"\u5317\u4E09\u73AF102\",\n\t\t\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\t\t\"porgid\": \"0107\",\n\t\t\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5317\u4E09\u73AF\u652F\u884C\",\n\t\t\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t\t\t}\n\t\t\t\t\t],\n\t\t\t\t\t\"level\": \"2\",\n\t\t\t\t\t\"address\": \"\u5357\u4EAC\u65B0\u8857\u53E3\",\n\t\t\t\t\t\"porgname\": \"\",\n\t\t\t\t\t\"porgid\": \"0106\",\n\t\t\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5357\u4EAC\u65B0\u8857\u53E3\u7BA1\u8F96\u652F\u884C\",\n\t\t\t\t\t\"y\": \"\",\n\t\t\t\t\t\"xy\": \"null,null\",\n\t\t\t\t\t\"x\": \"\",\n\t\t\t\t\t\"orgLevel\": \"\"\n\t\t\t\t}\n\t\t\t],\n\t\t\t\"level\": \"1\",\n\t\t\t\"address\": \"\u5357\u4EAC\u5C0F\u9F99\u6E7E\",\n\t\t\t\"porgname\": \"\",\n\t\t\t\"porgid\": \"0100\",\n\t\t\t\"name\": \"\u5317\u4EAC\u94F6\u884C\u5357\u4EAC\u5206\u884C\",\n\t\t\t\"y\": \"\",\n\t\t\t\"xy\": \"null,null\",\n\t\t\t\"x\": \"\",\n\t\t\t\"orgLevel\": \"\"\n\t\t}\n\t],\n\t\"level\": \"\",\n\t\"address\": \"\",\n\t\"porgname\": \"\",\n\t\"porgid\": \"xxxx\",\n\t\"name\": \"\",\n\t\"y\": \"\",\n\t\"xy\": \"\",\n\t\"x\": \"\",\n\t\"orgLevel\": \"0\"\n}";
        originalOrgan = JSON.parseObject(organListStr, Organ.class);
    }

    /** <一句话功能简述>这个
     * <功能详细描述>将originalOrgan对象 递归成 List<Organ>形式.
     * @param organ
     * @return
     * @see [类、类#方法、类#成员]
     */
    public void convertOrganStr2List(Organ organWithSub)
    {
        Organ currOrgan = initCurrOrgan(organWithSub);
        originalOrganList.add(currOrgan);

        pushCurr2Map(currOrgan);
        //对每个子节点递归操作    
        List<Organ> currChildOrgList = organWithSub.getChildOrgList();
        if (currChildOrgList != null && currChildOrgList.size() > 0)
        {
            for (int i = 0; i < currChildOrgList.size(); i++)
            {
                convertOrganStr2List(currChildOrgList.get(i));
            }
        }
    }

    private Organ initCurrOrgan(Organ organWithSub)
    {
        return new Organ().
                setId(organWithSub.getId())
                .setAddress(organWithSub.getAddress())
                .setLevel(organWithSub.getLevel())
                .setName(organWithSub.getName())
                .setOrgLevel(organWithSub.getOrgLevel())
                .setPorgid(organWithSub.getPorgid())
                .setX(organWithSub.getX())
                .setXy(organWithSub.getXy())
                .setY(organWithSub.getY());
    }
    
    private void pushCurr2Map(Organ currOrgan)
    {
        //第一次放入
        if (supId2Organ.get(currOrgan.getPorgid()) == null)
        {
            List<Organ> subOrganList = new ArrayList<Organ>();
            subOrganList.add(currOrgan);
            supId2Organ.put(currOrgan.getPorgid(), subOrganList);
            return;
        }
        //之后放入的
        supId2Organ.get(currOrgan.getPorgid()).add(currOrgan);
    }

    public void convert()
    {
        for (int i = 0; i < originalOrganList.size(); i++)
        {
            findSubList(originalOrganList.get(i));
        }
    }
    
    /** <一句话功能简述>对每一个Organ,设置其subList
     * <功能详细描述>
     * @param currOrgan
     * @see [类、类#方法、类#成员]
     */
    private void findSubList(Organ currOrgan)
    {
        //当前Organ若有sub
        List<Organ> subList = supId2Organ.get(currOrgan.getId());
        if (subList != null)
        {
            currOrgan.setChildOrgList(subList);
        }
    }
    
    /** <一句话功能简述>测试由原始jsonstr到OrganList
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testCurrChildOrgList()
    {
        convertOrganStr2List(originalOrgan);
        System.out.println(originalOrganList);
    }
    
    /** <一句话功能简述>测试由organList生成最终结果
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testConvert()
    {
        convertOrganStr2List(originalOrgan);
        
        convert();
        System.out.println(originalOrganList);
        //如果父节点为xxxx,为根
        List<Organ> root = supId2Organ.get("xxxx");
        String jsonStr = JSON.toJSONString(root, true);
        System.out.println(jsonStr);
    }
}

class Organ /*implements Cloneable*/
{
    private String id;
    private List<Organ> childOrgList;
    private String level;
    private String address;
    private String porgid;//父id
    private String name;
    private String y;
    private String xy;
    private String x;
    private String orgLevel;
    public String getId()
    {
        return id;
    }
    public Organ setId(String id)
    {
        this.id = id;
        return this;
    }
    public List<Organ> getChildOrgList()
    {
        return childOrgList;
    }
    public Organ setChildOrgList(List<Organ> childOrgList)
    {
        this.childOrgList = childOrgList;
        return this;
    }
    public String getLevel()
    {
        return level;
    }
    public Organ setLevel(String level)
    {
        this.level = level;
        return this;
    }
    public String getAddress()
    {
        return address;
    }
    public Organ setAddress(String address)
    {
        this.address = address;
        return this;
    }
    public String getPorgid()
    {
        return porgid;
    }
    public Organ setPorgid(String porgid)
    {
        this.porgid = porgid;
        return this;
    }
    public String getName()
    {
        return name;
    }
    public Organ setName(String name)
    {
        this.name = name;
        return this;
    }
    public String getY()
    {
        return y;
    }
    public Organ setY(String y)
    {
        this.y = y;
        return this;
    }
    public String getXy()
    {
        return xy;
    }
    public Organ setXy(String xy)
    {
        this.xy = xy;
        return this;
    }
    public String getX()
    {
        return x;
    }
    public Organ setX(String x)
    {
        this.x = x;
        return this;
    }
    public String getOrgLevel()
    {
        return orgLevel;
    }
    public Organ setOrgLevel(String orgLevel)
    {
        this.orgLevel = orgLevel;
        return this;
    }
    @Override
    public String toString()
    {
        return "Organ [id=" + id + ", childOrgList=" + childOrgList + ", level=" + level + ", address=" + address
                + ", porgid=" + porgid + ", name=" + name + ", y=" + y + ", xy=" + xy + ", x=" + x + ", orgLevel="
                + orgLevel + "]";
    }
    
  /*  @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }*/
    
}
