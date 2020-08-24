package com.LeetCode.Easy21;

public class P1455_CheckIfAWordOccursAsAPrefixofAnyWordinaSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
