package com.LeetCode.Easy7;

public class P463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==0) continue;

                if (i == 0) {
                    count++;
                } else if (grid[i-1][j] == 0){
                    count++;
                }

                if (j == 0) {
                    count++;
                }else if (grid[i][j - 1] == 0)
                    count++;

                if (i==grid.length-1) {
                    count++;
                }else if(grid[i+1][j]==0)
                    count++;

                if (j==grid[i].length-1) count++;
                else if (grid[i][j + 1] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid={
                {0,1,0,0 },
                {1,1,1,0 },
                {0,1,0,0 },
                {1,1,0,0 },
        };
        System.out.println(new P463_IslandPerimeter().islandPerimeter(grid));
    }
}
