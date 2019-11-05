package com.LeetCode.Easy1;

import java.util.HashMap;

public class P13_RomanToIntegerTest {
    public static void main(String[] args){
        System.out.println("MCMXCIV:"+RomanToInteger.romanToInt("MCMXCIV"));
    }
}
class RomanToInteger {
    static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        //建立罗马数字映射表
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        //当较小的罗马数字位于前面（左边），则需要减去对饮数字，如IV为5-1；
        int result = map.get(s.charAt(len - 1));//初始化结果
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }
}