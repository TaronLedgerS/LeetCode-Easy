package com.LeetCode.Easy7;

public class P453_MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int val : nums) {
            min = Math.min(min, val);
            sum += val;
        }
        return sum - nums.length * min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new P453_MinimumMovestoEqualArrayElements().minMoves(nums));
    }
}
