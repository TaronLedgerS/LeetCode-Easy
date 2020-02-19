package com.LeetCode.Easy12;

import java.util.HashSet;
import java.util.Set;

public class P804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> transfored = new HashSet<>();
        for(String s :words){
            StringBuilder sb = new StringBuilder();
            for(char c:s.toCharArray()){
                sb.append(MORSE[c-'a']);
            }
            transfored.add(sb.toString());
        }
        return transfored.size();
    }
    public static void main(String[] args) {
        System.out.println(
                new P804_UniqueMorseCodeWords().uniqueMorseRepresentations(
                        new String[]{"gin", "zen", "gig", "msg"}
                )
        );
    }
}
