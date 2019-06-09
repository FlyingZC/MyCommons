package com.zc.basic.z02oop.demo;

public class T02UserEqualsTest
{
    public static void main(String[] args)
    {
        User oldUser=new User();
        oldUser.setOldId("00000086");
        
        User newUser=new User();
        newUser.setId("0000000086");
        
        User aUser=new User();
        aUser.setOldId("00000086");
        aUser.setId("0000000086");
        
        System.out.println(oldUser.equals(newUser));
        System.out.println(oldUser.equals(aUser));
        System.out.println(newUser.equals(aUser));
    }
}
