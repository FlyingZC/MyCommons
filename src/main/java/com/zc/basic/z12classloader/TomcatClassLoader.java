package com.zc.basic.z12classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author flyingzc
 * 自定义类加载器
 */
public class TomcatClassLoader extends ClassLoader
{
    public static void main(String[] args) throws Exception
    {
        // 创建自定义类加载器对象
        TomcatClassLoader loader = new TomcatClassLoader(TomcatClassLoader.class.getClassLoader(), "TomcatClassLoader");
        // 加载LoadTest类
        Class clazz = loader.loadClass("com.zc.basic.z12classloader.LoadTest");
        LoadTest o = (LoadTest) clazz.newInstance();
        o.print();
    }

    private String name;

    public TomcatClassLoader(ClassLoader parent, String name)
    {
        super(parent);
        this.name = name;
    }

    // 重写findClass方法,此方法要读取.class字节流并传入父类的defineClass方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        InputStream is = null;
        byte[] clazzData = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            // 加載.class文件
            is = new FileInputStream(new File(
                    "D:\\myworkspace\\workspace1-my\\MyCommons\\src\\com\\zc\\basic\\z12classloader\\LoadTest.class"));
            int c = 0;
            while (-1 != (c = is.read()))
            {
                out.write(c);
            }
            clazzData = out.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return this.defineClass(name, clazzData, 0, clazzData.length);
    }
}
