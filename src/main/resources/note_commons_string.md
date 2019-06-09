1.不可变String
String类中每一个看起来会修改String值的方法,实际上是创建了一个全新的String对象,而最初的String对象则丝毫未动

2.String与StringBuilder
String mango = "mango";

String s = "abc" + mango + "def" + 47;
//相当于
String s1=new StringBuilder().append("abc").append(mango).append("def").append(47).toString();

3.在循环体中使用上例子
strings.WhitherStringBuilder
在只有一行时,可用+号拼接String,编译期自动通过StringBuilder转换
若是循环,最好自己使用StringBuilder拼接字符串

4.
public String toString()
{   //这里this需要调用InfiniteRecursion类的toString()方法,转成字符串输出.等于又递归调用了 本 toString()方法...
    //java.lang.StackOverflowError
    return " InfiniteRecursion address: " + this + "\n";
}

5.StringBuilder() 默认
          构造一个其中不带字符的字符串生成器，初始容量为 16 个字符。
          
6.正则表达式thinking P298
贪婪模式:量词总是尽可能多的匹配

7.CharSequence是从String,StringBuffer等抽象的一般化接口

8.Pattern和Matcher
Pattern类:正则表达式的编译表示形式
          