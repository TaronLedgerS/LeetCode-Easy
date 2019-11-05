package com.LeetCode.Easy1;

public class P70_ClimbingStairsTest {
    public static void main(String[] args){
        ClimbStairs  temp = new ClimbStairs ();
        System.out.println(temp.climbStairs (48));
    }
}
class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}