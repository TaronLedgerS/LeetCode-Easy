package com.LeetCode.Easy13;

public class P905_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length-1;
        while(l<r){
            while(A[l]%2==0 && l<r) l++;
            while(A[r]%2==1 && l<r) r--;
            if(l<r){
                int t = A[l];
                A[l] = A[r];
                A[r] = t;
            }
        }
        return A;
    }
}
