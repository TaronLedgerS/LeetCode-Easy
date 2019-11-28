package com.LeetCode.Easy5;

import java.util.Scanner;

public class P342_PowerofFour {
    public boolean isPowerOfFour(int n) {
        while(n%4 == 0 && n>0) n =n/4;
        return n==1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        P342_PowerofFour test = new P342_PowerofFour();
        System.out.println(test.isPowerOfFour(n));
    }
}
