package com.LeetCode.Easy12;

import java.util.Arrays;

public class P796_RotateString {
    public boolean rotateString(String A, String B) {
        //在A+A的子串中找匹配B
        int N = A.length();
        if (N!=B.length()) return false;
        if (N==0) return true;

        //初始化下标转移表
        int[] shifts = new int[N+1];
        Arrays.fill(shifts,1);
        int left = -1;
        for(int right = 0;right<N;++right){
            while(left>=0&& (B.charAt(left)!=B.charAt(right)))
                left -= shifts[left];
            shifts[right+1] = right-left++;
        }
        //Find match of B in A+A
        int matchLen = 0;
        for(char c:(A+A).toCharArray()){
            while(matchLen>=0 && B.charAt(matchLen)!=c)
                matchLen -= shifts[matchLen];
            if(++matchLen == N) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(
                new P796_RotateString().rotateString("abcde","bcdea")
        );
    }
}
