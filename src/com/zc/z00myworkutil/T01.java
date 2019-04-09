package com.zc.z00myworkutil;

public class T01 {
    public static void main(String[] args) {
        Sub1 sub = new Sub1();
        sub.say();
        Sup1 sub1 = (Sup1)new Sub1();
    }


}
class Sup1 {
    public void say() {
        System.out.println("hello parent");
    }
}

class Sub1 extends Sup1 {
    @Override
    public void say() {
        super.say();
        System.out.println("hello sub");
    }
}