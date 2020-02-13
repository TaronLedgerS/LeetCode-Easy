package com.LeetCode.Easy11;

import java.util.ArrayList;
import java.util.List;

public class P728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumbers(i)) ans.add(i);
        }
        return ans;
    }
    private boolean isSelfDividingNumbers(int n) {
        char[] temp  = String.valueOf(n).toCharArray();
        for (char c : temp) {
            if (c=='0'|| n%(c-'0')>0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P728_SelfDividingNumbers().selfDividingNumbers(1,22).toString()
        );
    }
}
