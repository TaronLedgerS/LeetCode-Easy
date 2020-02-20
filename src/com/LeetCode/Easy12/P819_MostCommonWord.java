package com.LeetCode.Easy12;
import java.util.HashMap;
import java.util.Map;

public class P819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> count = new HashMap<>();
        for (String s:banned)
            count.put(s, -1);
        String lowerCaseP = paragraph.toLowerCase();
        String MCWord = "";
        StringBuilder sb = new StringBuilder();
        for (char c : lowerCaseP.toCharArray()) {
            if (c>='a'&&c<='z')
                sb.append(c);
            else{
                MCWord = putWord(sb.toString(), count, MCWord);
                sb = new StringBuilder();
            }
        }
        MCWord = putWord(sb.toString(), count, MCWord);
        return MCWord;
    }
    private String putWord(String word, Map<String,Integer> count , String MCWord){
        if (word.length()!=0){
            if (!(count.containsKey(word)&&count.get(word)==-1)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
                if (MCWord.length() == 0 || count.get(MCWord) < count.get(word)) {
                    return word;
                }
            }
        }
        return MCWord;
    }
    public static void main(String[] args) {
        System.out.println(
                new P819_MostCommonWord().mostCommonWord(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"})
        );
    }
}
