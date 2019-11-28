package com.LeetCode.Easy5;

import java.util.Scanner;

public class P326_PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        P326_PowerofThree test = new P326_PowerofThree();
        System.out.println(test.isPowerOfThree(n));
    }
}
