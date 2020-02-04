package com.LeetCode.Easy8;

public class P581_ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length<2) return 0;
        int max = nums[0];
        int endIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i]<max) endIndex = i;
        }
        int min = nums[nums.length-1];
        int beginIndex = nums.length-1;
        for (int i = nums.length-2; i >=0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i]>min) beginIndex = i;
        }
        if (endIndex>=beginIndex) return endIndex-beginIndex+1;
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new P581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(
                        new int[]{2,6,7,4,8,10,9,15}
                )
        );
    }
}
