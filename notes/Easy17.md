[TOC]

# LeetCode-Easy17-Top321_340

-   Problems-ID： **1134** 、1137、 **1141** 、 **1142** 、 **1148** 、 **1150** 、1154、1160、 **1165** 、1170、 **1173** 、1175、 **1176** 、1179、 **1180** 、1184、1185、1189、1196、1200

## [LOCKED UP]1134.	Armstrong Number

## [1137. N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)

### 题解-2020年6月2日

```java
public class P1137_NthTribonacciNumber {

    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;
        int[] T = new int[n + 1];
        T[0]=0;
        T[1] = T[2] = 1;
        for (int i = 3; i <= n; i++) {
            T[i] = T[i - 1] + T[i - 2] + T[i - 3];
        }
        return T[n];
    }

}
```

## [LOCKED UP]1141.	User Activity for the Past 30 Days I

## [LOCKED UP]1142.	User Activity for the Past 30 Days II

## [LOCKED UP]1148.	Article Views I

## [LOCKED UP]1150.	Check If a Number Is Majority Element in a Sorted Array

## [1154. Day of the Year](https://leetcode.com/problems/day-of-the-year/)

### 题解-2020年6月3日

```java
public class P1154_DayOfTheYear {

    public int dayOfYear(String date) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dates = date.split("-");
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        boolean isLeap = checkYear(Integer.parseInt(dates[0]));
        int noOfDays = 0;
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                noOfDays += days[i] + 1;
                continue;
            }
            noOfDays += days[i];
        }
        return noOfDays + day;
    }

    private boolean checkYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }

}
```

## [1160. Find Words That Can Be Formed by Characters](https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/)

### 题解-2020年6月4日

```java
public class P1160_FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        //Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
        // Comparing each word in words
        for (String word : words) {
            // simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length);
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }
}
```

## [LOCKED UP]1165.	Single-Row Keyboard

## [1170. Compare Strings by Frequency of the Smallest Character](https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/)

### 题解-2020年6月5日

```java
public class P1170_CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int [] fCount = new int[11];
        for(String word : words){
            int count = getFCount(word);
            fCount[count]++;
        }
        int sum = 0;
        for(int i=0;i<fCount.length;i++){
            sum += fCount[i];
            fCount[i] = sum;
        }
        int [] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int count = getFCount(queries[i]);
            res[i] = fCount[fCount.length -1] - fCount[count];
        }
        return res;
    }

    public int getFCount(String word){
        int [] count = new int[26];
        for(int i=0;i<word.length();i++){
            count[word.charAt(i)-'a']++;
        }
        for (int value : count) {
            if (value != 0) {
                return value;
            }
        }
        return 0;
    }
}
```

## [LOCKED UP]1173.	Immediate Food Delivery I

## [1175. Prime Arrangements](https://leetcode.com/problems/prime-arrangements/)

### 题解-2020年6月6日

```java
public class P1175_PrimeArrangements {
    public int numPrimeArrangements(int n) {
        int cnt = 1; // # of primes, first prime is 2.
        outer:
        for (int i = 3; i <= n; i += 2) { // only odd number could be a prime, if i > 2.
            for (int factor = 3; factor * factor <= i; factor += 2)
                if (i % factor == 0)
                    continue outer;
            ++cnt;
        }
        long ans = 1;
        for (int i = 1; i <= cnt; ++i) // (# of primes)!
            ans = ans * i % 1_000_000_007;
        for (int i = 1; i <= n - cnt; ++i) // (# of non-primes)!
            ans = ans * i % 1_000_000_007;
        return (int)ans;
    }
}
```

## [LOCKED UP]1176.	Diet Plan Performance

## [1179. Reformat Department Table](https://leetcode.com/problems/reformat-department-table/)

### 题解(SQL)-2020年6月7日

```SQL
select id,
	sum(case when month = 'jan' then revenue else null end) as Jan_Revenue,
	sum(case when month = 'feb' then revenue else null end) as Feb_Revenue,
	sum(case when month = 'mar' then revenue else null end) as Mar_Revenue,
	sum(case when month = 'apr' then revenue else null end) as Apr_Revenue,
	sum(case when month = 'may' then revenue else null end) as May_Revenue,
	sum(case when month = 'jun' then revenue else null end) as Jun_Revenue,
	sum(case when month = 'jul' then revenue else null end) as Jul_Revenue,
	sum(case when month = 'aug' then revenue else null end) as Aug_Revenue,
	sum(case when month = 'sep' then revenue else null end) as Sep_Revenue,
	sum(case when month = 'oct' then revenue else null end) as Oct_Revenue,
	sum(case when month = 'nov' then revenue else null end) as Nov_Revenue,
	sum(case when month = 'dec' then revenue else null end) as Dec_Revenue
from department
group by id
order by id
```

## [LOCKED UP]1180.	Count Substrings with Only One Distinct Letter

## [1184. Distance Between Bus Stops](https://leetcode.com/problems/distance-between-bus-stops/)

### 题解-2020年6月8日

## [1185. Day of the Week](https://leetcode.com/problems/day-of-the-week/<>)

### 题解-2020年6月9日

## [1189. Maximum Number of Balloons](https://leetcode.com/problems/maximum-number-of-balloons/)

### 题解-2020年6月10日

## [LOCKED UP]1196.	How Many Apples Can You Put into the Basket

## [1200. Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

### 题解-2020年6月11日
