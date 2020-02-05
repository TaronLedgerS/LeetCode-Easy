[TOC]

# LeetCode-Easy10-Top181_200

-   Problems-ID：628、633、637、643、645、653、657、661、665、669、671、674、680、682、686、687、690、693、696、697

## [628. Maximum Product of Three Numbers](https://leetcode.com/problems/maximum-product-of-three-numbers/)

### 题解（数学题）-2020年2月2日

-   三个数字乘积最大，T-$O(n)$

```java
public class P628_MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
    public static void main(String[] args) {
        System.out.println(
                new P628_MaximumProductofThreeNumbers().maximumProduct(new int[]{
                        -1,-2,-3,-4
                })
        );
    }
}
```

## [633. Sum of Square Numbers](https://leetcode.com/problems/sum-of-square-numbers/)

### 题解（数学-开方平方）-2020年2月3日

-   循环T-$O(n)$，二分查找答案`c-i*i`则T-$O(lgn)$
-   HashSet的查找是通过HashMap的KeySet来实现的，判断是否包含某个元素的实现，时间复杂度是O（1）

```java
public class P633_SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squareSet = new HashSet<>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            squareSet.add(i * i);
            if (squareSet.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(
                new P633_SumofSquareNumbers().judgeSquareSum(5)
        );
    }
}
```

## [637. Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

### 题解（二叉树，BFS，DFS）-2020年2月4日

```Java
public class P637_AverageofLevelsinBinaryTree {
    List<Double> sumofEachLevel = new ArrayList<>();
    List<Integer> countofEachLevel = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        preorderTraversal(root, 0);
        for (int i = 0; i < sumofEachLevel.size(); i++) {
            sumofEachLevel.set(i, sumofEachLevel.get(i) / countofEachLevel.get(i));
        }
        return sumofEachLevel;
    }
    //DFS
    private void preorderTraversal(TreeNode root, int i) {
        if (root==null) return;
        if (sumofEachLevel.size() < i + 1) {
            sumofEachLevel.add(0.0);
            countofEachLevel.add(0);
        }
        sumofEachLevel.set(i, sumofEachLevel.get(i) + root.val);
        countofEachLevel.set(i, countofEachLevel.get(i) + 1);

        preorderTraversal(root.left, i + 1);
        preorderTraversal(root.right, i + 1);
    }
    //BFS
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new P637_AverageofLevelsinBinaryTree().averageOfLevels(
                        StringToTreeNode.stringToTreeNode("1,2,3,4,5")
                )
        );
    }
}
```

## [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

### 题解（最大定长字串）-2020年2月5日

-   区间和

```Java
public class P643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1]+nums[i - 1];
        }
        double maxAns = Integer.MIN_VALUE;
        for (int i = k ; i < sum.length; i++) {
            maxAns = Math.max(maxAns, sum[i]-sum[i-k]);
        }
        return maxAns/k;
    }
    public static void main(String[] args) {
        System.out.println(
                new P643_MaximumAverageSubarrayI().findMaxAverage(
                        new int[]{1,12,-5,-6,50,3},4
                )
        );
    }
}
```

## [645. Set Mismatch](https://leetcode.com/problems/set-mismatch/)

### 题解（数组，差单个缺，单重）-2020年2月6日

```Java
public class P645_SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length];
        int[] res = new int[2];
        for (int num : nums) {
            count[num - 1]++;
            if (count[num - 1] == 2) {
                res[0] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new P645_SetMismatch().findErrorNums(
                                new int[]{1, 2, 2, 4, 5}
                        )
                )
        );
    }
}
```

## [653. Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)

### 题解（）-2020年2月7日

## [657. Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)

### 题解（）-2020年2月8日

## [661. Image Smoother](https://leetcode.com/problems/image-smoother/)

### 题解（）-2020年2月9日

## [665. Non-decreasing Array](https://leetcode.com/problems/non-decreasing-array/)

### 题解（）-2020年2月10日

## [669. Trim a Binary Search Tree](https://leetcode.com/problems/trim-a-binary-search-tree/)

### 题解（）-2020年2月11日

## [671. Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)

### 题解（）-2020年2月12日

## [674. Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)

### 题解（）-2020年2月13日

## [680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

### 题解（）-2020年2月14日

## [682. Baseball Game](https://leetcode.com/problems/baseball-game/)

### 题解（）-2020年2月15日

## [686. Repeated String Match](https://leetcode.com/problems/repeated-string-match/)

### 题解（）-2020年2月16日

## [687. Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/)

### 题解（）-2020年2月17日

## [690. Employee Importance](https://leetcode.com/problems/employee-importance/)

### 题解（）-2020年2月18日

## [693. Binary Number with Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits/)

### 题解（）-2020年2月19日

## [696. Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)

### 题解（）-2020年2月20日

## [697. Degree of an Array](https://leetcode.com/problems/degree-of-an-array/)

### 题解（）-2020年2月21日
