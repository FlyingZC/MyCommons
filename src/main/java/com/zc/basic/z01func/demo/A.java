package com.zc.basic.z01func.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class A {
     private static final  A obj1 = new A(1);

     private int h = 0;
     private int h1;
     private final int h2 = 0;
     final Integer h3 = new Integer(1);
     final Integer h4 = null;
     final List<String> h5 = new ArrayList<>();
    {
        // h3 = new Integer(2);
        h5.add("1");
    }

     public A() {
         System.out.println("A的无参构造方法");
     }

     public A(int age) {
         this.age = age;
     }


    int age;
    private static int statAge;
    public static void main(String[] args) {
        System.out.println(obj1);
       // obj1 = new A();
        System.out.println(obj1);
        int a;
        A.statAge = 2;
        System.out.println(A.statAge);

        obj1.age = 1;
        System.out.println(obj1.statAge);
        obj1.statAge = 3;
        System.out.println(obj1.age);

        A obj2 = new A();
        System.out.println(obj2.statAge);
        obj2.age = 11;
        System.out.println(obj2.age);


        testM1();

        if (true && true) {

        }

        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

        String s1 = "ab";
        String s2 = "ab";
        String s3 = new String("ab");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        if (s1.equals(s2)) {

        }
    }

    public static void testM1() {
        System.out.println(statAge);
        System.out.println(obj1);


    }


}

class B {
    public void test() {
       // A.statAge = 1;

    }
}

abstract class ABS {
    abstract void a();

    protected void b() {

    }

    public final void fc() {

    }
}

final class Con extends ABS {
    @Override
    void a() {

    }

   public void b() {
        final int x = 1
                ;
        Integer xx = null;
       System.out.println(xx);

       final int fx = 1;

       System.out.println(fx);
    }

    class A {

    }

    static class B {

    }

}

