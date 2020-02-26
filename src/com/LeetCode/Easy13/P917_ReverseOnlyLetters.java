package com.LeetCode.Easy13;

public class P917_ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i= 0,j=S.length()-1;
        while(i<j){
            while(
                    !Character.isLetter(chars[i])&&i<j) i++;
            while(
                    !Character.isLetter(chars[j])&&i<j) j--;
            if(i<j){
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] =t;
                i++;j--;
            }
        }
        return new String(chars);
    }
}
