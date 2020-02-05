package com.LeetCode.Easy10;

public class P643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+nums[i - 1];
        }
        double maxAns = Integer.MIN_VALUE;
        for (int i = k ; i < sum.length; i++) {
            maxAns = Math.max(maxAns, sum[i]-sum[i-k]);
        }
        return maxAns/k;
    }
    public static void main(String[] args) {
        System.out.println(
                new P643_MaximumAverageSubarrayI().findMaxAverage(
                        new int[]{1,12,-5,-6,50,3},4
                )
        );
    }
}
