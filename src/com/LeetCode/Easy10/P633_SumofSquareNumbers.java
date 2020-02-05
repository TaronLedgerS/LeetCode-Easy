package com.LeetCode.Easy10;

import java.util.HashSet;
import java.util.Set;

public class P633_SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squareSet = new HashSet<>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            squareSet.add(i * i);
            if (squareSet.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(
                new P633_SumofSquareNumbers().judgeSquareSum(5)
        );
    }
}
