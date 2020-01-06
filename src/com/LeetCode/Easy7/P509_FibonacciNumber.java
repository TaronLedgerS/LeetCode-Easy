package com.LeetCode.Easy7;

import java.util.ArrayList;
import java.util.List;

public class P509_FibonacciNumber {
    List<Integer> cache = new ArrayList<>();
    {
        cache.add(0);
        cache.add(1);
    }
    public int fib(int N) {
        if (N <= 1) {
            return cache.get(N);
        }
        if (N < cache.size()) {
            return cache.get(N);
        } else {
            int temp = fib(N-1) + fib(N - 2);
            cache.add(temp);
            return cache.get(N);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P509_FibonacciNumber().fib(4));
    }
}
