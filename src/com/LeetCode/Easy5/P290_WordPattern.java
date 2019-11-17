package com.LeetCode.Easy5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<Character, String> maps = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        if (pattern.length()!=words.length){
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if(!maps.containsKey(pattern.charAt(i)) && !visited.contains(words[i])){
                maps.put(pattern.charAt(i), words[i]);
                visited.add(words[i]);
            }
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!maps.containsKey(c)) {
                return false;
            }
            String s = maps.get(c);
            if (!s.equals(words[i])) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();//以回车结束，字符串不包含换行符
        String str = sc.nextLine();
        System.out.print(pattern);
        System.out.print(str);
        System.out.print(pattern);
        P290_WordPattern test = new P290_WordPattern();
        System.out.println(test.wordPattern(pattern,str));
    }
}
