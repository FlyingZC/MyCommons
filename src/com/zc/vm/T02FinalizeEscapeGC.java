package com.zc.vm;

/**
 * 忘掉finalize(),不要(重写)使用该方法
 *1.对象可在被GC时自我拯救
 *2.这种自救的机会只有一次,因为一个对象的finalize()方法最多只会被系统自动调用一次 
 * @author  Administrator
 * @version  [版本号, 2017年1月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class T02FinalizeEscapeGC
{
    //本类的对象
    public static T02FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive()
    {
        System.out.println("yes,我还活着.");
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();//一定调用super.finalize();
        System.out.println("finalize方法执行!");
        //若对象要在finalize()中成功拯救自己,只需重新与引用链上的任何一个对象建立关联即可.比如this.
        //但是finalize()只会执行一次
        T02FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException
    {
        SAVE_HOOK = new T02FinalizeEscapeGC();
        //置为null将会被回收
        SAVE_HOOK = null;
        //对象第一次成功拯救自己.gc时会调用finalize()
        System.gc();
        //因为finalize方法优先级很低,所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null)
        {
            SAVE_HOOK.isAlive();
        }
        else
        {
            System.out.println("no 我死了");
        }
        System.out.println("尝试第二次救赎");
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null)
        {
            SAVE_HOOK.isAlive();
        }
        else
        {
            System.out.println("no 我死了");
        }
    }

}
