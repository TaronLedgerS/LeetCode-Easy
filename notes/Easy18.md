[TOC]

# LeetCode-Easy18-Top341_360

-   Problems-ID：1207、 **1211** 、 **1213** 、1217、1221、 **1228** 、1232、1237、 **1241** 、 **1243** 、 **1251** 、1252、1260、1266、 **1271** 、1275、 **1279** 、 **1280** 、1281、1287

## [1207. Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)

### 题解-2020年6月12日

```java
public class P1207_UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //array to store number of occurances
        int[] c = new int[2001];
        //count occurance of each value
        for (int n : arr) {
            c[n+1000]++;
        }
        //check unique occurances (except for 0)
        Set<Integer> set = new HashSet();
        for (int count : c) {
            if (count == 0)
                continue;
            if (!set.add(count))
                return false;
        }
        return true;
    }
}
```

## [LOCKED UP]1211.	Queries Quality and Percentage

## [LOCKED UP]1213.	Intersection of Three Sorted Arrays

## [1217. Play with Chips](https://leetcode.com/problems/play-with-chips/)

### 题解-2020年6月13日

```java
public class P1217_PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        int[] cnt = new int[2];
        for (int chip : chips)
            ++cnt[chip % 2];
        return Math.min(cnt[0], cnt[1]);
    }
}
```

## [1221. Split a String in Balanced Strings](https://leetcode.com/problems/split-a-string-in-balanced-strings/)

### 题解-2020年6月14日

```java
public class P1221_SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }
}
```

## [LOCKED UP]1228.	Missing Number In Arithmetic Progression

## [1232. Check If It Is a Straight Line](https://leetcode.com/problems/check-if-it-is-a-straight-line/)

### 题解-2020年6月15日

## [1237. Find Positive Integer Solution for a Given Equation](https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/)

### 题解-2020年6月16日

## [LOCKED UP]1241.	Number of Comments per Post

## [LOCKED UP]1243.	Array Transformation

## [LOCKED UP]1251.	Average Selling Price

## [1252. Cells with Odd Values in a Matrix](https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/)

### 题解-2020年6月17日

## [1260. Shift 2D Grid](https://leetcode.com/problems/shift-2d-grid/)

### 题解-2020年6月18日

## [1266. Minimum Time Visiting All Points](https://leetcode.com/problems/minimum-time-visiting-all-points/)

### 题解-2020年6月19日

## [LOCKED UP]1271.	Hexspeak

## [1275. Find Winner on a Tic Tac Toe Game](https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/)

### 题解-2020年6月20日

## [LOCKED UP]1279.	Traffic Light Controlled Intersection

## [LOCKED UP]1280.	Students and Examinations

## [1281. Subtract the Product and Sum of Digits of an Integer](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)

### 题解-2020年6月21日

## [1287. Element Appearing More Than 25% In Sorted Array](https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/)

### 题解-2020年6月22日

## [1290. Convert Binary Number in a Linked List to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)

### 题解-2020年6月23日
