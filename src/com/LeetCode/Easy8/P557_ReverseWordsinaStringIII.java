package com.LeetCode.Easy8;

public class P557_ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(
                    new StringBuilder(str).reverse().toString()
            );
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(
                new P557_ReverseWordsinaStringIII().reverseWords(
                        "Let's take LeetCode contest"
                )
        );
    }
}
