[TOC]

# LeetCode-Easy9-Top201_220

-   Problems-ID：700、703、704、705、706、709、 **716** 、717、720、724、728、733、 **734** 、744、746、747、748、 **751** 、 **758** 、 **760**

## [700. Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)

### 题解（BST）-2020年2月22日

-   搜索树查找--循环

```java
public class P700_SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        System.out.println(
                new P700_SearchinaBinarySearchTree().searchBST(
                        StringToTreeNode.stringToTreeNode("4,2,7,1,3"),5
                )
        );
    }
}
```

## [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

### ⭐题解（PriorityQueue）-2020年2月23日

```java
public class P703_KthLargestElementinaStream {
    final PriorityQueue<Integer> kthLargestQueue;
    final int k;
    public P703_KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        kthLargestQueue = new PriorityQueue<>(k);
        for (int n:nums)
            add(n);
    }
    public int add(int val) {
        kthLargestQueue.offer(val);
        if (kthLargestQueue.size() > k) {
            kthLargestQueue.poll();
        }
        return kthLargestQueue.peek();
    }
    public static void main(String[] args) {
        P703_KthLargestElementinaStream temp = new P703_KthLargestElementinaStream(3,new int[]{4,5,8,2});
        System.out.println(temp.add(3));
        System.out.println(temp.add(5));
        System.out.println(temp.add(10));
        System.out.println(temp.add(9));
        System.out.println(temp.add(4));

    }
}
```

## [704. Binary Search](https://leetcode.com/problems/binary-search/)

### 题解（二分查找）-2020年2月24日

```java
public class P704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while (l <= r) {//不能<
            int m = (l+r)/2;
            if (nums[m]==target) return m;
            if (nums[m]>target) r = m-1;
            if (nums[m]<target) l =l+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P704_BinarySearch().search(new int[]{-1,0,3,5,9,12},9)
                        +" | "+
                new P704_BinarySearch().search(new int[]{-1,0,3,5,9,12},7)
                        +" | "+
                new P704_BinarySearch().search(new int[]{-1},-1)
        );
    }
}
```

## [705. Design HashSet](https://leetcode.com/problems/design-hashset/)

### ⭐题解（实现HashSet）-2020年2月25日

-   [HashSet源码分析（基于JDK8）](https://blog.csdn.net/fighterandknight/article/details/66585997)
-   HashSet而言，它是基于HashMap实现的，HashSet底层使用HashMap来保存所有元素，因此HashSet 的实现比较简单

## [706. Design HashMap](https://leetcode.com/problems/design-hashmap/)

### ⭐题解（实现HashMap）-2020年2月26日

-   [HashMap源码分析（基于JDK8）](https://blog.csdn.net/fighterandknight/article/details/61624150)

## [709. To Lower Case](https://leetcode.com/problems/to-lower-case/)

### 题解（实现字符串大小写）-2020年2月27日

```java
public class P709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A'&&(chars[i]<='Z'))
                chars[i] = (char)(chars[i]-'A' +'a');
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        System.out.println(
                new P709_ToLowerCase().toLowerCase("Hello")
        );
    }
}
```

## [LOCKED UP]716.	Max Stack

## [717. 1-bit and 2-bit Characters](https://leetcode.com/problems/1-bit-and-2-bit-characters/)

### 题解（）-2020年2月28日

## [720. Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)

### 题解（）-2020年2月29日

## [724. Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

### 题解（）-2020年3月1日

## [728. Self Dividing Numbers](https://leetcode.com/problems/self-dividing-numbers/)

### 题解（）-2020年3月2日

## [733. Flood Fill](https://leetcode.com/problems/flood-fill/)

### 题解（）-2020年3月3日

## [LOCKED UP]734.	Sentence Similarity

## [744. Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

### 题解（）-2020年3月4日

## [746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### 题解（）-2020年3月5日

## [747. Largest Number At Least Twice of Others](https://leetcode.com/problems/largest-number-at-least-twice-of-others/)

### 题解（）-2020年3月6日

## [748. Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)

### 题解（）-2020年3月7日

## [LOCKED UP]751.	IP to CIDR

## [LOCKED UP]758.	Bold Words in String

## [LOCKED UP]760.	Find Anagram Mappings
