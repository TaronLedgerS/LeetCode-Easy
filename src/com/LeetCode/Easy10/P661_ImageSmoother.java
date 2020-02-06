package com.LeetCode.Easy10;

import java.util.Arrays;

public class P661_ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int len1 = M.length;
        int len2 = M[0].length;
        int[][] result = new int[len1][len2];
        for(int i = 0;i < len1;i++) {
            for(int j = 0;j < len2;j++) {
                int sum = 0;
                int count = 0;
                for(int m = i - 1;m < i + 2;m++) {
                    for(int n = j - 1;n < j + 2;n++) {
                        if(m >= 0 && m < len1 && n >= 0 && n < len2) {
                            sum += M[m][n];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(
                        Arrays.deepToString(new P661_ImageSmoother().imageSmoother(
                                new int[][]{{1,3,2},{6,2,25}}
                        ))
                );

    }
}
