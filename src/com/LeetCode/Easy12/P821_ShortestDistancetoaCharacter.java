package com.LeetCode.Easy12;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P821_ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        List<Integer> CPosition = new ArrayList<>();
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i)==C) CPosition.add(i);
        int preCIndex = -1;
        for (int i = 0; i < S.length(); i++) {
            if (preCIndex==-1)
                ans[i] = CPosition.get(preCIndex + 1) - i;
            else if(preCIndex==CPosition.size()-1)
                ans[i] = Math.abs(CPosition.get(preCIndex) - i);
            else
                ans[i] = Math.min(Math.abs(i - CPosition.get(preCIndex)), Math.abs(i - CPosition.get(preCIndex + 1)));
            if (preCIndex<CPosition.size()-1 && i>=CPosition.get(preCIndex + 1))
                preCIndex++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                new P821_ShortestDistancetoaCharacter().shortestToChar("loveleetcode",'e')));
    }
}
