package com.LeetCode.Easy8;

import java.util.Arrays;

public class P561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length/2; i++) {
            sum += nums[2*i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new P561_ArrayPartitionI().arrayPairSum(
                        new int[]{1,4,3,2,5,6}
                )
        );
    }
}
