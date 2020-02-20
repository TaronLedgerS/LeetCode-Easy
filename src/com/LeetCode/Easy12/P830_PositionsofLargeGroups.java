package com.LeetCode.Easy12;

import java.util.LinkedList;
import java.util.List;

public class P830_PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new LinkedList<>();
        if (S.length()<3) return ans;
        int begin = 0;
        for (int i = begin+1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (i - begin >= 3) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(begin);
                    temp.add(i - 1);
                    ans.add(temp);
                }
                begin = i;
            }
        }
        if(S.length()-begin>=3){
            List<Integer> temp = new LinkedList<>();
            temp.add(begin);
            temp.add(S.length() - 1);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P830_PositionsofLargeGroups().largeGroupPositions("aaa")
        );
    }
}
