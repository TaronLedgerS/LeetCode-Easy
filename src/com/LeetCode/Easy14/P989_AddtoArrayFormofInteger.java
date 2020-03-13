package com.LeetCode.Easy14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P989_AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> sum = new ArrayList<>();
        int N = A.length;
        int cur = K;
        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            sum.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new P989_AddtoArrayFormofInteger().addToArrayForm(new int[]{2,1,5},806));
    }
}
