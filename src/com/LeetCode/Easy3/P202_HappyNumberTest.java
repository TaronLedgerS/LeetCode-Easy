package com.LeetCode.Easy3;

import java.util.HashSet;
import java.util.Set;

public class P202_HappyNumberTest {
    public static void main(String[] args) {
        int num = 19;
        HappyNumber temp = new HappyNumber();
        System.out.println(temp.isHappy(num));
    }
}

class HappyNumber{
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum;
        int remain;
        while (inLoop.add(n)) {//如果此set不已经包含了指定的元素。
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum = squareSum + remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }
}