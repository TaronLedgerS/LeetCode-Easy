package com.LeetCode.Easy2;

import java.util.Stack;

public class P155_MinStackTest {
    public static void main(String[] args){
        MinStack temp = new MinStack();
        temp.push(1);

        System.out.println(temp.getMin());
        temp.pop();
    }
}

class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}