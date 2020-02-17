package com.LeetCode.Easy12;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        if (S==null) return new LinkedList<>(queue);
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)>='0'&&S.charAt(i)<='9') continue;
            int num = queue.size();
            for (int j = 0; j < num; j++) {
                String cur = queue.poll();
                char[] ch = cur.toCharArray();
                ch[i] = Character.toLowerCase(ch[i]);
                queue.offer(String.valueOf(ch));
                ch[i] = Character.toUpperCase(ch[i]);
                queue.offer(String.valueOf(ch));
            }
        }
        return new LinkedList<>(queue);
    }
    public static void main(String[] args) {
        System.out.println(
                new P784_LetterCasePermutation().letterCasePermutation("a1b2")
        );
    }
}
