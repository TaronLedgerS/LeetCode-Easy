package com.LeetCode.Easy4;

import java.util.Scanner;
import java.util.Stack;

public class P232_ImplementQueueusingStacksTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue2 obj = new MyQueue2();
        int t;
        while ((t = sc.nextInt())!=-1) {
            obj.push(t);
            obj.push(t+1);
            int param_2 = obj.peek();
            int param_3 = obj.pop();
            boolean param_4 = obj.empty();
            System.out.println(param_2+" "+param_3+" "+param_4);
        }
    }
}

class MyQueue2 {
    private Stack<Integer>  s1 = new Stack<>();//栈顶当队尾
    private Stack<Integer>  s2 = new Stack<>();
    private int front;
    /** Initialize your data structure here. */
    public MyQueue2() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()) {
            front=x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        int a = s2.pop();
        if (!s2.empty()) {
            front = s2.peek();
        } else {
            front = -1;
        }
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        return a;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}

class MyQueue {
    private Stack<Integer>  s1 = new Stack<>();
    private Stack<Integer>  s2 = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.empty())
            s2.push(s1.pop());
        s1.push(x);
        while (!s2.empty())
            s1.push(s2.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}
