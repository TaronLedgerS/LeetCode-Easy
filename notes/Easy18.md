[TOC]

# LeetCode-Easy18-Top341_360

-   Problems-ID：1207、 **1211** 、 **1213** 、1217、1221、 **1228** 、1232、1237、 **1241** 、 **1243** 、 **1251** 、1252、1260、1266、 **1271** 、1275、 **1279** 、 **1280** 、1281、1287

## [1207. Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)

### 题解-2020年6月12日

```java
public class P1207_UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        //array to store number of occurances
        int[] c = new int[2001];
        //count occurance of each value
        for (int n : arr) {
            c[n+1000]++;
        }
        //check unique occurances (except for 0)
        Set<Integer> set = new HashSet();
        for (int count : c) {
            if (count == 0)
                continue;
            if (!set.add(count))
                return false;
        }
        return true;
    }
}
```

## [LOCKED UP]1211.	Queries Quality and Percentage

## [LOCKED UP]1213.	Intersection of Three Sorted Arrays

## [1217. Play with Chips](https://leetcode.com/problems/play-with-chips/)

### 题解-2020年6月13日

```java
public class P1217_PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        int[] cnt = new int[2];
        for (int chip : chips)
            ++cnt[chip % 2];
        return Math.min(cnt[0], cnt[1]);
    }
}
```

## [1221. Split a String in Balanced Strings](https://leetcode.com/problems/split-a-string-in-balanced-strings/)

### 题解-2020年6月14日

```java
public class P1221_SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }
}
```

## [LOCKED UP]1228.	Missing Number In Arithmetic Progression

## [1232. Check If It Is a Straight Line](https://leetcode.com/problems/check-if-it-is-a-straight-line/)

### 题解-2020年6月15日

```java
public class P1232_CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1],
                x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
```

## [1237. Find Positive Integer Solution for a Given Equation](https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/)

### 题解-2020年6月16日

```java
public class P1237_FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0) {
            int v = customfunction.f(x, y);
            if (v > z) --y;
            else if (v < z) ++x;
            else res.add(Arrays.asList(x++, y--));
        }
        return res;
    }
}
```

## [LOCKED UP]1241.	Number of Comments per Post

## [LOCKED UP]1243.	Array Transformation

## [LOCKED UP]1251.	Average Selling Price

## [1252. Cells with Odd Values in a Matrix](https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/)

### 题解-2020年6月17日

```java
public class P1252_CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n], oddCols = new boolean[m];
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
            }
        }
        return cnt;
    }
}
```

## [1260. Shift 2D Grid](https://leetcode.com/problems/shift-2d-grid/)

### 题解-2020年6月18日

```java
public class P1260_Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] temp = new int[grid.length][grid[0].length]; // took temp grid
        int n = grid.length;
        int m = grid[0].length;
        int mod = n * m;
        k = k % mod; // minimize the k value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int p = j + k; // defines which col
                int r = p / (m); // defines which row
                if (p < m) {
                    temp[i][p] = grid[i][j];
                } else {
                    temp[(i + r) % n][p % m] = grid[i][j];
                }
            }
        }
        // making temp grid into list
        List<List<Integer>> result = new LinkedList<>();
        for (int[] t : temp) {
            LinkedList<Integer> c = new LinkedList<>();
            for (int i : t) {
                c.add(i);
            }
            result.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1260_Shift2DGrid().shiftGrid(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}},1
        ));
    }
}
```

## [1266. Minimum Time Visiting All Points](https://leetcode.com/problems/minimum-time-visiting-all-points/)

### 题解-2020年6月19日

```java
public class P1266_MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;
        for (int i = 0; i < n-1; i++) {
            int deltaX = Math.abs(points[i+1][0] - points[i][0]);
            int deltaY = Math.abs(points[i+1][1] - points[i][1]);
            ans += Math.max(deltaX, deltaY) ;
        }
        return ans;
    }
}
```

## [LOCKED UP]1271.	Hexspeak

## [1275. Find Winner on a Tic Tac Toe Game](https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/)

### 题解-2020年6月20日

```java
public String tictactoe(int[][] moves) {
	int n = moves.length;
	if (n < 5) {
		return "Pending";
	} else if (n < 9) {
		if (wonByLastMove(moves)) {
			return n % 2 == 1 ? "A" : "B";
		} else {
			return "Pending";
		}
	}
	return wonByLastMove(moves) ? "A" : "Draw";
}

private boolean wonByLastMove(int[][] moves) {
	int[] lastMove = moves[moves.length-1];
	int row = 1, col = 1, diag = 1, revDiag = 1;

	for (int i = moves.length-3; i >= 0; i -= 2) {
		int[] curr = moves[i];
		if (curr[0] == lastMove[0]) row++;
		if (curr[1] == lastMove[1]) col++;
		if (curr[0] == curr[1] && lastMove[0] == lastMove[1]) diag++;
		if (curr[0] + curr[1] == 2 && lastMove[0] + lastMove[1] == 2) revDiag++;
	}
	return row == 3 || col == 3 || diag == 3 || revDiag == 3;
}
```

## [LOCKED UP]1279.	Traffic Light Controlled Intersection

## [LOCKED UP]1280.	Students and Examinations

## [1281. Subtract the Product and Sum of Digits of an Integer](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)

### 题解-2020年6月21日

```java
public class P1281_SubtractTheProduceAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        if (n==0) return 0;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            sum += temp;
            product *= temp;
        }
        return  product - sum;
    }
}
```

## [1287. Element Appearing More Than 25% In Sorted Array](https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/)

### 题解-2020年6月22日

```java
public class P1287_ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++) {
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }
}
```

## [1290. Convert Binary Number in a Linked List to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)

### 题解-2020年6月23日

```java
public class P1290_ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;

        }
        return ans;
    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```
