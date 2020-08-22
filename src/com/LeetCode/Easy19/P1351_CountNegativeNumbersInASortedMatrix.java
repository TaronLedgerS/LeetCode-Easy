package com.LeetCode.Easy19;

public class P1351_CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            ans += numNegative(grid[i]);
        }
        return ans;

    }

    private int numNegative(int[] row) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (row[m] < 0) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return row.length-l;
    }
}
