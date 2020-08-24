package com.LeetCode.Easy21;

import java.util.ArrayList;
import java.util.List;

public class P1441_BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i=1;i<=n && j<target.length;i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}
