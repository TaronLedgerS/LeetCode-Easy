package com.LeetCode.Easy6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P434_NumberofSegmentsinaString {
    public int countSegments(String s) {
        String trimmed = s.trim();//去除头尾空格
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        P434_NumberofSegmentsinaString test = new P434_NumberofSegmentsinaString();
        while ((line = in.readLine()) != null) {
            System.out.println(test.countSegments(line));
        }
    }
}
