package com.LeetCode.Easy18;

public class P1266_MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 0; i < n-1; i++) {
            int deltaX = Math.abs(points[i+1][0] - points[i][0]);
            int deltaY = Math.abs(points[i+1][1] - points[i][1]);
            ans += Math.max(deltaX, deltaY) ;
        }
        return ans;
    }
}
