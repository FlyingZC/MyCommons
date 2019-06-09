package com.zc.advice;

/**
 * <内部类实现多继承>
 * <功能详细描述>
 * 
 * @author  zc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T41MoreExtends
{
    
}
interface Father
{
    public int strong();
}

interface Mother
{
    public int kind();
}

class FatherImpl implements Father
{

    @Override
    public int strong()
    {
        return 8;
    }
    
}

class MotherImpl implements Mother
{

    @Override
    public int kind()
    {
        return 8;
    }
    
}
//一个多重继承的体现
class Son extends FatherImpl implements Mother
{

    @Override
    public int strong()
    {//孩子比父亲更强壮
        return super.strong()+1;
    }
    
    //实现Mother接口中的方法
    @Override
    public int kind()
    {
        //返回内部类中的结果
        return new MotherSpecial().kind();
    }
    //成员内部类Instance Inner Class,内部类可以继承一个与外部类无关的类
    private class MotherSpecial extends MotherImpl
    {
        @Override
        public int kind()
        {//孩子没母亲温柔
            return super.kind()-1;
        }
    }
}









