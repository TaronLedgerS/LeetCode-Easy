package com.LeetCode.Easy12;

import java.util.Arrays;

public class P806_NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        if( S==null || S.length()==0) return new int[]{0,0};
        int countLine = 1;
        int lastLine = 0;
        for(char c:S.toCharArray()){
            lastLine += widths[c-'a'];
            if(lastLine>100){
                countLine++;
                lastLine = widths[c-'a'];
            }
        }
        return new int[]{countLine,lastLine};
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                new P806_NumberofLinesToWriteString().numberOfLines(
                        new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                        "abcdefghijklmnopqrstuvwxyz")));
    }
}
