package com.LeetCode.Easy6;

public class P441_ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i+=1;
            n-=i;
        }
        return n==0?i:i-1;
    }
    public static void main(String[] args) {
        System.out.println(new P441_ArrangingCoins().arrangeCoins(5));
    }
}
