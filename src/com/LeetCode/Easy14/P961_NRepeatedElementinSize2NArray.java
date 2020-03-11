package com.LeetCode.Easy14;

public class P961_NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        for (int k = 3; k >= 1; --k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];
        return -1;
    }
}
