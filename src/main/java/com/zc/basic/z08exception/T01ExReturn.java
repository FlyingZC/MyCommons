package com.zc.basic.z08exception;

public class T01ExReturn {
    public static void main(String[] args) {
        // 11
        System.out.println(returnVal());
    }

    static int returnVal() {
        int a = 1;
        int b = 10;
        try {
            return ++a;
        } finally {
            // 在 finally中添加 return语句,会覆盖掉 try代码 return的值.假如业务逻辑比较复杂,这里是很容易掉坑的,不利于排查错误
            // 不要在 finally里 return
            return ++b;
        }
    }
}