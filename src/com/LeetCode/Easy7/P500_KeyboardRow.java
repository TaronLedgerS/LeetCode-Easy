package com.LeetCode.Easy7;

import java.util.*;

public class P500_KeyboardRow {
    public String[] findWords(String[] words) {
        String[] keyboardrow = {"qwertyuioop","asdfghjkl","zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<keyboardrow.length; i++){
            for(char c: keyboardrow[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> keywords = new LinkedList<>();
        for (String w : words) {
            if (w.equals("")) continue;
            int index = map.get(w.toLowerCase().charAt(0));
            for (char c : w.toLowerCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) {
                keywords.add(w);
            }
        }
        //错误！！
        //return (String[]) keywords.toArray();
        return keywords.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new P500_KeyboardRow().findWords( new String[]{"Hello", "Alaska", "Dad", "Peace"})
                )
        );
    }
}
