package com.LeetCode.Easy6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> FizzBuzzList = new ArrayList<>();
        for (int i = 1;i<=n;i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                FizzBuzzList.add("FizzBuzz");
            } else if (i%3==0) {
                FizzBuzzList.add("Fizz");
            } else if (i % 5 == 0) {
                FizzBuzzList.add("Buzz");
            } else {
                FizzBuzzList.add(String.valueOf(i));
            }
        }
        return FizzBuzzList;
    }
    public static void main(String[] args) {
        P412_FizzBuzz test = new P412_FizzBuzz();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(test.fizzBuzz(n));
    }
}
