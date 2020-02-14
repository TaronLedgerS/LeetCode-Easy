package com.LeetCode.Easy11;

public class P747_LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        if (nums.length==1) return 0;
        int maxFirst = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        int maxFirstIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxFirst) {
                maxSecond = maxFirst;
                maxFirst = nums[i];
                maxFirstIndex = i;
            }else if(nums[i] > maxSecond)
                maxSecond = nums[i];
        }
        if (maxFirst>=maxSecond*2) return maxFirstIndex;
        else return -1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P747_LargestNumberAtLeastTwiceofOthers().dominantIndex(
                        new  int[]{3, 5, 1, 0}
                )
        );
    }
}
