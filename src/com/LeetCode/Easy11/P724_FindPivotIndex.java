package com.LeetCode.Easy11;

public class P724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int  letfSum = 0,sum = 0;
        for (int num:nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (letfSum == sum-letfSum-nums[i]){
                return i;
            }
            letfSum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P724_FindPivotIndex().pivotIndex(new int[]{1,7,3,6,5,6})
        );
    }
}
