package com.LeetCode.Easy22;

public class P1556_ThousandSeparator {
    public String thousandSeparator(int n) {
        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length(); i > 0; i -= 3) {
            if (sb.length() > 0) sb.insert(0, ".");
            sb.insert(0, num.substring(Math.max(0, i - 3), i));
        }
        return sb.toString();
    }
}
