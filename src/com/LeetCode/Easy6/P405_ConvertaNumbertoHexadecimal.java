package com.LeetCode.Easy6;

public class P405_ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    public static void main(String[] args) {
        P405_ConvertaNumbertoHexadecimal test = new P405_ConvertaNumbertoHexadecimal();
        System.out.println(test.toHex(-1));
    }
}
