package com.LeetCode.Easy5;

public class P367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            int res = num/mid, tail = num%mid;  //Prevents overflow
            if(res==mid && tail==0) return true;
            else if(res>mid) lo = mid+1;
            else hi = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 14;
        P367_ValidPerfectSquare test = new P367_ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(n));
    }
}
