package com.LeetCode.Easy3;

public class P172_FactorialTrailingZeroesTest {
    public static void main(String[] args) {
        int num =125;
        FactorialTrailingZeroes temp = new FactorialTrailingZeroes();
        System.out.println(temp.trailingZeroes(num));
    }
}
class FactorialTrailingZeroes{
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
