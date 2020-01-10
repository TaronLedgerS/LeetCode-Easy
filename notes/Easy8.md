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

### 题解（二叉搜索树遍历）-2020年1月6日

-   找二叉排序树中的元素最小差值：即中序遍历后相邻元素的最小差值

```java
public class P530_MinimumAbsoluteDifferenceinBST {
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftmin = getMinimumDifference(root.left);
        int min = leftmin;
        if(pre!=-1) {
            min=Math.min(leftmin, root.val - pre);
        }
        pre = root.val;
        int rightmin = getMinimumDifference(root.right);
        min = Math.min(min, rightmin);
        return min;
    }
    public static void main(String[] args) {
        System.out.println(new P530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(
                StringToTreeNode.stringToTreeNode("1,null,5,3")
        ));
    }
}
```

## [532. K-diff Pairs in an Array](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

### ⭐题解（哈希建表）-2020年1月7日

-   法一、二分查找：去重排序，逐个枚举，在剩余中二分查找是否存在差值k的结果`math O(NlogN)`
-   法二、建立哈希表：逐个枚举（`math O(N)`）、查询+k的值（`math O(1)`）

```java
public class P532_KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        //临界判断
        if (nums ==null||nums.length==0||k<0) return 0;
        int count = 0;
        //建立哈希表
        Map<Integer, Integer> countMap = new HashMap<>();//<元素，出现次数>
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        //统计
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (k == 0) {//距离为0，即重复元素
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (countMap.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new P532_KdiffPairsinanArray().findPairs(
                new int[]{1,2,3,4,5},1
        ));
    }
}
```

## [538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/)

### 题解（二叉排序树-后序遍历）-2020年1月8日

```java
public class P538_ConvertBSTtoGreaterTree {
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }
    public static void main(String[] args) {
        System.out.println(new P538_ConvertBSTtoGreaterTree().convertBST(
                StringToTreeNode.stringToTreeNode("5,2,13")
        ));
    }
}
```

## [541. Reverse String II](https://leetcode.com/problems/reverse-string-ii/)

### 题解（字符串处理）-2020年1月9日

```java
public class P541_ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int j = i;
            int l = Math.min(chars.length, j + k)-1;
            //颠倒j到l
            while (j < l) {
                char tmp = chars[j];
                chars[j] = chars[l];
                chars[l] = tmp;
                j++;l--;
            }
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        System.out.println(
                new P541_ReverseStringII().reverseStr("abcdefg",2)
        );
    }
}
```

## [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

### ⭐题解（二叉树最长路径）-2020年1月10日

-   路径指的是任意两个节点之间路径的边数量

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
