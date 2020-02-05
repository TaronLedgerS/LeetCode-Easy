package com.LeetCode.Easy9;

public class P598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minCol * minRow;
    }
    public static void main(String[] args) {
        System.out.println(
                new P598_RangeAdditionII().maxCount(
                        3,3, new int[][]{{2,2},{3,3}}
                )
        );
    }
}
