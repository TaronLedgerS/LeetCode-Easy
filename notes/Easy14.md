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

### 题解（字符串）-2020年4月18日

```java
public class P929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();
        for (String e : emails)
            emailsSet.add(getEmails(e));
        return emailsSet.size();
    }
    private String getEmails(String e){
		StringBuilder sb = new StringBuilder();
		boolean visitedAt = false;
		boolean visitedPlus = false;
		for(char c:e.toCharArray()){
			if(c=='@') visitedAt = true;
			if(!visitedAt){
				if(visitedPlus) continue;
				if(c=='.') continue;
				if(c=='+') {
					visitedPlus = true;
					continue;
				}
				sb.append(c);
			}else{
				sb.append(c);
			}
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
```

## [933. Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)

### 题解（队列）-2020年4月19日

```java
class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    public int ping(int t) {
        q.offer(t);
        while (null != q.peek() && q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
```

## [937. Reorder Data in Log Files](https://leetcode.com/problems/reorder-data-in-log-files/)

### 题解（自定义排序）-2020年4月20日

```java
class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
```

## [938. Range Sum of BST](https://leetcode.com/problems/range-sum-of-bst/)

### 题解（BST-范围求和）-2020年4月21日

```java
public class P938_RangeSumOfBST {
    public static void main(String[] args) {
        System.out.println(
                new RangeSumOfBST().rangeSumBST(
                        StringToTreeNode.stringToTreeNode("10,5,15,3,7,13,18,1,null,6"),6,10
                )
        );
    }
}

class RangeSumOfBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root,L,R);
        return ans;
    }
    private void dfs(TreeNode root, int L,int R) {
        if (null==root) return;
        if (root.val>L) dfs(root.left, L, R);
        if (root.val>=L && root.val<=R) ans += root.val;
        if (root.val<R) dfs(root.right, L, R);
    }
}
```

## [941. Valid Mountain Array](https://leetcode.com/problems/valid-mountain-array/)

### 题解（线段题）-2020年4月22日

```java
public class P941_ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;
        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;
        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;
        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;
        return i == N-1;
    }
    public static void main(String[] args) {
        System.out.println(new P941_ValidMountainArray().validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));
    }
}
```

## [942. DI String Match](https://leetcode.com/problems/di-string-match/)

### 题解（线段题）-2020年4月23日

```java
public class P942_DIStringMatch {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }
        ans[N] = lo;
        return ans;
    }
}
```

## [944. Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/)

### 题解（贪心）-2020年4月24日

```java
public class P944_DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }
}
```

## [949. Largest Time for Given Digits](https://leetcode.com/problems/largest-time-for-given-digits/)

### 题解（枚举）-2020年4月25日

```java
public class P949_LargestTimeforGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j) if (j != i)
                for (int k = 0; k < 4; ++k) if (k != i && k != j) {
                    int l = 6 - i - j - k;

                    // For each permutation of A[i], read out the time and
                    // record the largest legal time.
                    int hours = 10 * A[i] + A[j];
                    int mins = 10 * A[k] + A[l];
                    if (hours < 24 && mins < 60)
                        ans = Math.max(ans, hours * 60 + mins);
                }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}
```

## [953. Verifying an Alien Dictionary](https://leetcode.com/problems/verifying-an-alien-dictionary/)

### 题解（字符串枚举）-2020年4月26日

```java
public class P953_VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++)
            index[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++)
                if (words[i].charAt(j) != words[i + 1].charAt(j))
                    if (index[words[i].charAt(j) - 'a'] > index[words[i + 1].charAt(j) - 'a'])
                        return false;
                    else
                        length = -1;
            if (length != -1 && words[i].length() > words[i + 1].length())
                return false;
        }
        return true;
    }
}
```

## [961. N-Repeated Element in Size 2N Array](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/)

### 题解（数组）-2020年4月27日

```java
public class P961_NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        for (int k = 3; k >= 1; --k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];
        return -1;
    }
}
```

## [965. Univalued Binary Tree](https://leetcode.com/problems/univalued-binary-tree/)

### 题解（二叉树）-2020年4月28日

```java
public class P965_UnivaluedBinaryTree {
    boolean univalued = true;
    int value;
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) return true;
        value = root.val;
        preorder(root);
        return univalued;
    }
    private void preorder(TreeNode root) {
        if (null == root || !univalued) return;
        if (root.val!=value){
            univalued = false;
            return;
        }
        preorder(root.left);
        preorder(root.right);
    }
}
```

## [970. Powerful Integers](https://leetcode.com/problems/powerful-integers/)

### 题解（hashset）-2020年4月29日

```java
public class P970_PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<>();
        for (int m = 1;m<=bound;m*=x){
            for (int n = 1; n <= bound; n *= y) {
                if(m+n<=bound)
                    seen.add(m + n);
                if (y==1) break;

            }
            if (x==1) break;
        }
        return new ArrayList<>(seen);
    }
}
```

## [976. Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)

### 题解（贪心）-2020年4月30日

```java
public class P976_LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-3;i>=0;--i)
            if (A[i]+A[i+1]>A[i+2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
    }
}
```

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
