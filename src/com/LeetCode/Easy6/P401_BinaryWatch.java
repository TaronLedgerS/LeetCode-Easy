package com.LeetCode.Easy6;


import java.util.ArrayList;
import java.util.List;

public class P401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return times;
    }
    public static void main(String[] args) {
        P401_BinaryWatch test = new P401_BinaryWatch();
        List<String> times = test.readBinaryWatch(1);
        for (String temp : times) {
            System.out.println(temp);
        }
    }
}
