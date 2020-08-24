package com.LeetCode.Easy21;

public class P1480_RunningSumofArray {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
