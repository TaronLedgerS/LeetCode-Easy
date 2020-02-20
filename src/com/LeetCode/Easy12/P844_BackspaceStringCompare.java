package com.LeetCode.Easy12;

import java.util.Stack;

public class P844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c:S.toCharArray()) {
            if (c=='#'){
                if(!stackS.empty())
                    stackS.pop();
            }else
                stackS.push(c);
        }
        for (char c:T.toCharArray()) {
            if (c=='#'){
                if(!stackT.empty())
                    stackT.pop();
            }
            else
                stackT.push(c);
        }
        if (stackS.size()!=stackT.size()) return false;
        while (!stackS.isEmpty()){
            if (stackS.pop() != stackT.pop())
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P844_BackspaceStringCompare().backspaceCompare("a#c","b")
        );
    }
}
