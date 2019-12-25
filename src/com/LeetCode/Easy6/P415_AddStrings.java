package com.LeetCode.Easy6;

import java.math.BigInteger;
import java.util.Scanner;

public class P415_AddStrings {
    public String addStrings1(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger result = a.add(b);
        return result.toString();
    }
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
            }
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        P415_AddStrings test = new P415_AddStrings();
        String num1 = s.nextLine();
        String num2 = s.nextLine();
        System.out.printf("%s,%s\n",num1,num2);
        System.out.println(test.addStrings1(num1,num2));
        System.out.println(test.addStrings(num1,num2));
    }
}
