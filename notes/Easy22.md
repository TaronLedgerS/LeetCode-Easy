[TOC]

# LeetCode-Easy19-Top421_440

-   Problems-ID： **1517** 、1518、1523、 **1527** 、1528、1534、1539、 **1543** 、1544、1550、1556、1560

## [LOCKED UP]1517.	Find Users With Valid E-Mails

## [1518. Water Bottles](https://leetcode.com/problems/water-bottles/)

### 题解-2020年8月8日

```java
public class P1518_WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int initial = numBottles;
        while(numBottles >= numExchange){

            initial += (numBottles/numExchange);
            numBottles= (numBottles/numExchange) + (numBottles % numExchange);

        }
        return initial;
    }
}
```

## [1523. Count Odd Numbers in an Interval Range](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/)

### 题解-2020年8月9日

```java
public class P1523_CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
```

## [LOCKED UP]1527.	Patients With a Condition

## [1528. Shuffle String](https://leetcode.com/problems/shuffle-string/)

### 题解-2020年8月10日

```java
public class P1528_ShuffleString {
    public String restoreString(String s, int[] in) {
        char[] c = new char[in.length];
        for(int i = 0; i < in.length; i++)
            c[in[i]] = s.charAt(i);
        return new String(c);
    }
}
```

## [1534. Count Good Triplets](https://leetcode.com/problems/count-good-triplets/)

### 题解-2020年8月11日

```java
public class P1534_CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) res++;
                }
            }
        }
        return res;
    }
}
```

## [☆1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/)

### 题解（二分）-2020年8月12日

```java
public class P1539_KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k) r = mid;
            else l = mid + 1;
        }
        return l + k;
    }
}
```

## [LOCKED UP]1543.	Fix Product Name Format

## [1544. Make The String Great](https://leetcode.com/problems/make-the-string-great/)

### 题解-2020年8月13日

```java
public class P1544_MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        char res[] = new char[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return new String(res);
    }
}
```

## [1550. Three Consecutive Odds](https://leetcode.com/problems/three-consecutive-odds/)

### 题解-2020年8月14日

```java
public class P1550_ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) cnt = 0;
            else if (++cnt == 3) return true;
        }
        return false;
    }
}
```

## [1556. Thousand Separator](https://leetcode.com/problems/thousand-separator/)

### 题解-2020年8月15日

```java
public class P1556_ThousandSeparator {
    public String thousandSeparator(int n) {
        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length(); i > 0; i -= 3) {
            if (sb.length() > 0) sb.insert(0, ".");
            sb.insert(0, num.substring(Math.max(0, i - 3), i));
        }
        return sb.toString();
    }
}
```

## [1560. Most Visited Sector in a Circular Track](https://leetcode.com/problems/most-visited-sector-in-a-circular-track/)

### 题解-2020年8月16日

```java
public class P1560_MostVisitedSectorInaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int len = rounds.length, fr = rounds[0], to = rounds[len - 1];
        List<Integer> res = new ArrayList<>();
        if (to >= fr) {     // no circle, such as [1,3,1,2]
            for (int i = fr; i <= to; i++) res.add(i);
        } else {            // cross a circle, such as [2,3,2,1]
            for (int i = 1; i <= n; i++) {
                if (i == to + 1) i = fr;
                res.add(i);
            }
        }
        return res;
    }
}
```
