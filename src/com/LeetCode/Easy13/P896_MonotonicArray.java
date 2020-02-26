package com.LeetCode.Easy13;

public class P896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return increasing(A)||decreasing(A);
    }
    public boolean increasing(int[] A){
        for(int i = 0;i<A.length-1;i++)
            if (A[i]>A[i+1]) return false;
        return true;
    }
    public boolean decreasing(int[] A){
        for(int i = 0;i<A.length-1;i++)
            if (A[i]<A[i+1]) return false;
        return true;
    }
}
