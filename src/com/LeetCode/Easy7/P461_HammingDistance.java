package com.LeetCode.Easy7;

public class P461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        System.out.println(new P461_HammingDistance().hammingDistance(1,4));
    }
}
