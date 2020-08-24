package com.LeetCode.Easy21;

import java.util.HashSet;
import java.util.Set;

public class P1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set = new HashSet();
        set.add(x + "$" + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            String key = x + "$" + y;
            if (set.contains(key))
                return true;
            set.add(key);
        }
        return false;
    }
}
