package com.LeetCode.Easy13;

public class P852_PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int r = A.length-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (A[m]<A[m+1])
                l = m+1;
            else
                r = m;
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println(
                new P852_PeakIndexinaMountainArray().peakIndexInMountainArray(
                        new int[]{0,2,1,0}
                )
        );
    }
}
