[TOC]

# LeetCode-Easy14-Top261_280

-   Problems-ID：925、929、933、937、938、941、942、944、949、953、961、965、970、976、977、985、989、993、994、997

## [925. Long Pressed Name](https://leetcode.com/problems/long-pressed-name/)

### 题解（字符串）-2020年4月17日

```java
public class P925_LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;
            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;
                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;
                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }
            j++;
        }
        return true;
    }
}
```

## [929. Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)

### 题解（）-2020年4月18日

## [933. Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)

### 题解（）-2020年4月19日

## [937. Reorder Data in Log Files](https://leetcode.com/problems/reorder-data-in-log-files/)

### 题解（）-2020年4月20日

## [938. Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/)

### 题解（）-2020年4月21日

## [941. Valid Mountain Array](https://leetcode.com/problems/valid-mountain-array/)

### 题解（）-2020年4月22日

## [942. DI String Match](https://leetcode.com/problems/di-string-match/)

### 题解（）-2020年4月23日

## [944. Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/)

### 题解（）-2020年4月24日

## [949. Largest Time for Given Digits](https://leetcode.com/problems/largest-time-for-given-digits/)

### 题解（）-2020年4月25日

## [953. Verifying an Alien Dictionary](https://leetcode.com/problems/verifying-an-alien-dictionary/)

### 题解（）-2020年4月26日

## [961. N-Repeated Element in Size 2N Array](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/)

### 题解（）-2020年4月27日

## [965. Univalued Binary Tree](https://leetcode.com/problems/univalued-binary-tree/)

### 题解（）-2020年4月28日

## [970. Powerful Integers](https://leetcode.com/problems/powerful-integers/)

### 题解（）-2020年4月29日

## [976. Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)

### 题解（）-2020年4月30日

## [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)

### 题解（）-2020年5月1日

## [985. Sum of Even Numbers After Queries](https://leetcode.com/problems/sum-of-even-numbers-after-queries/)

### 题解（）-2020年5月2日

## [989. Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/)

### 题解（）-2020年5月3日

## [993. Cousins in Binary Tree](https://leetcode.com/problems/cousins-in-binary-tree/)

### 题解（）-2020年5月4日

## [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)

### 题解（）-2020年5月5日

## [997. Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)

### 题解（）-2020年5月6日
