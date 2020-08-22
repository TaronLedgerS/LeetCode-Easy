package com.LeetCode.Easy19;

public class P1309_DecryptStringfromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        if (null==s||s.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            int tmp = 0;
            if (s.charAt(i)=='#') {
                i--;
                tmp = s.charAt(i) - '0';
                i--;
                tmp += 10*(s.charAt(i) - '0');
                i--;
                char alph = (char) ('a' + tmp - 1);
                sb.append(alph);
            }else {
                tmp = s.charAt(i) - '0';
                i--;
                char alph = (char) ('a' + tmp - 1);
                sb.append(alph);
            }
        }
        return sb.reverse().toString();
    }
}
