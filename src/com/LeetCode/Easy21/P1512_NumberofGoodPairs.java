package com.LeetCode.Easy21;

import java.util.Arrays;

public class P1512_NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i])
                count += j - i;
            else i = j;
        }
        return count;
    }
}
