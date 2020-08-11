package com.LeetCode.Easy18;

public class P1281_SubtractTheProduceAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        if (n==0) return 0;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            sum += temp;
            product *= temp;
        }
        return  product - sum;
    }
}
