package com.LeetCode.Easy22;

public class P1523_CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
