package com.zc.advice;

public class A {
    public static void main(String[] args) {
        int i = 1, j = 10;
        do {
            System.out.println("i: " + i + ", j: " + j);
            if (i++ > --j) continue;
            System.out.println("i: " + i + ", j: " + j);
        } while (i < 7);
        System.out.println(i);
        System.out.println(j);
    }

    public static void main() {

    }

}

class B {

}
