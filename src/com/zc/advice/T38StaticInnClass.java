package com.zc.advice;


/**
 * <静态内部类>
 * <功能详细描述>
 * 
 * @author  zc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T38StaticInnClass
{
    public static void main(String[] args)
    {
        Person p=new Person();
        p.setHome(new Person.Home("上海", "022"));
    }
}
class Person
{
    private String name;
    private Home home;
    
    //静态内部类
    public static class Home{
        private String address;
        private String tel;
        public Home(String address,String tel)
        {
            this.address=address;
            this.tel=tel;
        }
        public String getAddress()
        {
            return address;
        }
        public void setAddress(String address)
        {
            this.address = address;
        }
        public String getTel()
        {
            return tel;
        }
        public void setTel(String tel)
        {
            this.tel = tel;
        }
        
    }
    
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Home getHome()
    {
        return home;
    }
    public void setHome(Home home)
    {
        this.home = home;
    }
}