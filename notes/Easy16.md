[TOC]

# LeetCode-Easy16-Top301_320

-   Problems-ID： **1068** 、 **1069** 、1071、 **1075** 、 **1076** 、 **1082** 、 **1083** 、 **1084** 、 **1085** 、 **1086** 、1089、 **1099** 、1103、1108、 **1113** 、1114、 **1118**、  **1119** 、1122

## [LOCKED UP]1068.	Product Sales Analysis I

## [LOCKED UP]1069.	Product Sales Analysis Ⅱ

## [1071. Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/)

### 题解（最大公约数，字符串）-2020年5月25日

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) return "";

        int GCDVal = getGCDVal(str1.length(), str2.length());

        return str1.substring(0, GCDVal);
    }


    private int getGCDVal(int p, int q) {
        if (q==0) return p;
        return getGCDVal(q, p % q);
    }
}
```

## [LOCKED UP]1075.	Project Employees I

## [LOCKED UP]1076.	Project Employees II

## [1078. Occurrences After Bigram](https://leetcode.com/problems/occurrences-after-bigram/)

### 题解-2020年5月26日

## [LOCKED UP]1082.	Sales Analysis I

## [LOCKED UP]1083.	Sales Analysis II

## [LOCKED UP]1084.	Sales Analysis III

## [LOCKED UP]1085.	Sum of Digits in the Minimum Number

## [LOCKED UP]1086.	High Five

## [1089. Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)

### 题解-2020年5月27日

## [LOCKED UP]1099.	Two Sum Less Than K

## [1103. Distribute Candies to People](https://leetcode.com/problems/distribute-candies-to-people/)

### 题解-2020年5月28日

## [1108. Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)

### 题解-2020年5月29日

## [LOCKED UP]1113.	Reported Posts

## [1114. Print in Order](https://leetcode.com/problems/print-in-order/)

### 题解-2020年5月30日

## [LOCKED UP]1118.	Number of Days in a Month

## [LOCKED UP]1119.	Remove Vowels from a String

## [1122. Relative Sort Array](https://leetcode.com/problems/relative-sort-array/)

### 题解-2020年5月31日
