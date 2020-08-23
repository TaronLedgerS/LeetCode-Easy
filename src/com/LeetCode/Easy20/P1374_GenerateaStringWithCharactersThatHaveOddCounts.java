package com.LeetCode.Easy20;

import java.util.Arrays;

public class P1374_GenerateaStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        char[] str = new char[n];
        Arrays.fill(str, 'a');
        if(n%2==0) {
            str[0] = 'b';
        }
        return new String(str);
    }

}
