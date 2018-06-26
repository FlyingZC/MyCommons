package com.zc.basic.z01func.demo;

/**
 * @author flyingzc
 * ++操作符
 */
public class T05AddAdd
{
    final int EASY = 0;

    public static void main(String[] args)
    {
        int x = 5;
        T05AddAdd t = new T05AddAdd();
        t.doStuff(++x);
        t.add01(6);
        t.add02(6);
    }

    void doStuff(int s)
    {
        //等价与s=s+	EASY+ ++s;
        s += EASY + ++s;//s=13
        System.out.println("s=" + s);
    }

    void add01(int s)
    {
        s = s + EASY + ++s;//13
        System.out.println(s);
    }

    void add02(int s)
    {
        //也就是说++s会影响到本句中后面的s
        s = EASY + ++s + s;//14
        System.out.println(s);
    }
}
