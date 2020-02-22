[TOC]

# LeetCode-Easy13-Top241_260

-   Problems-ID：852、859、860、867、868、872、874、876、883、884、888、892、893、896、905、908、914、922

## [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

### ★题解（二分找中间峰值）-2020年3月28日

```java
public class P852_PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int r = A.length-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (A[m]<A[m+1])
                l = m+1;
            else
                r = m;
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println(
                new P852_PeakIndexinaMountainArray().peakIndexInMountainArray(
                        new int[]{0,2,1,0}
                )
        );
    }
}
```

## [859. Buddy Strings](https://leetcode.com/problems/buddy-strings/)

### 题解（字符串）-2020年3月29日

```java
public class P859_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;
            for (int c: count)
                if (c > 1) return true;
            return false;
        }
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (firstIndex == -1)
                    firstIndex = i;
                else if (secondIndex == -1 )
                    secondIndex = i;
                else
                    return false;
            }
        }
        return  secondIndex!=-1&&A.charAt(firstIndex)==B.charAt(secondIndex) && A.charAt(secondIndex)==B.charAt(firstIndex);
    }
    public static void main(String[] args) {
        System.out.println(
                new P859_BuddyStrings().buddyStrings("aaaaaa", "aaaaaa")
        );
    }
}
```

## [860. Lemonade Change](https://leetcode.com/problems/lemonade-change/)

### 题解（模拟题）-2020年3月30日

```java
public class P860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill==5) five++;
            if (bill==10){
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                }else
                    five = five-3;
            }
            if (five<0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P860_LemonadeChange().lemonadeChange(new int[]{5,5,5,10,20})
        );
    }
}
```

## [867. Transpose Matrix](https://leetcode.com/problems/transpose-matrix/)

### 题解（矩阵转置）-2020年3月31日

```java
public class P867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int n = A.length,m = A[0].length;
        int[][] B = new int[m][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++)
                B[j][i] = A[i][j];
        }
        return B;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                    new P867_TransposeMatrix().transpose(new  int[][]{{1,2,3},{4,5,6}})
                ));
    }
}
```

## [868. Binary Gap](https://leetcode.com/problems/binary-gap/)

### 题解（二进制）-2020年4月1日

```java
public class P868_BinaryGap {
    public int binaryGap(int N) {
        int gap,maxGap=0;
        int lastOne  = -1;
        while (N>0){
            if (N%2 == 1) {
                gap = lastOne +1;
                maxGap = Math.max(maxGap, gap);
                lastOne = 0;
            }
            if (N%2 == 0) {
                if (lastOne!=-1)
                    lastOne++;
            }
            N=N/2;
        }
        return maxGap;
    }
    public static void main(String[] args) {
        System.out.println(
                new P868_BinaryGap().binaryGap(11)
        );
    }
}
```

## [872. Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)

### 题解（树，递归）-2020年4月2日

```java
public class P872_Leaf_SimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        if (leaf1.size() != leaf2.size())
            return false;
        for (int i = 0; i < leaf1.size();i++) {
            if (!leaf1.get(i).equals(leaf2.get(i)))
                return false;
        }
        return true;
    }
    private void dfs(TreeNode root, List<Integer> leaf) {
        if (root.left!=null) dfs(root.left, leaf);
        if (root.right!=null) dfs(root.right, leaf);
        if (root.left==null&&root.right==null) leaf.add(root.val);
    }
    public static void main(String[] args) {
        System.out.println(
                new P872_Leaf_SimilarTrees().leafSimilar(
                        StringToTreeNode.stringToTreeNode("3,5,1,6,2,9,2,null,null,7,4"),
                        StringToTreeNode.stringToTreeNode("3,5,1,2,4,9,2,6,7")
                )
        );
    }
}
```

## [874. Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/)

### 题解（）-2020年4月3日

## [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

### 题解（）-2020年4月4日

## [883. Projection Area of 3D Shapes](https://leetcode.com/problems/projection-area-of-3d-shapes/)

### 题解（）-2020年4月5日

## [884. Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)

### 题解（）-2020年4月6日

## [888. Fair Candy Swap](https://leetcode.com/problems/fair-candy-swap/)

### 题解（）-2020年4月7日

## [892. Surface Area of 3D Shapes](https://leetcode.com/problems/surface-area-of-3d-shapes/)

### 题解（）-2020年4月8日

## [893. Groups of Special-Equivalent Strings](https://leetcode.com/problems/groups-of-special-equivalent-strings/)

### 题解（）-2020年4月9日

## [896. Monotonic Array](https://leetcode.com/problems/monotonic-array)

### 题解（）-2020年4月10日

## [897. Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree)

### 题解（）-2020年4月11日

## [905. Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)

### 题解（）-2020年4月12日

## [908. Smallest Range I](https://leetcode.com/problems/smallest-range-i/)

### 题解（）-2020年4月13日

## [914. X of a Kind in a Deck of Cards](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/)

### 题解（）-2020年4月14日

## [917. Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/)

### 题解（）-2020年4月15日

## [922. Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)

### 题解（）-2020年4月16日
