package com.zc.basic.z11otherapi;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.junit.Test;

public class T01
{
    /**
     * PropertyChangeSupport的使用,用于监听某个对象中属性的变化  
     */
    @Test
    public void test01()
    {
        PC sourceBean = new PC();
        // new PropertyChangeSupport(Object sourceBean)
        // 将要控制监听的对象 绑定到该PropertyChangeSupport中
        PropertyChangeSupport changeSupport = new PropertyChangeSupport(sourceBean);
        PropertyChangeListener listener = new PropertyChangeListener()
        {

            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("--property change--");
            }
        };
        changeSupport.addPropertyChangeListener(listener);
        // changeSupport.removePropertyChangeListener(listener);

        String propertyName = "name";
        Object oldValue = "11";
        Object newValue = "22";
        changeSupport.firePropertyChange(propertyName, oldValue, newValue);

    }
    
    /**
     * 将PropertyChangeSupport对象移动到实体类中,简化代码
     */
    @Test
    public void test02()
    {
        PC2 bean = new PC2();
        PropertyChangeListener listener = new PropertyChangeListener()
        {

            @Override
            public void propertyChange(PropertyChangeEvent evt)
            {
                System.out.println("--property change--");
                System.out.println(evt.getPropertyName());  
                System.out.println(evt.getOldValue());  
                System.out.println(evt.getNewValue());    
            }
        };
        bean.addPropertyChangeListener(listener);
        // firePropertyChange 移动到setXXX方法中,即在设置属性时自动调用
        bean.setName("zcc");
        bean.setAge(11);
    }
}

class PC2
{
    private String name;

    private Integer age;

    // new PropertyChangeSupport(Object sourceBean)
    // 将要控制监听的对象 绑定到该PropertyChangeSupport中.一般在实体类中添加该propertyChangeSupport对象,然后在调用set方法时触发监听
    PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        String oldName = this.name;
        this.name = name;
        // firePropertyChange 移动到setXXX方法中,即在设置属性时自动调用
        support.firePropertyChange("name", oldName, this.name);
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        Integer oldAge = this.age;
        this.age = age;
        support.firePropertyChange("age", oldAge, this.age);

    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }

}

class PC
{
    private String name;

    private Integer age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

}
