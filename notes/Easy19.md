[TOC]

# LeetCode-Easy19-Top361_380

-   Problems-ID： **1294** 、1295、1299、 **1303** 、1304、1309、1313、1317、 **1322** 、1323、 **1327** 、1331、1332、1337、1342、1346、 **1350** 、1351、1356、1360

## [LOCKED UP]1294.	Weather Type in Each Country

## [LOCKED UP]1303.	Find the Team Size

## [LOCKED UP]1322.	Ads Performance

## [LOCKED UP]1327.	List the Products Ordered in a Period

## [LOCKED UP]1350.	Students With Invalid Departments

## [1295. Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)

### 题解-2020年6月24日

```java
public class P1295_FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
```

## [1299. Replace Elements with Greatest Element on Right Side](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)

### 题解-2020年6月25日

```java
public class P1299_ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if(n == 0) return arr;
        int max = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        arr[n - 1] = -1;
        return arr;
    }
}
```

## [1304. Find N Unique Integers Sum up to Zero](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/)

### 题解-2020年6月26日

```java
public class P1304_FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int left = 0, right = n - 1, start = 1;
        while (left < right) {
            res[left++] = start;
            res[right--] = -start;
            start++;
        }
        return res;
    }
}
```

## [1309. Decrypt String from Alphabet to Integer Mapping](https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/)

### 题解-2020年6月27日

```java
public class P1309_DecryptStringfromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        if (null==s||s.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            int tmp = 0;
            if (s.charAt(i)=='#') {
                i--;
                tmp = s.charAt(i) - '0';
                i--;
                tmp += 10*(s.charAt(i) - '0');
                i--;
                char alph = (char) ('a' + tmp - 1);
                sb.append(alph);
            }else {
                tmp = s.charAt(i) - '0';
                i--;
                char alph = (char) ('a' + tmp - 1);
                sb.append(alph);
            }
        }
        return sb.reverse().toString();
    }
}
```

## [1313. Decompress Run-Length Encoded List](https://leetcode.com/problems/decompress-run-length-encoded-list/)

### 题解-2020年6月28日

```java
public class P1313_DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }

        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }
}
```

## [1317. Convert Integer to the Sum of Two No-Zero Integers](https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/)

### 题解-2020年6月29日

```java
public class P1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int a=0, b=0, step=1;
        while (n>0) {
            int d = n % 10; // digit
            n /= 10;

            if ((d == 0 || d == 1) && n>0) { // n>0 evades the case when 1 is the most significant digit
                a += step*(1+d);
                b += step*9;
                n--; // handle carry
            } else {
                a += step*1;
                b += step*(d-1);
            }
            step *= 10;
        }
        return new int[]{a,b};
    }
}
```

## [1323. Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)

### 题解-2020年6月30日

```java
public class P1323_Maximum69Number {
    public int maximum69Number (int num) {
        char[] numString = String.valueOf(num).toCharArray();
        for (int i = 0; i < numString.length; i++) {
            if (numString[i] == '6') {
                numString[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numString));
    }

    public static void main(String[] args) {
        System.out.println(new P1323_Maximum69Number().maximum69Number(9669));
    }
}
```

## [1331. Rank Transform of an Array](https://leetcode.com/problems/rank-transform-of-an-array/)

### 题解-2020年7月1日

```java
public class P1331_RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            map.put(num, rank++);
        }
        int[] ranks = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }
}
```

## [1332. Remove Palindromic Subsequences](https://leetcode.com/problems/remove-palindromic-subsequences/)

### 题解-2020年7月2日

```java
public class P1332_RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 1;
        else return 2;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!(s.charAt(left++) == s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }
}
```

## [1337. The K Weakest Rows in a Matrix](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)

### 题解-2020年7月3日

```java
public class P1337_TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        int[] ans = new int[k];
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{numOnes(mat[i]), i});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) {
            ans[--k] = pq.poll()[1];
        }
        return ans;
    }

    private int numOnes(int[] row) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (row[m] == 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
```

## [1342. Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

### 题解-2020年7月4日

```java
public class P1342_NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps (int n) {
        int steps = 0;
        while ( n != 0) {
            steps++;
            n = n % 2 == 0 ? n / 2 : n - 1;
        }

        return steps;
    }
}
```

## [1346. Check If N and Its Double Exist](https://leetcode.com/problems/check-if-n-and-its-double-exist/)

### 题解-2020年7月5日

```java
public class P1346_CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int zeroCount = 0;
        for (int x : arr) {
            if (x != 0) {
                if (binarySearch(x, arr) && binarySearch(x*2, arr)) {
                    return true;
                }
            }
            else {
                ++zeroCount;
            }
        }
        return zeroCount >= 2;
    }

    public boolean binarySearch(int x, int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + ((end-start)>>>1);
            if (nums[mid] < x) {
                start = 1 + mid;
            }
            else if (nums[mid] > x) {
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
```

## [1351. Count Negative Numbers in a Sorted Matrix](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/)

### 题解-2020年7月6日

```java
public class P1351_CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            ans += numNegative(grid[i]);
        }
        return ans;

    }

    private int numNegative(int[] row) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = l + ((r - l) >>> 1);
            if (row[m] < 0) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return row.length-l;
    }
}
```

## [1356. Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)

### 题解-2020年7月7日

```java
public class P1356_SortIntegersbyTheNumberof1Bits {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        for (int a : arr) {
            int count = calcualte1Bit(a);
            minHeap.offer(new int[]{count, a});
        }
        int[] res = new int[arr.length];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll()[1];
        }
        return res;
    }
    private int calcualte1Bit(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
```

## [1360. Number of Days Between Two Dates](https://leetcode.com/problems/number-of-days-between-two-dates/)

### 题解-2020年7月8日

```java
public class P1360_NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = days(date1);
        int days2 = days(date2);
        return Math.abs(days1 - days2);
    }

    int[] mdays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    // days from 1900-1-0
    private int days(String d) {
        String[] ss = d.split("-");
        int year = Integer.valueOf(ss[0]);
        int month = Integer.valueOf(ss[1]);
        int day = Integer.valueOf(ss[2]);
        // years we spent, hence -1 because current year is not spent yet
        int ydelta = year - 1 - 1900;
        int dy = ydelta * 365 + ydelta / 4;// from 1900 every 4 years is leap year
        // month-1, current month is not done yet
        int dm = mdays[month - 1];
        if (isleap(year) && month - 1 >= 2) {
            dm++;
        }
        return dy + dm + day;
    }

    private boolean isleap(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
    }
}
```
