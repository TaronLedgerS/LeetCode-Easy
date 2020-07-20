package com.LeetCode.Easy15;

import java.util.ArrayList;
import java.util.List;

public class P1018_BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int a : A) {
            num = ((num << 1) + a) % 5;
            if (num == 0) res.add(true);
            else
                res.add(false);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1018_BinaryPrefixDivisibleBy5().prefixesDivBy5(
                new int[]{0, 1, 1}
        ));
    }
}
