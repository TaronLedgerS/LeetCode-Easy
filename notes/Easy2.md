[TOC]

# LeetCode-Easy2-Top21_40

-   Problems-ID:100、101、104、107、108、110、111、112、118、119、121、122、125、136、141、155、160、167、168

## [100.Same Tree](https://leetcode.com/problems/same-tree/description/)

### 题解-2018年10月16日

-   递归比较二叉树是否相等，但此处不需要输入处理，不需要自己构建二叉树相对简单

```Java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}
```

## [101.Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/)

### 题解-2018年10月17日

-   对称二叉树

```code
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

-   两个引用递归解法，比较：时间复杂度空间复杂度都是位`math O(n)`

```Java
class SymmetricTree {
    boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private  boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
```

## [104.Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)

### 题解-2018年10月18日

-   计算二叉树的深度

#### 法一：深度优先搜索DFS

-   递归解法时间复杂度为`math O(n)`

```Java
class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int left_height = maxDepth(root.left);
      int right_height = maxDepth(root.right);
      return java.lang.Math.max(left_height, right_height) + 1;
    }
  }
}
```

#### 法二：宽度度优先搜索BFS

-   队列，循环解法时间复杂度为`math O(n)`

```Java
import javafx.util.Pair;//Java 8版本才有
import java.lang.Math;

class Solution {
	public int maxDepthBFS(TreeNode root) {
	  LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
	  if (root != null) {
		  queue.add(new Pair(root, 1));
	  }
	  int depth = 0;
	  while (!queue.isEmpty()) {
		  Pair<TreeNode, Integer> current = queue.pollLast();
		  root = current.getKey();
		  int current_depth = current.getValue();
		  if (root != null) {
			  depth = Math.max(depth, current_depth);
			  queue.add(new Pair(root.left, current_depth + 1));
			  queue.add(new Pair(root.right, current_depth + 1));
		  }
	  }
	  return depth;
  }
};
```

## [107.Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)

### 题解-2018年10月19日

-   从叶子到根，逐层输出权值
-   BFS算法，用Queue

```Java
class BinaryTreeLevelOrderTraversalII{
    List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode tnode = q.poll();
                if (tnode!=null) {
                    list.add(tnode.val);
                    if(tnode.left!=null) q.add(tnode.left);
                    if(tnode.right!=null) q.add(tnode.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }
}
```

## [108.Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/)

### 题解-2018年10月20日

-   有序数组，递归构造排序二叉树

```Java
class ConvertSortedArraytoBinarySearchTree {
    TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return  helper(num, 0, num.length - 1);
    }
     private  TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
```

## [110.Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/description/)

### 题解-2018年10月21日

-   给定二叉树，判断是否为平衡二叉树

```Java
class BalancedBinaryTree {
    private boolean result = true;

    boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }
}
```

## [111.Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)

### 题解-2018年10月22日

-   找根到叶子节点的最短路径，用BFS

```Java
public int minDepth(TreeNode root) {
    if(root == null) return 0;
    List<TreeNode> list = new LinkedList<>();
    list.add(root);
    int level = 1;
    while(!list.isEmpty()){
        int len = list.size();
        for(int i = 0;i<len;i++){
            TreeNode node = list.remove(0);
            if(node.left == null && node.right == null) return level;
            if(node.left != null) list.add(node.left);
            if(node.right != null) list.add(node.right);
        }
        level++;
    }
    return 0;// Will never reach this line;
}
```

## [112.Path Sum](https://leetcode.com/problems/path-sum/description/)

### 题解-2018年10月23日

-   给定一个整数sum，判断是否存在路径长度为sum的从根到叶子节点的路径
-   递归DFS、队列bfs也是可以的，遍历一遍即可

```java
class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return (root.val == sum);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
```

## [118.Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/description/)

### 题解-2018年10月24日

-   输入整数，返回Pascal Triangle

```code
	Input: 5
	Output:
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
```

-   使用DP算法

```java
class PascalTriangle {
     List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            //边界都为1
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            //边界都为1
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
```

## [119.Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/description/)

### 题解-2018年10月25日

-   上题中改成只要一列，要求空间复杂度改为`math O(k)`

```java
class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
```

## [121.Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

### 题解-2018年10月26日

-   已知股票的每天股价，买入卖出一次可获得的最大收益，不做亏本生意

#### 法一：动态规划

-   此题可以转化为最大子段和问题：相邻整数作差，如[7,1,5,3,6,4]得[-6,4,-2,3,-2],剩下操作如53.Maximum Subarray即可

#### 法二：贪心算法

-   一次循环，维护两个值，最小值以及最大收益

```Java
class BestTimetoBuyandSellStock {
   public int maxProfit(int prices[]) {
	   int minprice = Integer.MAX_VALUE;
	   int maxprofit = 0;
	   for(int i = 0; i < prices.length; i++) {
		   if (prices[i] < minprice)
			   minprice = prices[i];
		   else if (prices[i] - minprice > maxprofit)
			   maxprofit = prices[i] - minprice;
	   }
	   return maxprofit;
   }
}
```

## [122.Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

### 题解-2018年10月27日

-   在上一题基础上可以进行多次买卖，贪心算法，构造差值数列如[7,1,5,3,6,4]得[-6,4,-2,3,-2]，将大于零得元素相加即可

```Java
public int maxProfit(int prices[]) {

	int maxprofit = 0;
	for(int i = 1; i < prices.length; i++) {
		if (prices[i] >prices[i-1])
			maxprofit =maxprofit + prices[i] - prices[i-1];
	}
	return maxprofit;
}
```

## [125.Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/)

### 题解-2018年10月28日

-   给定字符串，判断字符串是否回文(仅看字母，忽略大小写与标点符号)

```Java
class ValidPalindrome {
     boolean isPalindrome1(String s) {
         //replaceAll() 方法使用给定的参数 replacement 替换字符串所有匹配给定的正则表达式的子字符串。
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();//去掉除字母数字意外的字符
        //System.out.println(actual);
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {//逐一比较
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
```

## [136.Single Number](https://leetcode.com/problems/single-number/description/)

### 题解-2018年10月29日

-   一组整数，除了一个只出现了一次，其他都出现了两次，找出这个只出现一次的数
-   法一：打表：时间复杂度和空间都为`math O(n)`
-   法二：打表后用数学方法，`2*数组出现的数字和 - 数组的和 = 只出现一次的数字`，`math O(n)`
-   法三：亦或XOR运算：规则如下 `a⊕0=a a⊕a=0`，并满足交换律结合律`a⊕b⊕a=(a⊕a)⊕b=0⊕b=b`，时间复杂度为`math O(n)`，空间复杂度为`math O(1)`

```Java
class SingleNumberTest{
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;//异或运算
        }
        return result;
    }
}
```

## [141.Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)

### 题解-2018年10月30日

-   使用Set集合记录被访问过的节点即可，时间复杂度和空间都为`math O(n)`

```java
class LinkedListCycle{
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
```

## [155.Min Stack](https://leetcode.com/problems/min-stack/description/)

### 题解-2018年10月31日

-   stack 类型封装成MinStack

```java
class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }
    public void pop() {
        if(stack.pop() == min) min=stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}
```

## [LOCKED UP]157.Read N Characters Given Read4

## [160.Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

### 题解-2018年11月1日

    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3

-   如果长度不相同，相交的时候，到交点的距离是都相等（两个链表的距离加上共同部分的距离），不相交的时候，相当于走了两个链表的距离，到最后null == null
-   时间复杂度为`math O(n)`，空间复杂度为`math O(1)`

```java
class IntersectionofTwoLinkedLists {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
```

## [167.Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

### 题解-2018年11月2日

-   整数数组，升序，求两个元素之和为target，每个input必有一对这样的结果，输出这对元素
-   时间复杂度为`math O(n)`，空间复杂度为`math O(1)`

```java
class TwoSum{
    int[] twosum(int[] numbers,int target){
        int[] res=new int[2];
        int i=0;
        int j=numbers.length-1;
        while(numbers[i]+numbers[j]!=target){
            if((numbers[i]+numbers[j])>target){
                j--;
            } else{
                i++;
            }
        }
        res[0]=i+1;
        res[1]=j+1;
        return res;
    }
}
```

## [168.Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)

### 题解-2018年11月3日

-   循环取模转换字符

```java
class ExcelSheetColumnTitle{
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
		//一行代码写法
		//return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
```
