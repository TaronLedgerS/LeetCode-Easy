package com.LeetCode.Easy20;

public class P1417_ReformatTheString {
    public String reformat(String s) {
        if (s == null || s.length() == 0) return "";
        int ds = 0, as = 0;
        char[] arr = s.toCharArray(), res = new char[s.length()];
        for (char c : arr) {
            if (Character.isDigit(c)) ds++;
            else if (Character.isLetter(c)) as++;
            else return "";
        }
        if (Math.abs(as - ds) > 1) return "";
        boolean isDigit = ds >= as;
        for (int i = 0, d = 0, a = 0; i < arr.length; i++) {
            if (isDigit) {
                while (!Character.isDigit(arr[d])) d++;
                res[i] = arr[d++];
            } else {
                while (!Character.isLetter(arr[a])) a++;
                res[i] = arr[a++];
            }
            isDigit = !isDigit;
        }
        return String.valueOf(res);
    }
}
