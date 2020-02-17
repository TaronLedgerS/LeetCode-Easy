[TOC]

# LeetCode-Easy12-Top221_240

-   Problems-ID：762、766、771、783、788、796、 **800** 、804、806、811、812、819、821、824、830、832、836、840、844

## [762. Prime Number of Set Bits in Binary Representation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)

### 题解（素数，二进制）-2020年3月8日

```java
public class P762_PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int ans =0;
        for (int i = L; i <= R; i++) {
            int count = Integer.bitCount(i);
            if (count==2||count==3||count==5||count==7||count==11||count==13||count==17||count==19)
                ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P762_PrimeNumberofSetBitsinBinaryRepresentation().countPrimeSetBits(2, 21)
        );
    }
}
```

## [766. Toeplitz Matrix](https://leetcode.com/problems/toeplitz-matrix/)

### 题解（枚举，二维数组）-2020年3月9日

```java
public class P766_ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++)
            for (int j = 0; j < matrix[0].length - 1; j++)
                if(matrix[i][j]!=matrix[i+1][j+1]) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P766_ToeplitzMatrix().isToeplitzMatrix(
                        new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}
                )
        );
    }
}
```

## [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)

### 题解（字符数组）-2020年3月10日

```java
public class P771_JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        if (J.length()==0) return 0;
        int[] JLowerCaseChar  = new int[26];
        int[] JUpperCaseChar = new int[26];
        for (char c : J.toCharArray()) {
            if (c>='a'&&c<='z') JLowerCaseChar[c - 'a']++;
            if(c>='A'&&c<='Z') JUpperCaseChar[c - 'A']++;
        }
        int ans = 0;
        for (char c : S.toCharArray()) {
            if (c>='a'&&c<='z') ans+=JLowerCaseChar[c - 'a'];
            if(c>='A'&&c<='Z') ans+=JUpperCaseChar[c - 'A'];
        }
        return ans ;
    }
    public static void main(String[] args) {
        System.out.println(
                new P771_JewelsandStones().numJewelsInStones(
                        "aA","aAAbbb"
                )
        );
    }
}
```

## [783. Minimum Distance Between BST Nodes](https://leetcode.com/problems/minimum-distance-between-bst-nodes/)

### 题解（BST遍历）-2020年3月11日

```java
public class P783_MinimumDistanceBetweenBSTNodes {
    int prev=Integer.MIN_VALUE;
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root ==null ) return -1;
        minDiffInBST(root.left);
        if (prev != Integer.MIN_VALUE) {
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        minDiffInBST(root.right);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P783_MinimumDistanceBetweenBSTNodes().minDiffInBST(
                        StringToTreeNode.stringToTreeNode("4,2,6,1,3")
                )
        );
    }
}
```

## [784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/)

### ⭐题解（BFS）-2020年3月12日

-   排列组合

```java
public class P784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        if (S==null) return new LinkedList<>(queue);
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i)>='0'&&S.charAt(i)<='9') continue;
            int num = queue.size();
            for (int j = 0; j < num; j++) {
                String cur = queue.poll();
                char[] ch = cur.toCharArray();
                ch[i] = Character.toLowerCase(ch[i]);
                queue.offer(String.valueOf(ch));
                ch[i] = Character.toUpperCase(ch[i]);
                queue.offer(String.valueOf(ch));
            }
        }
        return new LinkedList<>(queue);
    }
    public static void main(String[] args) {
        System.out.println(
                new P784_LetterCasePermutation().letterCasePermutation("a1b2")
        );
    }
}
```

## [788. Rotated Digits](https://leetcode.com/problems/rotated-digits/)

### ⭐题解（DP）-2020年3月13日

```java
public class P788_RotatedDigits {
    public int rotatedDigits(int N) {
//        Using a int[] for dp.
//        dp[i] = 0, invalid number
//        dp[i] = 1, valid and same number
//        dp[i] = 2, valid and different number
        int[] dp = new int[N + 1];
        int count = 0;
        for(int i = 0; i <= N; i++){
            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if(a == 1 && b == 1) dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(
                new P788_RotatedDigits().rotatedDigits(10)
        );
    }
}
```

## [796. Rotate String](https://leetcode.com/problems/rotate-string/)

### ⭐⭐题解（KMP字符串匹配）-2020年3月14日

```java
public class P796_RotateString {
    public boolean rotateString(String A, String B) {
        //在A+A的子串中找匹配B
        int N = A.length();
        if (N!=B.length()) return false;
        if (N==0) return true;

        //初始化下标转移表
        int[] shifts = new int[N+1];
        Arrays.fill(shifts,1);
        int left = -1;
        for(int right = 0;right<N;++right){
            while(left>=0&& (B.charAt(left)!=B.charAt(right)))
                left -= shifts[left];
            shifts[right+1] = right-left++;
        }
        //Find match of B in A+A
        int matchLen = 0;
        for(char c:(A+A).toCharArray()){
            while(matchLen>=0 && B.charAt(matchLen)!=c)
                matchLen -= shifts[matchLen];
            if(++matchLen == N) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(
                new P796_RotateString().rotateString("abcde","bcdea")
        );
    }
}
```

## [LOCKED UP]800.	Similar RGB Color

## [804. Unique Morse Code Words](https://leetcode.com/problems/unique-morse-code-words/)

### 题解（）-2020年3月15日

## [806. Number of Lines To Write String](https://leetcode.com/problems/number-of-lines-to-write-string/)

### 题解（）-2020年3月16日

## [811. Subdomain Visit Count](https://leetcode.com/problems/subdomain-visit-count/)

### 题解（）-2020年3月17日

## [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)

### 题解（）-2020年3月18日

## [819. Most Common Word](https://leetcode.com/problems/most-common-word/)

### 题解（）-2020年3月19日

## [821. Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)

### 题解（）-2020年3月20日

## [824. Goat Latin](https://leetcode.com/problems/goat-latin/)

### 题解（）-2020年3月21日

## [830. Positions of Large Groups](https://leetcode.com/problems/positions-of-large-groups/)

### 题解（）-2020年3月22日

## [832. Flipping an Image](https://leetcode.com/problems/flipping-an-image/)

### 题解（）-2020年3月23日

## [836. Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/)

### 题解（）-2020年3月24日

## [840. Magic Squares In Grid](https://leetcode.com/problems/magic-squares-in-grid/)

### 题解（）-2020年3月25日

## [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)

### 题解（）-2020年3月26日
