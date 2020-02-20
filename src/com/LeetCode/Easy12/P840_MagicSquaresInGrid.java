package com.LeetCode.Easy12;

public class P840_MagicSquaresInGrid {
    int cnt, m, n;
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        cnt = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                if (isMagicSquare(grid, i, j)) cnt++;
            }
        }
        return cnt;
    }
    private boolean isMagicSquare(int[][] grid, int x, int y) {
        //check 1-9
        int[] nums = new int[9];
        for (int i = x - 2; i <= x; i++) {
            for (int j = y - 2; j <= y; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1) return false; //check num that not in 1-9
                nums[grid[i][j] - 1]++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (nums[i] == 0) return false;
        }
        //checkRow
        int row1 = grid[x][y - 2] + grid[x - 1][y - 2] + grid[x - 2][y - 2];
        int row2 = grid[x][y - 1] + grid[x - 1][y - 1] + grid[x - 2][y - 1];
        int row3 = grid[x][y] + grid[x - 1][y] + grid[x - 2][y];
        //checkCol
        int col1 = grid[x][y] + grid[x][y - 1] + grid[x][y - 2];
        int col2 = grid[x - 1][y] + grid[x - 1][y - 1] + grid[x - 1][y - 2];
        int col3 = grid[x - 2][y] + grid[x - 2][y - 1] + grid[x - 2][y - 2];
        //checkDiagonal
        int dia1 = grid[x - 2][y - 2] + grid[x - 1][y - 1] + grid[x][y];
        int dia2 = grid[x - 2][y] + grid[x - 1][y - 1] + grid[x][y - 2];
        return row1 == row2 && row1 == row3 && row1 == col1 && row1 == col2 && row1 == col3 && row1 == dia1 && row1 == dia2;
    }
    public static void main(String[] args) {
        System.out.println(
                new P840_MagicSquaresInGrid().numMagicSquaresInside(new int[][]{{4,3,8,4}, {9,5,1,9},{2,7,6,2}})
        );
    }
}
