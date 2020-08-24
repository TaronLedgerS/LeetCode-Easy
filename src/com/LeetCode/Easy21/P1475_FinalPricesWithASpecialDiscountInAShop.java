package com.LeetCode.Easy21;

import java.util.Stack;

public class P1475_FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                A[stack.pop()] -= A[i];
            stack.push(i);
        }
        return A;
    }
}
