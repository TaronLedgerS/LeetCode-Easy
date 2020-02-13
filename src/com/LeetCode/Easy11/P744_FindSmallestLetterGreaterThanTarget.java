package com.LeetCode.Easy11;

public class P744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length;
        while (l < r) {
            int m = l + (r-l) / 2;
            if (letters[m]<=target) l = m + 1;
            else r = m;
        }
        return letters[l % letters.length];
    }
    public static void main(String[] args) {
        System.out.println(
                new P744_FindSmallestLetterGreaterThanTarget().nextGreatestLetter(
                        new char[]{'c', 'f', 'j'},'k'
                )
        );
    }
}
