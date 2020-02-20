[TOC]

# LeetCode-Easy12-Top221_240

-   Problems-ID：762、766、771、783、788、796、 **800** 、804、806、811、812、819、821、824、830、832、836、840、844、849

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

### 题解（字符串查重-HashSet）-2020年3月15日

```java
public class P804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> transfored = new HashSet<>();
        for(String s :words){
            StringBuilder sb = new StringBuilder();
            for(char c:s.toCharArray()){
                sb.append(MORSE[c-'a']);
            }
            transfored.add(sb.toString());
        }
        return transfored.size();
    }
    public static void main(String[] args) {
        System.out.println(
                new P804_UniqueMorseCodeWords().uniqueMorseRepresentations(
                        new String[]{"gin", "zen", "gig", "msg"}
                )
        );
    }
}
```

## [806. Number of Lines To Write String](https://leetcode.com/problems/number-of-lines-to-write-string/)

### 题解（数组元素统计）-2020年3月16日

```java
public class P806_NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        if( S==null || S.length()==0) return new int[]{0,0};
        int countLine = 1;
        int lastLine = 0;
        for(char c:S.toCharArray()){
            lastLine += widths[c-'a'];
            if(lastLine>100){
                countLine++;
                lastLine = widths[c-'a'];
            }
        }
        return new int[]{countLine,lastLine};
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                new P806_NumberofLinesToWriteString().numberOfLines(
                        new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                        "abcdefghijklmnopqrstuvwxyz")));
    }
}
```

## [811. Subdomain Visit Count](https://leetcode.com/problems/subdomain-visit-count/)

### ★题解（字符串切片、正则）-2020年3月17日

```java
public class P811_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> count = new HashMap<>();
        for(String S:cpdomains){
            //此题\\s+、\\s、“ ”都可以
            String[] domain = S.split("\\s+");
            //“.”和“|”都是转义字符，必须得加"\\";
            String[] letterPart = domain[1].split("\\.");
            int digitPart = Integer.parseInt(domain[0]);
            String domainPart = "";
            for(int i = letterPart.length-1;i>=0;i--){
                domainPart = letterPart[i]+(i<letterPart.length-1?".":"")+domainPart;
                count.put(domainPart,count.getOrDefault(domainPart,0)+digitPart);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String dom:count.keySet()){
            ans.add(""+count.get(dom)+" " +dom);
        }
        return ans ;
    }
    public static void main(String[] args) {
        System.out.println(
                new P811_SubdomainVisitCount().subdomainVisits(
                        new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}
                )
        );
    }
}
```

## [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)

### 题解（数学题）-2020年3月18日

```java
public class P812_LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }
    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}
```

## [819. Most Common Word](https://leetcode.com/problems/most-common-word/)

### 题解（单词统计）-2020年3月19日

```java
public class P819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> count = new HashMap<>();
        for (String s:banned)
            count.put(s, -1);
        String lowerCaseP = paragraph.toLowerCase();
        String MCWord = "";
        StringBuilder sb = new StringBuilder();
        for (char c : lowerCaseP.toCharArray()) {
            if (c>='a'&&c<='z')
                sb.append(c);
            else{
                MCWord = putWord(sb.toString(), count, MCWord);
                sb = new StringBuilder();
            }
        }
        MCWord = putWord(sb.toString(), count, MCWord);
        return MCWord;
    }
    private String putWord(String word, Map<String,Integer> count , String MCWord){
        if (word.length()!=0){
            if (!(count.containsKey(word)&&count.get(word)==-1)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
                if (MCWord.length() == 0 || count.get(MCWord) < count.get(word)) {
                    return word;
                }
            }
        }
        return MCWord;
    }
    public static void main(String[] args) {
        System.out.println(
                new P819_MostCommonWord().mostCommonWord(
                        "Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"})
        );
    }
}
```

## [821. Shortest Distance to a Character](https://leetcode.com/problems/shortest-distance-to-a-character/)

### 题解（下标问题）-2020年3月20日

-   官方解决左右来回扫的方法更好

```java
public class P821_ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        List<Integer> CPosition = new ArrayList<>();
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i)==C) CPosition.add(i);
        int preCIndex = -1;
        for (int i = 0; i < S.length(); i++) {
            if (preCIndex==-1)
                ans[i] = CPosition.get(preCIndex + 1) - i;
            else if(preCIndex==CPosition.size()-1)
                ans[i] = Math.abs(CPosition.get(preCIndex) - i);
            else
                ans[i] = Math.min(Math.abs(i - CPosition.get(preCIndex)), Math.abs(i - CPosition.get(preCIndex + 1)));
            if (preCIndex<CPosition.size()-1 && i>=CPosition.get(preCIndex + 1))
                preCIndex++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                new P821_ShortestDistancetoaCharacter().shortestToChar("loveleetcode",'e')));
    }
}
```

## [824. Goat Latin](https://leetcode.com/problems/goat-latin/)

### 题解（字符串）-2020年3月21日

```java
public class P824_GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> Vowel =new HashSet<>();
        for (char c:new char[]{'a','e','i','o','u','A','E','I','O','U',})
            Vowel.add(c);

        StringBuilder ans = new StringBuilder();
        String[] words = S.split(" ");
        int count = 0;
        for (String w : words) {
            count++;
            if (Vowel.contains(w.charAt(0))) {
                ans.append(w);
            } else {
                ans.append(w.substring(1));
                ans.append(w.substring(0, 1));
            }
            ans.append("ma");
            for (int i = 0;i<count;i++)
                ans.append('a');
            ans.append(' ');
        }
        return ans.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(
                new P824_GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog")
        );
    }
}
```

## [830. Positions of Large Groups](https://leetcode.com/problems/positions-of-large-groups/)

### 题解（字符串）-2020年3月22日

-   注意头尾的情况

```java
public class P830_PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new LinkedList<>();
        if (S.length()<3) return ans;
        int begin = 0;
        for (int i = begin+1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (i - begin >= 3) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(begin);
                    temp.add(i - 1);
                    ans.add(temp);
                }
                begin = i;
            }
        }
        if(S.length()-begin>=3){
            List<Integer> temp = new LinkedList<>();
            temp.add(begin);
            temp.add(S.length() - 1);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P830_PositionsofLargeGroups().largeGroupPositions("aaa")
        );
    }
}
```

## [832. Flipping an Image](https://leetcode.com/problems/flipping-an-image/)

### 题解（位运算）-2020年3月23日

```java
public class P832_FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        final int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (A[i][j] == A[i][N - j - 1]) {
                    A[i][j] ^= 1 ;
                    A[i][N - j - 1] ^=  1;
                }
            }
            if (N%2==1)
                A[i][N/2] ^= 1;
        }
        return A;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new P832_FlippinganImage().flipAndInvertImage(
                                new int[][]{{1,1,0},{1,0,1},{0,0,0}}
                        )
                )
        );
    }
}
```

## [836. Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/)

### 题解-2020年3月24日

```java
public class P836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
    public static void main(String[] args) {
        System.out.println(
                new P836_RectangleOverlap().isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1})
        );
    }
}
```

## [840. Magic Squares In Grid](https://leetcode.com/problems/magic-squares-in-grid/)

### 题解（暴力！！）-2020年3月25日

```java
public class P840_MagicSquaresInGrid {
    int cnt, m, n;
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        cnt = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                if (isMagicSquare(grid, i, j)) cnt++;
            }
        }
        return cnt;
    }
    private boolean isMagicSquare(int[][] grid, int x, int y) {
        //check 1-9
        int[] nums = new int[9];
        for (int i = x - 2; i <= x; i++) {
            for (int j = y - 2; j <= y; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1) return false; //check num that not in 1-9
                nums[grid[i][j] - 1]++;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (nums[i] == 0) return false;
        }
        //checkRow
        int row1 = grid[x][y - 2] + grid[x - 1][y - 2] + grid[x - 2][y - 2];
        int row2 = grid[x][y - 1] + grid[x - 1][y - 1] + grid[x - 2][y - 1];
        int row3 = grid[x][y] + grid[x - 1][y] + grid[x - 2][y];
        //checkCol
        int col1 = grid[x][y] + grid[x][y - 1] + grid[x][y - 2];
        int col2 = grid[x - 1][y] + grid[x - 1][y - 1] + grid[x - 1][y - 2];
        int col3 = grid[x - 2][y] + grid[x - 2][y - 1] + grid[x - 2][y - 2];
        //checkDiagonal
        int dia1 = grid[x - 2][y - 2] + grid[x - 1][y - 1] + grid[x][y];
        int dia2 = grid[x - 2][y] + grid[x - 1][y - 1] + grid[x][y - 2];
        return row1 == row2 && row1 == row3 && row1 == col1 && row1 == col2 && row1 == col3 && row1 == dia1 && row1 == dia2;
    }
    public static void main(String[] args) {
        System.out.println(
                new P840_MagicSquaresInGrid().numMagicSquaresInside(new int[][]{{4,3,8,4}, {9,5,1,9},{2,7,6,2}})
        );
    }
}
```

## [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)

### 题解（Stack）-2020年3月26日

-   char类型使用==

```java
public class P844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c:S.toCharArray()) {
            if (c=='#'){
                if(!stackS.empty())
                    stackS.pop();
            }else
                stackS.push(c);
        }
        for (char c:T.toCharArray()) {
            if (c=='#'){
                if(!stackT.empty())
                    stackT.pop();
            }
            else
                stackT.push(c);
        }
        if (stackS.size()!=stackT.size()) return false;
        while (!stackS.isEmpty()){
            if (stackS.pop() != stackT.pop())
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(
                new P844_BackspaceStringCompare().backspaceCompare("a#c","b")
        );
    }
}
```

## [849. Maximize Distance to Closest Person](https://leetcode.com/problems/maximize-distance-to-closest-person/)

### ★题解（贪心算法+数组压缩）-2020年3月27日

```java
public class P849_MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int k = 0;
        int ans = -1;
        for (int seat : seats) {
            if (seat == 1) {
                if (ans == -1) {
                    ans = k;
                } else
                    ans = Math.max(ans, (k + 1) / 2);
                k = 0;
            } else
                k++;
        }
        ans = Math.max(ans, k);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new P849_MaximizeDistancetoClosestPerson().maxDistToClosest(
                        new int[]{0,1,0,0,0}
                )
        );
    }
}
```
