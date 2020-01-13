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
-   最长路径必然是叶子节点到另一个叶子节点的路径最大，即使根节点的左右子树的高度之和减二最大
-   采用后序遍历

```java
public class P543_DiameterofBinaryTree {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getTreeHeight(root);
        return longest;
    }
    public int getTreeHeight(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left) + 1;
        int rightHeight = getTreeHeight(root.right) + 1;
        longest = Math.max(longest, leftHeight+rightHeight-2);
        return Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        System.out.println(
                new P543_DiameterofBinaryTree().diameterOfBinaryTree(
                        StringToTreeNode.stringToTreeNode("1,2,3,4,5,null,null,6")
                )
        );
    }
}
```

## [551. Student Attendance Record I](https://leetcode.com/problems/student-attendance-record-i/)

### ⭐题解（正则表达式）-2020年1月11日

-   PAL三个字母构成字符串：①匹配至少两个A ②匹配至少三个连续的L
-   [正则表达式在线测试](https://www.sojson.com/regex/)

```java
public class P551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        //.匹配除"\r\n"之外的任何单个字符
        //[xyz]字符集
        //?零次或一次匹配前面的字符或子表达式，如10? 有1、10
        //+一次或多次匹配前面的字符或子表达式，如10+ 有10、100、1000等等
        //*零次或多次匹配前面的字符或子表达式，如10* 有1、10、100、1000等等
        return !s.matches("[PAL]*LLL[PAL]*|[PAL]*A[PAL]*A[PAL]*");
    }
    public static void main(String[] args) {
        System.out.println(
                new P551_StudentAttendanceRecordI().checkRecord("PPALLL")
        );
    }
}
```

## [557. Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)

### ⭐题解（字符串处理）-2020年1月12日

-   字符串翻转

```java
/*
 * 字符串反转的两种方法
 */
public class TestReverse {
	public static void main(String[] args) {
		String str = "Hello";
		str1 = new StringBuffer(str).reverse().toString();
		System.out.println(str1);

		StringBuilder rev = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
			rev.append(str.charAt(i));
		System.out.println(rev.toString());

	}
}
```

```java
public class P557_ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(
                    new StringBuilder(str).reverse().toString()
            );
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(
                new P557_ReverseWordsinaStringIII().reverseWords(
                        "Let's take LeetCode contest"
                )
        );
    }
}
```

## [558. Quad Tree Intersection](https://leetcode.com/problems/quad-tree-intersection/)

### 题解-2020年1月13日

```java
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
                if (quadTree1.isLeaf) {
            return quadTree1.val?quadTree1:quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val?quadTree2:quadTree1;
        }
        quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf
                && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf
                && quadTree1.topLeft.val == quadTree1.topRight.val
                && quadTree1.topRight.val == quadTree1.bottomLeft.val
                && quadTree1.bottomLeft.val == quadTree1.bottomRight.val) {
            quadTree1.isLeaf = true;
            quadTree1.val = quadTree1.topLeft.val;
        }
        return quadTree1;

    }
}
```

## [559. Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)

### ⭐题解（不规则树结构，DFS，BFS）-2020年1月14日

-   [java Queue中 add/offer，element/peek，remove/poll区别](https://blog.csdn.net/u012050154/article/details/60572567)

```java
public class P559_MaximumDepthofN_aryTree {
    //DFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth=0;
        if (root.children!=null) {
            for (Node node : root.children) {
                maxDepth = Math.max(maxDepth, maxDepth(node));
            }
        }
        return maxDepth+1;
    }
    //BFS
    public int maxDepth_BFS(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            level++;
            int size= queue.size();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                assert curr != null;
                if (curr.children!=null) {
                    queue.addAll(curr.children);
                }

            }
        }
        return level;
    }
    public static void main(String[] args) {
        System.out.println(
                new P559_MaximumDepthofN_aryTree().maxDepth(
                        Node.stringToTreeNode(
                                "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14"
                        )
                )
        );
        System.out.println(
                new P559_MaximumDepthofN_aryTree().maxDepth_BFS(
                        Node.stringToTreeNode(
                                "1,null,3,2,4,null,5,6"
                        )
                )
        );

    }
}
```

```java
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    //1,null,
    //2,3,4,5,null,
    //null,6,7,null,8,null,9,10,null,
    //null,11,null,12,null,13,null,null,
    //14
    //null子节点列表结束（或为无子节点）
    public static Node stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
        String[] nodes = input.split(",");
        //取出根节点，并放入待建子树根节点列表
        int index = 0;
        String item = nodes[index++];
        index++;//根节点后必然跟一个null
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        //循环建树
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            //检查输入是否为空
            if (index == nodes.length) {
                break;
            }
            item = nodes[index++];
            item = item.trim();
            List<Node> _children =new ArrayList<>();
            while (!item.equals("null")) {
                int _val = Integer.parseInt(item);
                Node _node = new Node(_val);
                _children.add(_node);
                nodeQueue.add(_node);
                if (index == nodes.length) {
                    break;
                }
                item = nodes[index++];
                item = item.trim();
            }
            node.children=_children;
        }
        return root;
    }
};
```

## [561. Array Partition I](https://leetcode.com/problems/array-partition-i/)

### 题解-2020年1月15日

```java
public class P561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length/2; i++) {
            sum += nums[2*i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new P561_ArrayPartitionI().arrayPairSum(
                        new int[]{1,4,3,2,5,6}
                )
        );
    }
}
```

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
