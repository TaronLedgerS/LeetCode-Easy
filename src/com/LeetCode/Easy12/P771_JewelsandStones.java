package com.LeetCode.Easy12;

public class P771_JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        if (J.length()==0) return 0;
        int[] JLowerCaseChar  = new int[26];
        int[] JUpperCaseChar = new int[26];
        for (char c : J.toCharArray()) {
            if (c>='a'&&c<='z') JLowerCaseChar[c - 'a']++;
            if(c>='A'&&c<='Z') JUpperCaseChar[c - 'A']++;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (c>='a'&&c<='z') ans+=JLowerCaseChar[c - 'a'];
            if(c>='A'&&c<='Z') ans+=JUpperCaseChar[c - 'A'];
        }
        return ans ;
    }
    public static void main(String[] args) {
        System.out.println(
                new P771_JewelsandStones().numJewelsInStones(
                        "aA","aAAbbb"
                )
        );
    }
}

