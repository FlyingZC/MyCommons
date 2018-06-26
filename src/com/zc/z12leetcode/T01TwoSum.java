package com.zc.z12leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
1. 两数之和
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/
public class T01TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 7, 11, 15}; 
        int target = 9;
        System.out.println(Arrays.toString(twoSum0(nums, target)));
        System.out.println(Arrays.toString(twoSum1(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
    // 循环两次查找
    public static int[] twoSum0(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++ )
            {
                if (nums[i] + nums[j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    public static int[] twoSum1(int[] nums, int target)
    {
        // 先用map存储value 和 index
        Map<Integer, Integer> v2Idx = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) 
        {
            v2Idx.put(nums[i], i);
        }
        // 再遍历寻找
        for (int i = 0; i < nums.length; i++)
        {
            int other = target - nums[i];
            if (v2Idx.containsKey(other))
            {
                return new int[]{i, v2Idx.get(other)};
            }
        }
        return null;
    }
    
    public static int[] twoSum2(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 一边遍历,找不到放入map
        for(int i = 0; i< nums.length; i++)
        {
            int other = target - nums[i];
            // 若map中包含 ohterNum:index
            if (map.containsKey(other))
            {
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}









