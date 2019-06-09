package com.zc.z12leetcode;

import java.util.LinkedList;

/**
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

public class T02
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        
        list1.add(2);
        list1.add(9);
        list1.add(3);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        
        list2.add(5);
        list2.add(6);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(4);
        
        LinkedList<Integer> listLong = null, listShort = null;
        if (list1.size() > list2.size())
        {
            listLong = list1;
            listShort = list2;
        } 
        else 
        {
            listLong = list2;
            listShort = list1;
        }
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        int needAdd = 0;
        for (int i = listLong.size() - 1; i >= 0; i--)
        {
            int sum;
            if (i < listShort.size())
            {
                sum = listLong.get(i) + listShort.get(i);
            }
            else
            {
                 sum = listLong.get(i);
            }
            result.add(sum % 10 + needAdd);
            needAdd = sum > 9 ? 1 : 0; 
        }
        System.out.println(result);
    }
}

/**
 * 模拟单链表
 * */
class ListNode
{
    private int value;
    private ListNode next;
    
    ListNode(int value)
    {
        this.value = value;
    }
}