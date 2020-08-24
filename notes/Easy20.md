[TOC]

# LeetCode-Easy20-Top381_400

-   Problems-ID： 1365、1370、1374、 **1378** 、1380、1385、1389、1394、1399、1403、 **1407** 、1408、1413、1417、1422、 **1426** 、 **1427** 、1431、1435、1436

## [1365. How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

### 题解-2020年7月9日

```java
public class P1365_HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }
        return res;
    }

}
```

## [1370. Increasing Decreasing String](https://leetcode.com/problems/increasing-decreasing-string/)

### 题解-2020年7月10日

```java
public class P1370_IncreasingDecreasingString {
    public String sortString(String s) {
        int len = s.length();
        int[] freq = new int[26];
        for (int index = 0; index < len; index++) {
            freq[s.charAt(index) - 'a']++;
        }
        StringBuilder sb = new StringBuilder(len);
        int count = 0;
        while (count < len) {
            // sorting up
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
            // sorting down
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
        }
        return sb.toString();
    }
}
```

## [1374. Generate a String With Characters That Have Odd Counts](https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/)

### 题解-2020年7月11日

```java
public class P1374_GenerateaStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        char[] str = new char[n];
        Arrays.fill(str, 'a');
        if(n%2==0) {
            str[0] = 'b';
        }
        return new String(str);
    }

}
```

## [LOCKED UP]1378.	Replace Employee ID With The Unique Identifier

## [1380. Lucky Numbers in a Matrix](https://leetcode.com/problems/lucky-numbers-in-a-matrix/)

### 题解-2020年7月12日

```java
public class P1380_LuckyNumbersinaMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        for (int row = 0; row < matrix.length; row++) {
            int minCol = minColInRow(matrix, row);
            int value = matrix[row][minCol];
            if (checkIfMaxInCol(matrix, minCol, value)) {
                result.add(value);
            }
        }

        return result;
    }

    private int minColInRow(int[][] matrix, int row) {
        int minIndex = 0, min = matrix[row][minIndex];
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] < min) {
                min = matrix[row][col];
                minIndex = col;
            }
        }
        return minIndex;
    }

    private boolean checkIfMaxInCol(int[][] matrix, int col, int value) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > value) return false;
        }
        return true;
    }
}
```

## [1385. Find the Distance Value Between Two Arrays](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)

### 题解-2020年7月13日

```java
public class P1385_FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int distance = length1;
        for(int i=0; i<length1; i++){
            for(int j=0; j<length2; j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    distance -= 1;
                    break;
                }
            }

        }
        return distance;
    }
}
```

## [1389. Create Target Array in the Given Order](https://leetcode.com/problems/create-target-array-in-the-given-order/)

### 题解-2020年7月14日

```java
public class P1389_CreateTargetArrayintheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            a.add(index[i],nums[i]);
        }
        int target[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            target[i] = a.get(i);
        }
        return target;
    }
}
```

## [1394. Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)

### 题解-2020年7月15日

```java
public class P1394_FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int ans = -1;
        for (int a : map.keySet()) {
            if (a == map.get(a)) {
                if (a>ans) ans = a;
            }
        }
        return ans;
    }
}
```

## [1399. Count Largest Group](https://leetcode.com/problems/count-largest-group/)

### 题解-2020年7月16日

```java
public class P1399_CountLargestGroup {
    int dsum(int n) {
        return n == 0 ? 0 : n % 10 + dsum(n / 10);
    }
    public int countLargestGroup(int n) {
        ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));
        for (int i = 1; i <= n; ++i) {
            int c = dsum(i);
            cnt.set(c, cnt.get(c) + 1);
        }
        return Collections.frequency(cnt, Collections.max(cnt));
    }
}
```

## [1403. Minimum Subsequence in Non-Increasing Order](https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/)

### 题解-2020年7月17日

```java
public class P1403_MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> arr=new ArrayList<>();
        long sum=0;
        for(int i:nums)
            sum+=i;
        long ans=0;
        for(int i=nums.length-1;i>=0;i--){
            arr.add(nums[i]);
            ans+=nums[i];
            if(ans>sum-ans)
                return arr;
        }
        return arr;
    }
}
```

## [LOCKED UP]1407.	Top Travellers

## [1408. String Matching in an Array](https://leetcode.com/problems/string-matching-in-an-array/)

### 题解-2020年7月18日

```java
public class P1408_StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            while (j < words.length) {
                int index = words[j++].indexOf(words[i]);
                if (index != -1) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
```

## [1413. Minimum Value to Get Positive Step by Step Sum](https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/)

### 题解-2020年7月19日

```java
public class P1413_MinimumValueToGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        int sum = 0, min_sum = 0;
        for (int n : nums) {
            sum += n;
            min_sum = Math.min(min_sum, sum);
        }
        return 1 - min_sum;
    }
}
```

## [1417. Reformat The String](https://leetcode.com/problems/reformat-the-string/)

### 题解-2020年7月20日

```java
public class P1417_ReformatTheString {
    public String reformat(String s) {
        if (s == null || s.length() == 0) return "";
        int ds = 0, as = 0;
        char[] arr = s.toCharArray(), res = new char[s.length()];
        for (char c : arr) {
            if (Character.isDigit(c)) ds++;
            else if (Character.isLetter(c)) as++;
            else return "";
        }
        if (Math.abs(as - ds) > 1) return "";
        boolean isDigit = ds >= as;
        for (int i = 0, d = 0, a = 0; i < arr.length; i++) {
            if (isDigit) {
                while (!Character.isDigit(arr[d])) d++;
                res[i] = arr[d++];
            } else {
                while (!Character.isLetter(arr[a])) a++;
                res[i] = arr[a++];
            }
            isDigit = !isDigit;
        }
        return String.valueOf(res);
    }
}
```

## [1422. Maximum Score After Splitting a String](https://leetcode.com/problems/maximum-score-after-splitting-a-string/)

### 题解-2020年7月21日

```java
public class P1422_MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') zeros++; else ones++;
            if(i != s.length()-1) max = Math.max(zeros - ones, max);
        }
        return max + ones;
    }
}
```

## [LOCKED UP]1426.	Counting Elements

## [LOCKED UP]1427.	Perform String Shifts

## [1431. Kids With the Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)

### 题解-2020年7月22日

```java
public class P1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] cs, int e) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();
        for (int n : cs) max = Math.max(n, max);
        for (int n : cs) res.add(n + e >= max);
        return res;
    }
}
```

## [LOCKED UP]1435.	Create a Session Bar Chart

## [1436. Destination City](https://leetcode.com/problems/destination-city/)

### 题解-2020年7月23日

```java
public class P1436_DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> set= new HashSet<>();
        for (List<String> l: paths) set.add(l.get(1));
        for (List<String> l: paths) set.remove(l.get(0));
        return set.iterator().next();
    }
}
```
