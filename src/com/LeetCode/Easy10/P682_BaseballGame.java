package com.LeetCode.Easy10;

import java.util.Stack;

public class P682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> pointsStack = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                pointsStack.pop();
            } else if ("D".equals(op)) {
                pointsStack.push(pointsStack.peek() * 2);
            } else if ("+".equals(op)) {
                int top = pointsStack.pop();
                int newTop = top + pointsStack.peek();
                pointsStack.push(top);
                pointsStack.push(newTop);
            } else {
                pointsStack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for (Integer i : pointsStack) {
            ans+=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P682_BaseballGame().calPoints(
                        new String[]{"5","2","C","D","+"}
                )
        );
    }
}
