package com.LeetCode.Easy8;

public class P520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        //?零次或一次匹配前面的字符或子表达式;
        //+一次或多次匹配前面的字符或子表达式
        //*零次或多次匹配前面的字符或子表达式
        return word.matches("[A-Z]+|[A-Z]?[a-z]+");
    }
    public static void main(String[] args) {
        System.out.println(new P520_DetectCapital().detectCapitalUse("Google"));
    }
}
