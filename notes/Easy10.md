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

### ⭐题解（BST、HashSet、BFS）-2020年2月7日

```java
public class P653_TwoSumIV_InputisaBST {
    //1.HashSet+DFS
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> nodeSet = new HashSet<>();
        return preorderTraversal(root, nodeSet,k);
    }
    private boolean preorderTraversal(TreeNode root, Set<Integer> nodeSet,int k) {
        if (root==null) return false;
        if (nodeSet.contains(k - root.val))
            return true;
        nodeSet.add(root.val);
        return preorderTraversal(root.left,nodeSet,k)|| preorderTraversal(root.right,nodeSet,k);
    }
    //2.HashSet+BFS
    public boolean findTarget2(TreeNode root, int k) {
        if (root==null) return false;
        Set<Integer> nodeSet = new HashSet<>();
        Queue<TreeNode> toTraversal = new LinkedList<>();
        toTraversal.add(root);
        while (!toTraversal.isEmpty()) {
            TreeNode node = toTraversal.poll();
            if (nodeSet.contains(k - node.val)) {
                return true;
            }
            nodeSet.add(node.val);
            if (node.left!=null) toTraversal.add(node.left);
            if (node.right!=null) toTraversal.add(node.right);
        }
        return false;
    }
    //3.BST中序遍历是有序的+双指针
    public boolean findTarget3(TreeNode root, int k) {
        List<Integer> valArray = new ArrayList<>();
        inorder(root, valArray);
        int l = 0, r = valArray.size() - 1;
        while (l < r) {
            int sum = valArray.get(l) + valArray.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> valArray) {
        if (root == null) {
            return;
        }
        inorder(root.left, valArray);
        valArray.add(root.val);
        inorder(root.right,valArray);
    }
    public static void main(String[] args) {
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget1(
                        StringToTreeNode.stringToTreeNode("5,3,6,2,4,null,7"),9
                )
        );
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget2(
                        StringToTreeNode.stringToTreeNode("5,3,6,2,4,null,7"),9
                )
        );
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget3(
                        StringToTreeNode.stringToTreeNode("5,3,6,2,4,null,7"),9
                )
        );
    }
}
```

## [657. Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)

### 题解（字符统计）-2020年2月8日

```java
public class P657_RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'R') x++;
            else if (ch == 'L') x--;
        }
        return x == 0 && y == 0;
    }
    public static void main(String[] args) {
        System.out.println(
                new P657_RobotReturntoOrigin().judgeCircle("LLRR")
        );
    }
}
```

## [661. Image Smoother](https://leetcode.com/problems/image-smoother/)

### 题解（二维数组）-2020年2月9日

```java
public class P661_ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int len1 = M.length;
        int len2 = M[0].length;
        int[][] result = new int[len1][len2];
        for(int i = 0;i < len1;i++) {
            for(int j = 0;j < len2;j++) {
                int sum = 0;
                int count = 0;
                for(int m = i - 1;m < i + 2;m++) {
                    for(int n = j - 1;n < j + 2;n++) {
                        if(m >= 0 && m < len1 && n >= 0 && n < len2) {
                            sum += M[m][n];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(
                        Arrays.deepToString(new P661_ImageSmoother().imageSmoother(
                                new int[][]{{1,3,2},{6,2,25}}
                        ))
                );

    }
}
```

## [665. Non-decreasing Array](https://leetcode.com/problems/non-decreasing-array/)

### 题解（线段-贪心）-2020年2月10日

```Java
public class P665_Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (i>0 && nums[i+1]<nums[i-1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i+1];
                if (count>1) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P665_Non_decreasingArray().checkPossibility(
                        new int[]{3,4,2,3}
                )
        );
    }
}
```

## [669. Trim a Binary Search Tree](https://leetcode.com/problems/trim-a-binary-search-tree/)

### ⭐题解（树+递归剪枝）-2020年2月11日

```java
public class P669_TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val<L) return trimBST(root.right,L,R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(
                new P669_TrimaBinarySearchTree().trimBST(
                        StringToTreeNode.stringToTreeNode("2,0,3,-4,1"),-1,3
                )
        );
    }
}
```

## [671. Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)

### ⭐题解（树，找次小值）-2020年2月12日

-   最值初始化

```java
public class P671_SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        boolean isExist1 = false;
        boolean isExist2 = false;
        Queue<TreeNode> toTraversal = new LinkedList<>();
        toTraversal.offer(root);
        while (!toTraversal.isEmpty()) {
            TreeNode node = toTraversal.poll();
            if (node.left!=null) toTraversal.offer(node.left);
            if (node.right!=null) toTraversal.offer(node.right);
            if (!isExist1) {
                min1 = node.val;
                isExist1 = true;
            } else if (min1 > node.val) {
                min2 = min1;
                min1 = node.val;
                if (!isExist2) isExist2 = true;
            }else if (min1<node.val){
                if (!isExist2){
                    min2 = node.val;
                    isExist2 = true;
                }else{
                    if (min2>node.val) min2 = node.val;
                }
            }
        }
        return isExist2?min2:-1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P671_SecondMinimumNodeInaBinaryTree().findSecondMinimumValue(
                        StringToTreeNode.stringToTreeNode("2,2,2147483647")
                )
        );
    }
}
```

## [674. Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)

### 题解（最长增长子串）-2020年2月13日

```java
public class P674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length<2) return nums.length;
        int count = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                res = Math.max(res, count);
            }else
                count=1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(
                new P674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(
                        new int[]{1,3,5,4,7}
                )
        );
    }
}
```

## [680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

### 题解（字符串）-2020年2月14日

```java
public class P680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l)!=s.charAt(r))
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P680_ValidPalindromeII().validPalindrome("abccbdda")
        );
    }
}
```

## [682. Baseball Game](https://leetcode.com/problems/baseball-game/)

### 题解（字符串，模拟题，Stack）-2020年2月15日

```java
public class P682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> pointsStack = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                pointsStack.pop();
            } else if ("D".equals(op)) {
                pointsStack.push(pointsStack.peek() * 2);
            } else if ("+".equals(op)) {
                int top = pointsStack.pop();
                int newTop = top + pointsStack.peek();
                pointsStack.push(top);
                pointsStack.push(newTop);
            } else {
                pointsStack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for (Integer i : pointsStack) {
            ans+=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P682_BaseballGame().calPoints(
                        new String[]{"5","2","C","D","+"}
                )
        );
    }
}
```

## [686. Repeated String Match](https://leetcode.com/problems/repeated-string-match/)

### ⭐题解（字符串匹配）-2020年2月16日

-   T-$O(n(m+n))$ S-$O(n)$

```java
public class P686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P686_RepeatedStringMatch().repeatedStringMatch(
                        "abcd","cdabcdabcd"
                )
        );
    }
}
```

## [687. Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/)

### ⭐题解（二叉树、递归遍历）-2020年2月17日

```java
public class P687_LongestUnivaluePath {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        findEdgeLength(root);
        return ans;
    }
    private int findEdgeLength(TreeNode root) {
        if (root == null) return 0;
        int left = findEdgeLength(root.left);
        int right = findEdgeLength(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
    public static void main(String[] args) {
        System.out.println(
                new P687_LongestUnivaluePath().longestUnivaluePath(
                        StringToTreeNode.stringToTreeNode("5,4,5,1,1,null,5")
                )
        );
    }
}
```

## [690. Employee Importance](https://leetcode.com/problems/employee-importance/)

### ⭐题解（HashMap，BFS，ArrayList初始化）-2020年2月18日

```java
public class P690_EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1,5,Arrays.asList(2,3)),
                new Employee(2,3,new ArrayList<>()),
                new Employee(3,3,new ArrayList<>())
        ));
        System.out.println(
                new P690_EmployeeImportance().getImportance(
                        employees,1
                )
        );
    }
}
```

## [693. Binary Number with Alternating Bits](https://leetcode.com/problems/binary-number-with-alternating-bits/)

### 题解（）-2020年2月19日

## [696. Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)

### 题解（）-2020年2月20日

## [697. Degree of an Array](https://leetcode.com/problems/degree-of-an-array/)

### 题解（）-2020年2月21日
