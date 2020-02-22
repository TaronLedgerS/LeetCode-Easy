package com.LeetCode.Easy13;

import java.util.Arrays;

public class P867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int n = A.length,m = A[0].length;
        int[][] B = new int[m][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++)
                B[j][i] = A[i][j];
        }
        return B;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                    new P867_TransposeMatrix().transpose(new  int[][]{{1,2,3},{4,5,6}})
                ));
    }
}
