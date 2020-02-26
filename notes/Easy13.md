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

### 题解（模拟题）-2020年4月3日

```java
public class P874_WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }
        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }
        return ans;
    }
}
```

## [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)

### ★题解（找链表中间节点）-2020年4月4日

```java
public class P876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head.next==null) return head;
        ListNode FNode = head;
        ListNode BNode = head;
        while(true){
            BNode = BNode.next;
            FNode = FNode.next;
            if(FNode.next==null||FNode.next.next==null)
                return BNode;
            FNode = FNode.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
```

## [883. Projection Area of 3D Shapes](https://leetcode.com/problems/projection-area-of-3d-shapes/)

### 题解（模拟题）-2020年4月5日

```java
public class P883_ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int ans = 0;
        for (int i = 0; i < N;  ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = Math.max(bestRow, grid[i][j]);
                bestCol = Math.max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }
        return ans;
    }
}
```

## [884. Uncommon Words from Two Sentences](https://leetcode.com/problems/uncommon-words-from-two-sentences/)

### 题解（HashMap）-2020年4月6日

```java
public class P884_UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B){
        HashMap<String, Integer> map = new HashMap<>();
        for (String s:A.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s:B.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);
        List<String> ans = new LinkedList<>();
        for (String s : map.keySet())
            if (map.get(s)==1) ans.add(s);
        return ans.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P884_UncommonWordsfromTwoSentences().uncommonFromSentences(
                        "this apple is sweet","this apple is sour"
                ))
        );
    }
}
```

## [888. Fair Candy Swap](https://leetcode.com/problems/fair-candy-swap/)

### ★题解（HashSet+查找答案）-2020年4月7日

```java
public class P888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int SumA = 0, SumB = 0;
        for (int i:A) SumA += i;
        for (int i:B) SumB += i;
        int DELTA = (SumB - SumA) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int i:B) setB.add(i);
        for (int x:A)
            if (setB.contains(x + DELTA)) {
                return new int[]{x, x + DELTA};
            }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P888_FairCandySwap().fairCandySwap(
                        new int[]{1,2,5},new int[]{2,4}
                )
        ));
    }
}
```

## [892. Surface Area of 3D Shapes](https://leetcode.com/problems/surface-area-of-3d-shapes/)

### 题解（模拟题）-2020年4月8日

```java
public class P892_SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int N = grid.length;
        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];
                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P892_SurfaceAreaof3DShapes().surfaceArea(
                        new int[][]{{1,1,1},{1,0,1},{1,1,1}}
                )
        );
    }
}
```

## [893. Groups of Special-Equivalent Strings](https://leetcode.com/problems/groups-of-special-equivalent-strings/)

### 题解-2020年4月9日

```java
public class P893_GroupsofSpecial_EquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for(String S:A){
            int[] count = new int[52];
            for(int i = 0;i<S.length();i++)
                count[S.charAt(i)-'a'+26*(i%2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
```

## [896. Monotonic Array](https://leetcode.com/problems/monotonic-array)

### 题解（遍历）-2020年4月10日

```java
public class P896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return increasing(A)||decreasing(A);
    }
    public boolean increasing(int[] A){
        for(int i = 0;i<A.length-1;i++)
            if (A[i]>A[i+1]) return false;
        return true;
    }
    public boolean decreasing(int[] A){
        for(int i = 0;i<A.length-1;i++)
            if (A[i]<A[i+1]) return false;
        return true;
    }
}
```

## [897. Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree)

### ★题解（二叉树，中序）-2020年4月11日

```java
public class P897_IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Inorder(root,vals);

        TreeNode Node = new TreeNode(vals.get(0));
        TreeNode newRoot = Node;
        for(int i = 1;i<vals.size();i++){
            Node.right = new TreeNode(vals.get(i));
            Node = Node.right;
        }
        return newRoot;
    }
    private void Inorder(TreeNode root, List<Integer> vals){
        if(root==null) return;
        Inorder(root.left,vals);
        vals.add(root.val);
        Inorder(root.right,vals);
    }
}
```

## [905. Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)

### 题解-2020年4月12日

```java
public class P905_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length-1;
        while(l<r){
            while(A[l]%2==0 && l<r) l++;
            while(A[r]%2==1 && l<r) r--;
            if(l<r){
                int t = A[l];
                A[l] = A[r];
                A[r] = t;
            }
        }
        return A;
    }
}
```

## [908. Smallest Range I](https://leetcode.com/problems/smallest-range-i/)

### 题解（数学）-2020年4月13日

```java
public class P908_SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0],max = A[0];
        for(int x:A){
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        return Math.max(0,max-min-2*K);
    }
}
```

## [914. X of a Kind in a Deck of Cards](https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/)

### ★题解（最大公约数）-2020年4月14日

```java
public class P914_XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10001];
        for(int a :deck)
            count[a]++;

        int gcd = -1;
        for(int a: count){
            if(a>0){
                if(gcd==-1)
                    gcd = a;
                else
                    gcd = getGCD(gcd,a);
            }
        }
        return gcd>=2;
    }
    //最大公约数！！！
    public int getGCD(int x,int y){
        if(y==0)
            return x;
        return getGCD(y,x%y);
    }
}
```

## [917. Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/)

### 题解（）-2020年4月15日

## [922. Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)

### 题解（）-2020年4月16日
