package com.LeetCode.Easy12;

import java.util.Arrays;

public class P832_FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        final int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (A[i][j] == A[i][N - j - 1]) {
                    A[i][j] ^= 1 ;
                    A[i][N - j - 1] ^=  1;
                }
            }
            if (N%2==1)
                A[i][N/2] ^= 1;
        }
        return A;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new P832_FlippinganImage().flipAndInvertImage(
                                new int[][]{{1,1,0},{1,0,1},{0,0,0}}
                        )
                )
        );
    }
}
