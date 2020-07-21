package com.LeetCode.Easy15;

import java.util.Arrays;

public class P1029_TwoCityScheduling {

    public int twoCitySchedCost1(int[][] costs) {

        int N = costs.length / 2;
        // dp[k][i][j]:前k个人中去A城有i个人与去B城有j个人的最小花费，i+j==k，i，j<N
        int[][][] dp = new int[2*N+1][N+1][N+1];

        for (int k = 1; k <= costs.length; k++) {// 第K个人

            for (int i = 0; i <= k; i++) {
                int j = k-i;

                if (j > N || i > N) continue;
                if (i==0)
                    dp[k][0][j] = dp[k-1][0][j-1] + costs[k-1][1];//全去B城
                else if (i==k)
                    dp[k][i][0] = dp[k-1][i-1][0] + costs[k-1][0];//全去A城
                else
                    dp[k][i][j] = Math.min(
                            dp[k - 1][i - 1][j] + costs[k - 1][0],
                            dp[k - 1][i][j- 1] + costs[k - 1][1]);
            }
        }
        return dp[2*N][N][N];
    }
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs,(a,b)->((a[0]-a[1])-(b[0]-b[1])));
        int ans = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            ans+= costs[i][0]+costs[costs.length-i-1][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P1029_TwoCityScheduling().twoCitySchedCost(
                new int[][]{
                        {10, 20}, {30, 200}, {400, 50}, {30, 20}
                }
        ));
    }
}
