package com.LeetCode.Easy13;

public class P859_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;
            for (int c: count)
                if (c > 1) return true;
            return false;
        }
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (firstIndex == -1)
                    firstIndex = i;
                else if (secondIndex == -1 )
                    secondIndex = i;
                else
                    return false;
            }
        }
        return  secondIndex!=-1&&A.charAt(firstIndex)==B.charAt(secondIndex) && A.charAt(secondIndex)==B.charAt(firstIndex);
    }
    public static void main(String[] args) {
        System.out.println(
                new P859_BuddyStrings().buddyStrings("aaaaaa", "aaaaaa")
        );
    }
}
