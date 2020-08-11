package com.LeetCode.Easy18;

import java.util.LinkedList;
import java.util.List;

public class P1260_Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] temp = new int[grid.length][grid[0].length]; // took temp grid
        int n = grid.length;
        int m = grid[0].length;
        int mod = n * m;
        k = k % mod; // minimize the k value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int p = j + k; // defines which col
                int r = p / (m); // defines which row
                if (p < m) {
                    temp[i][p] = grid[i][j];
                } else {
                    temp[(i + r) % n][p % m] = grid[i][j];
                }
            }
        }
        // making temp grid into list
        List<List<Integer>> result = new LinkedList<>();
        for (int[] t : temp) {
            LinkedList<Integer> c = new LinkedList<>();
            for (int i : t) {
                c.add(i);
            }
            result.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1260_Shift2DGrid().shiftGrid(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}},1
        ));
    }
}
