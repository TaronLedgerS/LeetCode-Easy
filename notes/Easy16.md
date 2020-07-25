[TOC]

# LeetCode-Easy16-Top301_320

-   Problems-ID： **1068** 、 **1069** 、1071、 **1075** 、 **1076** 、 **1082** 、 **1083** 、 **1084** 、 **1085** 、 **1086** 、1089、 **1099** 、1103、1108、 **1113** 、1114、 **1118**、  **1119** 、1122

## [LOCKED UP]1068.	Product Sales Analysis I

## [LOCKED UP]1069.	Product Sales Analysis Ⅱ

## [1071. Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/)

### 题解（最大公约数，字符串）-2020年5月25日

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1)) return "";

        int GCDVal = getGCDVal(str1.length(), str2.length());

        return str1.substring(0, GCDVal);
    }


    private int getGCDVal(int p, int q) {
        if (q==0) return p;
        return getGCDVal(q, p % q);
    }
}
```

## [LOCKED UP]1075.	Project Employees I

## [LOCKED UP]1076.	Project Employees II

## [1078. Occurrences After Bigram](https://leetcode.com/problems/occurrences-after-bigram/)

### 题解-2020年5月26日

```java
public class P1078_OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        String[] texts = text.split(" ");
        for (int i = 0; i < texts.length - 2; i++) {
            if (texts[i].equals(first)&&texts[i+1].equals(second)) ans.add(texts[i+2]);
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1078_OccurrencesAfterBigram().findOcurrences(
                "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa",
                "jkypmsxd"
        )));
    }
}
```

## [LOCKED UP]1082.	Sales Analysis I

## [LOCKED UP]1083.	Sales Analysis II

## [LOCKED UP]1084.	Sales Analysis III

## [LOCKED UP]1085.	Sum of Digits in the Minimum Number

## [LOCKED UP]1086.	High Five

## [1089. Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)

### 题解-2020年5月27日

```java
public class P1089_DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        for (int left = 0; left <= length_ - possibleDups; left++) {
            if (arr[left] == 0) {
                if (left == length_ - possibleDups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }
        int last = length_ - possibleDups;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
```

## [LOCKED UP]1099.	Two Sum Less Than K

## [1103. Distribute Candies to People](https://leetcode.com/problems/distribute-candies-to-people/)

### 题解-2020年5月28日

```java
public class P1103_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }
}
```

## [1108. Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)

### 题解-2020年5月29日

```java
public class P1108_DefangingIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c=='.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1108_DefangingIPAddress().defangIPaddr("255.100.50.0"));
    }
}
```

## [LOCKED UP]1113.	Reported Posts

## [1114. Print in Order](https://leetcode.com/problems/print-in-order/)

### 题解（多线程）-2020年5月30日

```java
class Foo {

    CountDownLatch firstPrinted,secondPrinted;

    public Foo() {
        firstPrinted = new CountDownLatch(1);
        secondPrinted = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        firstPrinted.await();
        printSecond.run();
        secondPrinted.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        secondPrinted.await();
        printThird.run();
    }
}
```

## [LOCKED UP]1118.	Number of Days in a Month

## [LOCKED UP]1119.	Remove Vowels from a String

## [1122. Relative Sort Array](https://leetcode.com/problems/relative-sort-array/)

### 题解（计数排序）-2020年5月31日

```java
public class P1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for(int n : arr1) cnt[n]++;
        int i = 0;
        for(int n : arr2) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for(int n = 0; n < cnt.length; n++) {
            while(cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P1122_RelativeSortArray().relativeSortArray(
                        new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6}
                )
        ));
    }
}
```

## [1128. Number of Equivalent Domino Pairs](https://leetcode.com/problems/number-of-equivalent-domino-pairs/)

### 题解（计数排序）-2020年6月1日

```java
public class P1128_NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counts = new int[100];
        int res = 0;
        for (int[] d : dominoes) {
            int up = Math.min(d[0], d[1]);
            int down = Math.max(d[0], d[1]);
            res+=counts[up * 10 + down]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1128_NumberOfEquivalentDominoPairs().numEquivDominoPairs(
                new int[][]{{1,2},{2,1},{3,4},{5,6}}
        ));
    }
}
```
