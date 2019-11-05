package com.LeetCode.Easy3;

public class P171_ExcelSheetColumnNumberTest {
    public static void main(String[] args) {
        String s = "AB";
        ExcelSheetColumnNumber temp = new ExcelSheetColumnNumber();
        System.out.println(temp.titleToNumber(s));
    }
}

class ExcelSheetColumnNumber{
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0;i<s.length();i++){
            result = result*26 +(s.charAt(i)-'A'+1);
        }
        return result;
    }
}
