package com.LeetCode.Easy2;

public class P168_ExcelSheetColumnTitleTest {
    public static void main(String[] args) {
     ExcelSheetColumnTitle temp = new ExcelSheetColumnTitle();
      System.out.println(temp.convertToTitle(701));
    }
}

class ExcelSheetColumnTitle{
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}