package com.LeetCode.Easy11;

public class P748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] charMap = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c>='a'&&c<='z') charMap[c-'a']++;
        }
        int minLen = Integer.MAX_VALUE;
        String res = "" ;
        for (String word : words) {
            if (minLen > word.length()) {
                int[] currMap = new int[26];
                for (char c : word.toCharArray())
                    currMap[c - 'a']++;
                boolean match = true;
                for (int j = 0; j < 26; j++) {
                    if (charMap[j] != 0 && charMap[j] > currMap[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    res = word;
                    minLen = word.length();
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P748_ShortestCompletingWord().shortestCompletingWord(
                        "1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}
                )
        );
    }
}
