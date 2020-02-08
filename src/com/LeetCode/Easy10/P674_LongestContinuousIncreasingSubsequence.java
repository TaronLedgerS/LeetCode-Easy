package com.LeetCode.Easy10;

public class P674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length<2) return nums.length;
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                res = Math.max(res, count);
            }else
                count=1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(
                        new int[]{1,3,5,4,7}
                )
        );
    }
}
