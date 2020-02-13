package com.LeetCode.Easy11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P733_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc]==newColor) return image;
        int oldColor = image[sr][sc];
        int[] BFS_DIR = {0,1,0,-1,0};//小技巧
        Queue<pixel> queue = new LinkedList<>();
        queue.offer(new pixel(sr, sc));
        while (!queue.isEmpty()) {
            pixel p = queue.poll();
            image[p.rowIndex][p.colIndex] = newColor;
            for (int i = 0; i < BFS_DIR.length-1; i++) {
                int nextR = p.rowIndex+BFS_DIR[i];
                int nextC = p.colIndex + BFS_DIR[i + 1];
                if (nextR >= 0 && nextR < image.length && nextC >= 0 && nextC < image[0].length && image[nextR][nextC] == oldColor) {
                    queue.offer(new pixel(nextR, nextC));
                }
            }
        }
        return image;
    }
    static class pixel{
        int rowIndex;
        int colIndex;
        pixel(int r, int c) {
            rowIndex = r;
            colIndex = c;
        }
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(new P733_FloodFill().floodFill(
                        new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2
                ))
        );
    }
}
