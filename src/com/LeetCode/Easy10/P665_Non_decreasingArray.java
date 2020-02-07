package com.LeetCode.Easy10;

public class P665_Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (i>0 && nums[i+1]<nums[i-1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i+1];
                if (count>1) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P665_Non_decreasingArray().checkPossibility(
                        new int[]{3,4,2,3}
                )
        );
    }
}
