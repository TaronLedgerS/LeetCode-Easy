package com.LeetCode.Easy13;

public class P922_SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i=0,j=1;
        int n= A.length;
        while(true){
            while(i<n&&A[i]%2==0) i+=2;
            while(j<n&&A[j]%2==1) j+=2;
            if(i>=n||j>=n) break;
            int t = A[i];
            A[i]=A[j];
            A[j] = t;
            i+=2;
            j+=2;
        }
        return A;
    }
}
