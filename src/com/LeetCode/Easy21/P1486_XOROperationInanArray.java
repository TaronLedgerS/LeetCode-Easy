package com.LeetCode.Easy21;

public class P1486_XOROperationInanArray {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i=1; i<n; i++){
            res = res ^ (start + 2 * i);
        }
        return res;
    }
}
