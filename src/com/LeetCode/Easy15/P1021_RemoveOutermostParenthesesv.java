package com.LeetCode.Easy15;

public class P1021_RemoveOutermostParenthesesv {
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        int left = 0, right = 0, startIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans.append(S.substring(startIndex + 1, i));
                startIndex = i + 1;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1021_RemoveOutermostParenthesesv().removeOuterParentheses(
                "(()())(())"
        ));
    }
}
