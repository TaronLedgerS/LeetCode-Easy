package com.LeetCode.Easy20;

public class P1413_MinimumValueToGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        int sum = 0, min_sum = 0;
        for (int n : nums) {
            sum += n;
            min_sum = Math.min(min_sum, sum);
        }
        return 1 - min_sum;

    }

}
