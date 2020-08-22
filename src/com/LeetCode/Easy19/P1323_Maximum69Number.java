package com.LeetCode.Easy19;

public class P1323_Maximum69Number {
    public int maximum69Number (int num) {
        char[] numString = String.valueOf(num).toCharArray();
        for (int i = 0; i < numString.length; i++) {
            if (numString[i] == '6') {
                numString[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numString));
    }

    public static void main(String[] args) {
        System.out.println(new P1323_Maximum69Number().maximum69Number(9669));
    }
}
