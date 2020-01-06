[TOC]

# LeetCode-Easy8-Top141_160

-   Problems-ID：520、521、530、532、538、541、543、551、557、558、559、561、563、566、572、575、 **577** 、581、 **584** 、 **586**

## [520. Detect Capital](https://leetcode.com/problems/detect-capital/)

### ⭐题解（字符串-正则表达式）-2020年1月4日

-   [java正则表达式](https://www.runoob.com/java/java-regular-expressions.html)
-   `String.matches()` 这个方法主要是返回是否匹配指定的字符串
-   单词的正确大小写匹配

```java
public class P520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        //?零次或一次匹配前面的字符或子表达式;
        //+一次或多次匹配前面的字符或子表达式
        //*零次或多次匹配前面的字符或子表达式
        return word.matches("[A-Z]+|[A-Z]?[a-z]+");
    }
    public static void main(String[] args) {
        System.out.println(new P520_DetectCapital().detectCapitalUse("Google"));
    }
}
```

## [521. Longest Uncommon Subsequence I](https://leetcode.com/problems/longest-uncommon-subsequence-i/)

### 题解（字符串）-2020年1月5日

```java
public class P521_LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
    public static void main(String[] args) {
        System.out.println(new P521_LongestUncommonSubsequenceI().findLUSlength("abc","bcd"));
    }
}
```

## [530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

### 题解（二叉搜索树）-2020年1月6日

## [532. K-diff Pairs in an Array](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

### 题解-2020年1月7日

## [538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/)

### 题解-2020年1月8日

## [541. Reverse String II](https://leetcode.com/problems/reverse-string-ii/)

### 题解-2020年1月9日

## [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

### 题解-2020年1月10日

## [551. Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)

### 题解-2020年1月11日

## [557. Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)

### 题解-2020年1月12日

## [558. Quad Tree Intersection](https://leetcode.com/problems/quad-tree-intersection/)

### 题解-2020年1月13日

## [559. Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)

### 题解-2020年1月14日

## [561. Array Partition I](https://leetcode.com/problems/array-partition-i/)

### 题解-2020年1月15日

## [563. Binary Tree Tilt](https://leetcode.com/problems/binary-tree-tilt/)

### 题解-2020年1月16日

## [566. Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/)

### 题解-2020年1月17日

## [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)

### 题解-2020年1月18日

## [575. Distribute Candies](https://leetcode.com/problems/distribute-candies/)

### 题解-2020年1月19日

## [LOCKED UP]577. Employee Bonus

## [581. Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)

### 题解-2020年1月20日

## [LOCKED UP]584. Find Customer Referee

## [LOCKED UP]586. Customer Placing the Largest Number of Orders
