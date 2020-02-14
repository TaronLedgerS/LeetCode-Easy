package com.LeetCode.Easy11;

public class P746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCostSum = new int[cost.length];
        minCostSum[0]=cost[0];
        minCostSum[1]=cost[1];
        for (int i = 2; i < cost.length; i++) {
            minCostSum[i] = Math.min(minCostSum[i - 1], minCostSum[i - 2]) + cost[i];
        }
        return Math.min(minCostSum[cost.length - 2], minCostSum[cost.length - 1]);
    }
    public static void main(String[] args) {
        System.out.println(
                new P746_MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1})
        );
    }
}
