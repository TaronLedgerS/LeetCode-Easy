package com.LeetCode.Easy13;

public class P892_SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int N = grid.length;
        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];
                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P892_SurfaceAreaof3DShapes().surfaceArea(
                        new int[][]{{1,1,1},{1,0,1},{1,1,1}}
                )
        );
    }
}
