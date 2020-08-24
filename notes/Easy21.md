# LeetCode-Easy19-Top401_420

-   Problems-ID：1441、1446、1450、1455、1460、1464、 **1469** 、1470、 **1474** 、1475、1480、 **1484** 、1486、1491、 **1495** 、1496、1502、1507、 **1511** 、1512

## [1441. Build an Array With Stack Operations](https://leetcode.com/problems/build-an-array-with-stack-operations/)

### 题解-2020年7月24日

```java
public class P1441_BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i=1;i<=n && j<target.length;i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}
```

## [1446. Consecutive Characters](https://leetcode.com/problems/consecutive-characters/)

### 题解-2020年7月25日

```java
public class P1446_ConsecutiveCharacters {
    public int maxPower(String s) {
        int n = s.length();
        int start = 0, end = 0, max = 0;
        while(end < n) {
            while(end < n && s.charAt(end) == s.charAt(start)) {
                max = Math.max(max, end - start + 1);
                end++;
            }
            if(end == n) return max;
            start = end;
        }
        return max;
    }
}
```

## [1450. Number of Students Doing Homework at a Given Time](https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/)

### 题解-2020年7月26日

```java
public class P1450_NumberOfStudentsDoingHomeworkataGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; ++i) {
            res += startTime[i] <= queryTime && queryTime <= endTime[i] ? 1 : 0;
        }
        return res;
    }
}
```

## [1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/)

### 题解-2020年7月27日

```java
public class P1455_CheckIfAWordOccursAsAPrefixofAnyWordinaSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
```

## [1460. Make Two Arrays Equal by Reversing Sub-arrays](https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/)

### 题解-2020年7月28日

```java
public class P1460_MakeTwoArraysEqualbyReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
```

## [1464. Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)

### 题解-2020年7月29日

```java
public class P1464_MaximumProductofTwoElementsinanArray {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i:nums){
            if(i>max1){
                max2 = max1;
                max1 = i;
            }
            else if(i>max2){
                max2 = i;
            }
        }
        return (max1-1)*(max2-1);
    }
}
```

## [LOCKED UP]1469.	Find All The Lonely Nodes

## [1470. Shuffle the Array](https://leetcode.com/problems/shuffle-the-array/)

### 题解-2020年7月30日

```java
public class P1470_ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for(int i = 0; i < nums.length; i++)
            res[i] = i % 2 == 0 ? nums[i/2] : nums[n + i/2];
        return res;
    }
}
```

## [LOCKED UP]1474.	Delete N Nodes After M Nodes of a Linked List

## [1475. Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/)

### 题解-2020年7月31日

```java
public class P1475_FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                A[stack.pop()] -= A[i];
            stack.push(i);
        }
        return A;
    }
}
```

## [1480. Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/)

### 题解-2020年8月1日

```java
public class P1480_RunningSumofArray {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
```

## [LOCKED UP]1484.	Group Sold Products By The Date

## [1486. XOR Operation in an Array](https://leetcode.com/problems/xor-operation-in-an-array/)

### 题解-2020年8月2日

```java
public class P1486_XOROperationInanArray {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i=1; i<n; i++){
            res = res ^ (start + 2 * i);
        }
        return res;
    }
}
```

## [LOCKED UP]1495.	Friendly Movies Streamed Last Month

## [1491. Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/)

### 题解-2020年8月3日

```java
public class P1491_AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        double min = salary[0], max = salary[0], sum = 0;
        for(int s : salary){
            min = Math.min(s, min);
            max = Math.max(s, max);
            sum += s;
        }
        return (sum - min - max) / (salary.length-2);
    }
}
```

## [1496. Path Crossing](https://leetcode.com/problems/path-crossing/)

### 题解-2020年8月4日

```java
public class P1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> set = new HashSet();
        set.add(x + "$" + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            String key = x + "$" + y;
            if (set.contains(key))
                return true;
            set.add(key);
        }
        return false;
    }
}
```

## [1502. Can Make Arithmetic Progression From Sequence](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/)

### 题解-2020年8月5日

```java
public class P1502_CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for(int i = 0; i < arr.length - 1; i++)
            if(arr[i + 1] - arr[i] != d)
                return false;
        return true;
    }
}
```

## [1507. Reformat Date](https://leetcode.com/problems/reformat-date/)

### 题解-2020年8月6日

```java
public class P1507_ReformatDate {
    private static final Map<String, String> months = getMonths();
    public String reformatDate(String date) {
        String[] ss = date.split("\\s+");
        StringBuilder sb = new StringBuilder();

        sb.append(ss[2]).append("-");
        sb.append(months.get(ss[1])).append("-");
        sb.append(ss[0].length() == 3 ? ("0" + ss[0].substring(0, 1)) : ss[0].substring(0, 2));
        return sb.toString();
    }

    private static Map<String, String> getMonths(){
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}
```

## [LOCKED UP]1511.	Customer Order Frequency

## [1512. Number of Good Pairs](https://leetcode.com/problems/number-of-good-pairs/)

### 题解-2020年8月7日

```java
public class P1512_NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i])
                count += j - i;
            else i = j;
        }
        return count;
    }
}
```
