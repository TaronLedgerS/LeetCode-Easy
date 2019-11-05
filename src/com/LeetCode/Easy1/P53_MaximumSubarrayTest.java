package com.LeetCode.Easy1;

import java.util.Arrays;

public class P53_MaximumSubarrayTest {
    public static void main(String[] args){
        MaximumSubarray temp = new MaximumSubarray();
        int[] nums = {-2} ;
        System.out.println(nums.length);
        System.out.println(temp.maxSubArray(nums));
        System.out.println(Arrays.toString(nums));
    }
}
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length==0)
            return 0;
        int[] SumWithI = new  int[nums.length];
        SumWithI[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            SumWithI[i] = (SumWithI[i-1]+nums[i])>nums[i]?SumWithI[i-1]+nums[i]:nums[i];
        }
        int maxsum  = SumWithI[0];
        for (int i = 0;i<nums.length;i++){
            maxsum = maxsum  > SumWithI[i]?maxsum:SumWithI[i];
        }
        return maxsum;
    }
}
