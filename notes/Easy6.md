[TOC]

# LeetCode-Easy6-Top101_120

-   Problems-ID：371、374、383、387、389、392、401、404、405、 **408** 、409、412、414、415、 **422** 、434、437、441、443、447

## [371. Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/)

### 题解-2019年11月29日

```java
public class P371_SumofTwoIntegers {
    public int getSum(int a, int b) {
        return a+b;
    }
    public static void main(String[] args) {
        P371_SumofTwoIntegers test = new P371_SumofTwoIntegers();
        System.out.println(test.getSum(1,2));
    }
}
```

## [374. Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)

### 题解（二分）-2019年11月30日

```java
public class P374_GuessNumberHigherorLower {
    private int pick;
    P374_GuessNumberHigherorLower(int pick) {
        this.pick = pick;
    }
    public int guess(int num) {
        if (num == pick) {
            return 0;
        }
        return num>pick?-1:1;
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pick = scanner.nextInt();
        P374_GuessNumberHigherorLower test = new P374_GuessNumberHigherorLower(pick);
        System.out.println(test.guessNumber(n));
    }
}
```

## [383. Ransom Note](https://leetcode.com/problems/ransom-note/)

### 题解（字符串）-2019年12月1日

```java
public class P383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P383_RansomNote test = new P383_RansomNote();
        System.out.println(test.canConstruct("aa","aab"));
    }
}
```

## [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

### 题解（字符串）-2019年12月2日

```java
public class P387_FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == -1) {
                arr[s.charAt(i) - 'a'] = i;
            } else {
                if (arr[s.charAt(i) - 'a'] >=0) {
                    arr[s.charAt(i) - 'a'] = -2;
                }
            }
        }
        int ans = -1;
        for (int value:arr) {
            if (value >= 0 ) {
                if (ans == -1) {
                    ans = value;
                } else {
                    ans = Math.min(ans, value);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        P387_FirstUniqueCharacterinaString test = new P387_FirstUniqueCharacterinaString();
        System.out.println(test.firstUniqChar("loveleetcode"));
    }
}
```

## [389. Find the Difference](https://leetcode.com/problems/find-the-difference/)

### 题解（字符串）-2019年12月3日

```java
public class P389_FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a'] -=1;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return t.charAt(0);
    }
    public static void main(String[] args) {
        P389_FindtheDifference test = new P389_FindtheDifference();
        System.out.println(test.findTheDifference("abcd", "abcde"));
    }
}
```

## [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)

### 题解（子序列）-2019年12月4日

-   s = "abc", t = "ahbgdc" 判断s是否为t的子序列
-   子序列的两个特征：元素匹配+位置有序
-   法一：循环枚举比对，时间复杂度O(T)
-   法二：二分枚举，先对T的各元素出现的位置进行哈希-时间复杂度O(T)，遍历S用二分查找确保每个元素的位置顺序，时间复杂度O(SlogT)→用于一个T串但有很多个S串的情况

```java
public class P392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(indexS) == t.charAt(i)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P392_IsSubsequence test = new P392_IsSubsequence();
        System.out.println(test.isSubsequence("axc","ahbgdc"));
    }
}
```

## [401. Binary Watch](https://leetcode.com/problems/binary-watch/)

### 题解（时间+进制+格式化）-2019年12月5日

-   从结果出发，枚举结果

```java
public class P401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d",h,m));
                }
            }
        }
        return times;
    }
    public static void main(String[] args) {
        P401_BinaryWatch test = new P401_BinaryWatch();
        List<String> times = test.readBinaryWatch(1);
        for (String temp : times) {
            System.out.println(temp);
        }
    }
}
```

## [404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/)

### ⭐题解（二叉树）-2019年12月6日

```java
public class P404_SumofLeftLeaves {
    //字符串构造二叉树
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
            if (index == parts.length) {
                break;
            }
        	item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return  0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {//为左叶子节点
            sum += root.left.val;
        } else {//为空或者非叶子节点
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    public static void main(String[] args) {
        P404_SumofLeftLeaves test = new P404_SumofLeftLeaves();
        System.out.println(test.sumOfLeftLeaves(stringToTreeNode("3,9,20,null,null,15,7")));
    }
}
```

## [405. Convert a Number to Hexadecimal](https://leetcode.com/problems/convert-a-number-to-hexadecimal/)

### 题解（进制编码）-2019年12月7日

```java
public class P405_ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    public static void main(String[] args) {
        P405_ConvertaNumbertoHexadecimal test = new P405_ConvertaNumbertoHexadecimal();
        System.out.println(test.toHex(-1));
    }
}
```

## [LOCKED UP]408. Valid Word Abbreviation

## [409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)

### 题解（HashSet）-2019年12月8日

```java
public class P409LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        HashSet<Character> tmpSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (tmpSet.contains(s.charAt(i))) {
                tmpSet.remove(s.charAt(i));
                count++;
            }else{
                tmpSet.add(s.charAt(i));
            }
        }
        if (!tmpSet.isEmpty()) return count * 2 + 1;
        return count*2;
    }
    public static void main(String[] args) {
        P409LongestPalindrome test = new P409LongestPalindrome();
        System.out.println(test.longestPalindrome("abbcccdd"));
    }
}
```

## [412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)

### 题解（List）-2019年12月9日

```java
public class P412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> FizzBuzzList = new ArrayList<>();
        for (int i = 1;i<=n;i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                FizzBuzzList.add("FizzBuzz");
            } else if (i%3==0) {
                FizzBuzzList.add("Fizz");
            } else if (i % 5 == 0) {
                FizzBuzzList.add("Buzz");
            } else {
                FizzBuzzList.add(String.valueOf(i));
            }
        }
        return FizzBuzzList;
    }
    public static void main(String[] args) {
        P412_FizzBuzz test = new P412_FizzBuzz();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(test.fizzBuzz(n));
    }
}
```

## [414. Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)

### 题解-（优先队列）-2019年12月10日

```java
public class P414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (a==nums[i]||b==nums[i]||c==nums[i]) continue;
            if (a == -1 || nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if (b == -1 || nums[i] > b) {
                c = b;
                b = nums[i];
            } else if(c==-1||nums[i]>c){
                c = nums[i];
            }
        }
    	if (c != -1) {
            return c;
        } else  return a;
    }
    public static void main(String[] args) {
        P414_ThirdMaximumNumber test = new P414_ThirdMaximumNumber();
        int[] n = {2, 1, 2,3};
        System.out.println(test.thirdMax(n));
    }
}
```

## [415. Add Strings](https://leetcode.com/problems/add-strings/)

### 题解（大数相加）-2019年12月11日

```java
public class P415_AddStrings {
    public String addStrings1(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger result = a.add(b);
        return result.toString();
    }
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
            }
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        P415_AddStrings test = new P415_AddStrings();
        String num1 = s.nextLine();
        String num2 = s.nextLine();
        System.out.printf("%s,%s\n",num1,num2);
        System.out.println(test.addStrings1(num1,num2));
        System.out.println(test.addStrings(num1,num2));
    }
}
```

## [LOCKED UP]422. Valid Word Square

## [434. Number of Segments in a String](https://leetcode.com/problems/number-of-segments-in-a-string/)

### 题解（字符串）-2019年12月12日

-   [Java--"\\s+"匹配任意空白字符](https://blog.csdn.net/high2011/article/details/53467220)

```java
public class P434_NumberofSegmentsinaString {
    public int countSegments(String s) {
        String trimmed = s.trim();//去除头尾空格
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        P434_NumberofSegmentsinaString test = new P434_NumberofSegmentsinaString();
        while ((line = in.readLine()) != null) {
            System.out.println(test.countSegments(line));
        }
    }
}
```

## ⭐[437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)

### 题解（树，递归，前缀）-2019年12月13日

```java
public class P437_PathSumIII {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        helper(root, 0, sum, preSum);
        return count;
    }
    int count = 0;
    public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum) + 1);
        }

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //10,5,-3,3,2,null,11,3,-2,null,1
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();//读入数字
            int sum = Integer.parseInt(line);
            System.out.println(new P437_PathSumIII().pathSum(root,sum));
        }
    }
}
```

## [441. Arranging Coins](https://leetcode.com/problems/arranging-coins/)

### 题解-2019年12月14日

```java
public class P441_ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i+=1;
            n-=i;
        }
        return n==0?i:i-1;
    }
    public static void main(String[] args) {
        System.out.println(new P441_ArrangingCoins().arrangeCoins(5));
    }
}
```

## [443. String Compression](https://leetcode.com/problems/string-compression/)

### 题解（字符）-2019年12月15日

```java
public class P443_StringCompression {
    public int compress(char[] chars) {
        int indexAns = 0,index = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count!=1)
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
        }
        return  indexAns;
    }
    public static void main(String[] args) {
        System.out.println(new P443_StringCompression().compress("abbbbbb".toCharArray()));
    }
}
```

## [447. Number of Boomerangs](https://leetcode.com/problems/number-of-boomerangs/)

### 题解-2019年12月16日
