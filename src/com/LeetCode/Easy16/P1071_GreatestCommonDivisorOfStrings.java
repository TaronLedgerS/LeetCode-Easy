package com.LeetCode.Easy16;

public class P1071_GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) return "";

        int GCDVal = getGCDVal(str1.length(), str2.length());

        return str1.substring(0, GCDVal);
    }


    private int getGCDVal(int p, int q) {
        if (q==0) return p;
        return getGCDVal(q, p % q);
    }


    public static void main(String[] args) {
        System.out.println(new P1071_GreatestCommonDivisorOfStrings().gcdOfStrings(
                "ABCABC","ABC"
        ));
    }
}
