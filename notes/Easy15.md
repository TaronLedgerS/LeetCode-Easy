[TOC]

# LeetCode-Easy15-Top281_300

-   Problems-ID：1002、1005、1009、1010、1013、1018、1021、1022、1025、1029、1030、1033、1037、1042、1046、1047、1050、1051、1056、1064、

## [1002. Find Common Characters](https://leetcode.com/problems/find-common-characters/)

### 题解-2020年5月8日

```java
public class P1002_FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {

            int minCount = Integer.MAX_VALUE;
            for (String s : A) {
                int count = 0;
                for (char ch:s.toCharArray())
                    if (ch==c) count++;
                minCount = Math.min(minCount, count);
            }
            for (int i = 0; i < minCount; i++)
                result.add("" + c);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1002_FindCommonCharacters().commonChars(
                new String[]{
                        "bella","label","roller"
                }
        ));
    }
}
```

## [1005. Maximize Sum Of Array After K Negations](https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/)

### 题解（小顶堆）-2020年5月9日

```java
public class P1005_MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int result = 0;
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int a:A) minHeap.offer(a);

        while (K > 0) {
            int a = minHeap.remove();
            if (a < 0) {
                minHeap.offer(-a);
            } else {
                K = K % 2;
                if (K > 0) {
                    minHeap.offer(-a);
                } else {
                    minHeap.offer(a);
                }
            }
            K--;
        }

        for (int a:minHeap) result += a;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1005_MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(
                new int[]{2,-3,-1,5,-4},2
        ));
    }
}
```

## [1009. Complement of Base 10 Integer](https://leetcode.com/problems/complement-of-base-10-integer/)

### 题解（位运算-异或）-2020年5月10日

```java
public class P1009_ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 1) return 0;
        if (N == 0) return 1;
        int X = 1;
        while (X <= N) {
            X = X << 1;
        }
        return N ^ (X - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P1009_ComplementOfBase10Integer().bitwiseComplement(7));
    }
}
```

## [1010. Pairs of Songs With Total Durations Divisible by 60](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)

### 题解（打表）-2020年5月11日

```java
public class P1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] count = new int[60];
        for (int a : time) count[a % 60]++;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) res += (count[i]) * (count[i] - 1) / 2;
            else
                res += count[i] * count[60 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1010_PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(
                new int[]{30, 20, 150, 100, 40}
        ));
    }
}
```

## [1013. Partition Array Into Three Parts With Equal Sum](https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/)

### 题解（边界）-2020年5月12日

```java
public class P1013_PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int allSum = 0;
        for (int a : A) allSum += a;
        if (allSum % 3 != 0) return false;
        int numOfPart = 0;
        int curSum = 0;
        allSum /= 3;
        for (int i = 0;i<A.length;i++) {
            curSum += A[i];
            if (allSum == curSum) {
                numOfPart++;
                curSum = 0;
            }
        }
        return numOfPart >= 3;
    }

    public static void main(String[] args) {
        System.out.println(new P1013_PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSum(
                new int[]{1, -1, 1, -1}
        ));
    }
}
```

## [1018. Binary Prefix Divisible By 5](https://leetcode.com/problems/binary-prefix-divisible-by-5/)

### 题解-2020年5月13日

## [1021. Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/)

### 题解-2020年5月14日

## [1022. Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)

### 题解-2020年5月15日

## [1025. Divisor Game](https://leetcode.com/problems/divisor-game/)

### 题解-2020年5月16日

## [1029. Two City Scheduling](https://leetcode.com/problems/two-city-scheduling/)

### 题解-2020年5月17日

## [1030. Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)

### 题解-2020年5月18日

## [1033. Moving Stones Until Consecutive](https://leetcode.com/problems/moving-stones-until-consecutive/)

### 题解-2020年5月19日

## [1037. Valid Boomerang](https://leetcode.com/problems/valid-boomerang/)

### 题解-2020年5月20日

## [1042. Flower Planting With No Adjacent](https://leetcode.com/problems/flower-planting-with-no-adjacent/)

### 题解-2020年5月21日

## [1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)

### 题解-2020年5月22日

## [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

### 题解-2020年5月23日

## [LOCKED UP]1050.	Actors and Directors Who Cooperated At Least Three Times

## [1051. Height Checker](https://leetcode.com/problems/height-checker/)

### 题解-2020年5月24日

## [LOCKED UP]1056.	Confusing Number

## [LOCKED UP]1064.	Fixed Point
