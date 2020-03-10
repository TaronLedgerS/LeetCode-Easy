package com.LeetCode.Easy14;

public class P941_ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;
        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;
        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;
        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;
        return i == N-1;
    }
    public static void main(String[] args) {
        System.out.println(new P941_ValidMountainArray().validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));
    }
}
