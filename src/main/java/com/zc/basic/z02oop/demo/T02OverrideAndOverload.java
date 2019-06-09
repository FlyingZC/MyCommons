package com.zc.basic.z02oop.demo;
// 重写 和 重载
public class T02OverrideAndOverload
{

}

class Sup
{
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
