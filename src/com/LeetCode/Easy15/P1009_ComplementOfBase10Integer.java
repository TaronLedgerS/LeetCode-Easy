package com.LeetCode.Easy15;

public class P1009_ComplementOfBase10Integer {

    public int bitwiseComplement(int N) {
        if (N == 1) return 0;
        if (N == 0) return 1;
        int X = 1;
        while (X <= N) {
            X = X << 1;
        }
        return N ^ (X - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P1009_ComplementOfBase10Integer().bitwiseComplement(7));
    }
}
