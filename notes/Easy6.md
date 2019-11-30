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

### 题解-2019年12月4日

## [401. Binary Watch](https://leetcode.com/problems/binary-watch/)

### 题解-2019年12月5日

## [404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/)

### 题解-2019年12月6日

## [405. Convert a Number to Hexadecimal](https://leetcode.com/problems/convert-a-number-to-hexadecimal/)

### 题解-2019年12月7日

## [LOCKED UP]408. Valid Word Abbreviation

## [409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome/)

### 题解-2019年12月8日

## [412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)

### 题解-2019年12月9日

## [414. Third Maximum Number](https://leetcode.com/problems/third-maximum-number/)

### 题解-2019年12月10日

## [415. Add Strings](https://leetcode.com/problems/add-strings/)

### 题解-2019年12月11日

## [LOCKED UP]422. Valid Word Square

## [434. Number of Segments in a String](https://leetcode.com/problems/number-of-segments-in-a-string/)

### 题解-2019年12月12日

## [437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)

### 题解-2019年12月13日

## [441. Arranging Coins](https://leetcode.com/problems/arranging-coins/)

### 题解-2019年12月14日

## [443. String Compression](https://leetcode.com/problems/string-compression/)

### 题解-2019年12月15日

## [447. Number of Boomerangs](https://leetcode.com/problems/number-of-boomerangs/)

### 题解-2019年12月16日
