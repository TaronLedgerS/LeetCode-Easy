package com.LeetCode.Easy1;

public class P69_SqrtTest {
    public static void main(String[] args){
       MySqrt temp = new MySqrt();
       System.out.println(temp.mySqrt(48));
    }
}

class MySqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int lo = 1, hi = x;//答案的取值范围
        while (lo < hi) {
            int mid = (lo +hi) / 2+1;
            if (mid <= x/mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}