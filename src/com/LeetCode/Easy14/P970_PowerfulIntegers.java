package com.LeetCode.Easy14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P970_PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<>();
        for (int m = 1;m<=bound;m*=x){
            for (int n = 1; n <= bound; n *= y) {
                if(m+n<=bound)
                    seen.add(m + n);
                if (y==1) break;

            }
            if (x==1) break;
        }
        return new ArrayList<>(seen);
    }
}
