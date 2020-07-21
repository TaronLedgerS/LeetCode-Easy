package com.LeetCode.Easy15;

import java.util.Arrays;

public class P1030_MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] next = new int[]{-1, 0, 1, 0, -1};
        boolean[][] visited = new boolean[R][C];
        int[][] res = new int[R*C][2];
        res[0][0] = r0;
        res[0][1] = c0;
        visited[r0][c0] = true;
        int indexHead = 0;
        int indexTail = 1;
        while (indexTail < R * C) {
            for (int k = 0; k < 4; k++) {
                int i = res[indexHead][0] + next[k];
                int j = res[indexHead][1] + next[k + 1];
                if (i >= 0 && j >= 0 && i < R && j < C && !visited[i][j]) {
                    res[indexTail][0] = i;
                    res[indexTail][1] = j;
                    indexTail++;
                    visited[i][j] = true;
                }
            }
            indexHead++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new P1030_MatrixCellsInDistanceOrder().allCellsDistOrder(
                2,3,1,2
        )));
    }
}
