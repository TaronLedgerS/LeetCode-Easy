[TOC]

# LeetCode-Easy9-Top161_180

-   Problems-ID：589、590、594、595、596、 **597** 、598、599、 **603** 、 **604** 、605、606、 **607** 、 **610** 、 **613** 、617、 **619** 、620、 **624** 、627

## [589. N-ary Tree Preorder Traversal](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)

### ⭐题解（树-先序遍历、Stack、List）-2020年1月21日

```java
public class P589_N_aryTreePreorderTraversal {
    List<Integer> preOrderList = new ArrayList<>();
    //递归
    public List<Integer> preorder(Node root) {
        if (root == null  ) return preOrderList;
        preOrderList.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return preOrderList;
    }
    //循环
    public List<Integer> preorderI(Node root) {
        List<Integer> preOrderListI = new ArrayList<>();
        Stack<Node> toTraversal = new Stack<>();
        if (root ==null ) return preOrderListI;
        toTraversal.push(root);
        while (!toTraversal.empty()) {
            Node node = toTraversal.pop();
            preOrderListI.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size()-1;i>=0;i--) {
                    toTraversal.push(node.children.get(i));
                }
            }
        }
        return preOrderListI;
    }
    public static void main(String[] args) {
        System.out.println(
                new P589_N_aryTreePreorderTraversal().preorder(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
        System.out.println(
                new P589_N_aryTreePreorderTraversal().preorderI(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
    }
}
```

## [590. N-ary Tree Postorder Traversal](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)

### ⭐题解（树-后序遍历、Stack、List）-2020年1月22日

-   tips：中右左👉倒置即可得左右中（后序）

```java
public class P590_N_aryTreePostorderTraversal {
    //递归
    List<Integer> postOrderList = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root == null ) return postOrderList;
        if (root.children != null) {
            for (Node node : root.children) {
                postorder(node);
            }
        }
        postOrderList.add(root.val);
        return postOrderList;
    }

    //循环
    public List<Integer> postorderI(Node root) {
        List<Integer> postOrderListI = new ArrayList<>();
        if (root == null ) return postOrderListI;
        Stack<Node> toTraversal = new Stack<>();
        toTraversal.push(root);
        while (!toTraversal.empty()) {
            Node node = toTraversal.pop();
            postOrderListI.add(node.val);
            if (node.children != null) {
                for (Node tNode : node.children) {
                    toTraversal.push(tNode);
                }
            }
        }
        //列表倒置
        Collections.reverse(postOrderListI);
        return postOrderListI;
    }

    public static void main(String[] args) {
        System.out.println(
                new P590_N_aryTreePostorderTraversal().postorder(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
        System.out.println(
                new P590_N_aryTreePostorderTraversal().postorderI(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
    }
}
```

## [594. Longest Harmonious Subsequence](https://leetcode.com/problems/longest-harmonious-subsequence/)

### 题解（子序列、HashMap）-2020年1月23日

```java
public class P594_LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int num : nums) {
            dataMap.put(num, dataMap.getOrDefault(num, 0) + 1);
        }
        for (int key : dataMap.keySet()) {
            if (dataMap.containsKey(key + 1)) {
                res = Math.max(res, dataMap.get(key) + dataMap.get(key + 1));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P594_LongestHarmoniousSubsequence().findLHS(
                        new int[]{1,3,2,2,5,2,3,7}
                )
        );
    }
}
```

## [595. Big Countries](https://leetcode.com/problems/big-countries/)

### 题解（SQL）-2020年1月24日

```sql
Select name,population,area
From World
Where population>25000000 or area>3000000;
```

## [596. Classes More Than 5 Students](https://leetcode.com/problems/classes-more-than-5-students/)

### 题解（SQL-分类统计）-2020年1月25日

```sql
Select class
From courses
Group by class
having count(distinct student)>=5;
```

## [LOCKED UP]597. Friend Requests I: Overall Acceptance Rate

## [598. Range Addition II](https://leetcode.com/problems/range-addition-ii/)

### 题解（规律题，二维数组）-2020年1月26日

```java
public class P598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minCol * minRow;
    }
    public static void main(String[] args) {
        System.out.println(
                new P598_RangeAdditionII().maxCount(
                        3,3, new int[][]{{2,2},{3,3}}
                )
        );
    }
}
```

## [599. Minimum Index Sum of Two Lists](https://leetcode.com/problems/minimum-index-sum-of-two-lists/)

### 题解（字符串数组、字符串列表）-2020年1月27日

-   T-$O(n+m)$;S-$O(n)$

```java
public class P599_MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i< list1.length;i++)
            map.put(list1[i],i);
        int sum = list1.length + list2.length;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tsum = map.get(list2[i]) + i;
                if (tsum < sum) {
                    sum = tsum;
                    res.clear();
                    res.add(list2[i]);
                }else if (sum == tsum)
                    res.add(list2[i]);
            }
        }
        return res.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                    new P599_MinimumIndexSumofTwoLists().findRestaurant(
                            new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                            new String[]{"KFC","Burger King","Tapioca Express","Shogun"}
                    )
                )
        );
    }
}
```

## [LOCKED UP]603. Consecutive Available Seats

## [LOCKED UP]604. Design Compressed String Iterator

## [605. Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)

### 题解（线段题、边界条件）-2020年1月28日

```java
public class P605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
    public static void main(String[] args) {
        System.out.println(
                new P605_CanPlaceFlowers().canPlaceFlowers(
                        new int[]{1,0,0,0,1},1
                )
        );
    }
}
```

## [606. Construct String from Binary Tree](https://leetcode.com/problems/construct-string-from-binary-tree/)

### 题解（先序遍历、StringBuilder）-2020年1月29日

```java
public class P606_ConstructStringfromBinaryTree {
    StringBuilder treeStr = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t != null) {
            preorder(t);
        }
        return treeStr.toString();
    }
    private void preorder(TreeNode t) {
        if (t == null) {
            return;
        }
        treeStr.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }
        treeStr.append("(");
        if (t.left != null) {
            preorder(t.left);
        }
        treeStr.append(")");
        if ( t.right != null) {
            treeStr.append("(");
            preorder(t.right);
            treeStr.append(")");
        }
    }
    public static void main(String[] args) {
        System.out.println(
                new P606_ConstructStringfromBinaryTree().tree2str(
                        StringToTreeNode.stringToTreeNode("1,2,3,4")
                )
        );
    }
}
```

## [LOCKED UP]607. Sales Person

## [LOCKED UP]610. Triangle Judgement

## [LOCKED UP]613. Shortest Distance in a Line

## [617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)

### 题解（先序遍历）-2020年1月30日

```java
public class P617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null) return t2;
        if (t2==null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P617_MergeTwoBinaryTrees().mergeTrees(
                        StringToTreeNode.stringToTreeNode("1,2,3,4"),
                        StringToTreeNode.stringToTreeNode("1,2,3,null,4")
                )
        );
    }
}
```

## [LOCKED UP]619. Biggest Single Number

## [620. Not Boring Movies](https://leetcode.com/problems/not-boring-movies/)

### 题解（Sql-排除排序）-2020年1月31日

```sql
Select id,movie,description,rating
From cinema
Where description!="boring" and id%2=1
Order by rating desc;
```

## [LOCKED UP]624. Maximum Distance in Arrays

## [627. Swap Salary](https://leetcode.com/problems/swap-salary/)

### ⭐题解（Sql-Update批量修改单字符处理）-2020年2月1日

```SQL
#异或
update salary
set sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));
#循环作差
update salary
set sex = CHAR(ASCII('f') + ASCII('m') - ASCII(sex));
```
