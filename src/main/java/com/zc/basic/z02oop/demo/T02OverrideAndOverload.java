package com.zc.basic.z02oop.demo;
// 重写 和 重载
public class T02OverrideAndOverload
{

}

class Sup
{
    // 若存在父子类关系.子类构造器默认会通过隐式的 super()调用父类的无参构造器,除非指定
//    public Sup(int age) {
//
//    }

    protected int move(int x)
    {
        return 0;
    }
}

class Sub extends Sup
{
    // 重写
    @Override
    protected int move(int x)
    {
        return super.move(x);
    }

    // 重载
    protected int move(long x)
    {
        return 0;
    }

    // 重载
    private void move(double x)
    {

    }
}
