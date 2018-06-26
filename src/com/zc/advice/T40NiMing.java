package com.zc.advice;

/**
 * <匿名类>
        执行顺序:先调用父类的构造方法(参数与传入的参数一致).再调用匿名类的代码块
        即:
     Calculator有参构造方法
               匿名类的代码块     
 * @author  flyingzc
 * @version  [版本号, 2017年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T40NiMing
{
    public static void main(String[] args)
    {//定义匿名类,调用1+2
        Calculator c=new Calculator(1,2)
        {
            {
                System.out.println("匿名类的代码块");
                setOperate(Ops.ADD);
            }
        };
        System.out.println(c.getResult());
    }
}
class Calculator
{
    private int i,j,result;
    public Calculator()
    {
        System.out.println("Calculator无参构造方法");
    }
    public Calculator(int i,int j)
    {
        System.out.println("Calculator有参构造方法");
        this.i=i;
        this.j=j;
    }
    //加法or减法
    public void setOperate(Ops op)
    {
        result=op.equals(Ops.ADD)?i+j:i-j;
    }
    public int getResult()
    {
        return result;
    }
}
//枚举类,限定加减操作
enum Ops{ADD,SUB}
