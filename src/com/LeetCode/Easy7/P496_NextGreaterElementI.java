package com.LeetCode.Easy7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        //构造x与后续比x大的映射
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        //查询
        int[] ans = new int[nums1.length];
        for (int i = 0;i<nums1.length;i++) {
            //当Map集合中有这个key时，就使用这个key的值，如果没有就使用默认值defaultValue
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] num1= {9,8,4,6,7,2,3,10};
        int[] num2 ={9,8,4,6,7,2,3,10};
        System.out.println(Arrays.toString(new P496_NextGreaterElementI().nextGreaterElement(num1,num2)));
    }
}
