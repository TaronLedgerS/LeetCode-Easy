package com.LeetCode.Easy19;

public class P1342_NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps (int n) {
        int steps = 0;
        while ( n != 0) {
            steps++;
            n = n % 2 == 0 ? n / 2 : n - 1;
        }

        return steps;
    }
}
