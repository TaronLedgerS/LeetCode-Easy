[TOC]

# LeetCode-Easy3-Top41_60

-   Problems-ID:169、171、172、175、176、181、182、183、189、190、191、193、195、196、197、198、202、203、204

## [169.Majority Element](https://leetcode.com/problems/majority-element/)

### 博耶-摩尔多数表决算法-2018年11月4日

-   统计数组的多数元素（出现次数大于一半）
-   [Boyer–Moore majority vote algorithm](https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm)
-   时间复杂度为`math O(n)`，空间复杂度为`math O(1)`

```java
class MajorityElement{
    public int majorityElement(int[] nums) {
        int majorVoteNum = nums[0];
        int count =1;
        for(int i = 1;i<nums.length;i++){
            if (count == 0) {
                majorVoteNum = nums[i];
                count++;
            }else{
                if(majorVoteNum == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return majorVoteNum;
    }
}
```

## [LOCKED UP]170.Two Sum III

## [171.Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)

### 题解-2018年11月5日

-   字符串转化成数字

```java
class ExcelSheetColumnNumber{
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0;i<s.length();i++){
            result = result*26 +(s.charAt(i)-'A'+1);
        }
        return result;
    }
}
```

## [172.Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)

### 题解-2018年11月6日

-   求给定整数的阶乘结果尾随的零的个数(与5有关)

```java
class FactorialTrailingZeroes{
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
```

## [175.Combine Two Tables](https://leetcode.com/problems/combine-two-tables/)

### 题解（SQL题）-2018年11月7日

-   Person表，Address表，列出每个人的地址  
-   左连接

```SQL
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;
```

## [176.Second Highest Salary](https://leetcode.com/problems/second-highest-salary/)

### 题解（SQL题）-2018年11月8日

-   求Salary表第二大  
-   `select * from table limit 2 offset 1;`    
-   含义是从第1条（不包括）数据开始取出2条数据，limit后面跟的是2条数据，offset后面是从第1条开始读取，即读取第2,3条

```SQL
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
```

## [181.Employees Earning More Than Their Managers](https://leetcode.com/problems/employees-earning-more-than-their-managers/)

### 题解（SQL题）-2018年11月9日

-   员工表：ID-NAME-SALARY-MANAGERID，其中最后一列为该员工ID从属于另一个员工MANAGERID
-   找出比他上级更高工资的员工

```SQL
SELECT
    a.Name AS 'Employee'
FROM
    Employee AS a,
    Employee AS b
WHERE
    a.ManagerId = b.Id
        AND a.Salary > b.Salary
```

## [182.Duplicate Emails](https://leetcode.com/problems/duplicate-emails/)

### 题解（SQL题）-2018年11月10日

-   找出出现一次以上的记录

```SQL
select Email
from Person
group by Email
having count(Email) > 1;
```

## [183.Customers Who Never Order](https://leetcode.com/problems/customers-who-never-order/)

### 题解（SQL题）-2018年11月11日

-   Customer表与orders表，找出没有order记录的Customers
-   `not in`

```SQL
select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);
```

## [189.Rotate Array](https://leetcode.com/problems/rotate-array/)

### 题解-2018年11月12日

-   将数组向前移动k位（循环）
-   法一：逐个前移，时间复杂度为`math O(n*k)`，空间复杂度为`math O(1)`
-   法二：新建临时存放数组，时间复杂度为`math O(n)`，空间复杂度为`math O(n)`
-   法三：按步长调整位置，时间复杂度为`math O(n)`，空间复杂度为`math O(1)`
    ![](./images/3-1.png)
-   法四：分块处理，时间复杂度为`math O(n)`，空间复杂度为`math O(1)`
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

```java
class RotateArray{
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

## [190.Reverse Bits](https://leetcode.com/problems/reverse-bits/)

### 题解（位运算）-2018年11月13日

-   求出给定整数的二进制数反转数（先转换成二进制，然后反转，再转换为十进制）

```java
class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
}
```

## [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)

### 题解（位运算）-2018年11月14日

-   统计给定二进制数下1的个数，

```java
class Numberof1Bits{
    public  int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}
```

## [193.Valid Phone Numbers](https://leetcode.com/problems/valid-phone-numbers/)

### 题解（shell+正则表达式）-2018年11月15日

-   提取txt文本中符合 two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit) 格式的记录

        987-123-4567 ✔
        123 456 7890
        (123) 456-7890✔

```Bash
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt

//不知道怎么合起来
grep  '^([0-9]\{3\}) [0-9]\{3\}-[0-9]\{4\}$' file.txt
(123) 456-7890
grep  '^[0-9]\{3\}-[0-9]\{3\}-[0-9]\{4\}$' file.txt
987-123-4567
```

-   ^表示行的开头，[0-9]表示数字范围，`$` 表示行的结束,{3}表示个数，`\(` 表示（
-   AWK是一种处理文本文件的语言，是一个强大的文本分析工具。之所以叫AWK是因为其取了三位创始人 Alfred Aho，Peter Weinberger, 和 Brian Kernighan 的Family Name的首字符。

## [195.Tenth Line](https://leetcode.com/problems/tenth-line/)

### 题解（shell+awk指令）-2018年11月16日

-   输出第十行,`awk 'NR==10' file.txt`

## [196.Delete Duplicate Emails](https://leetcode.com/problems/delete-duplicate-emails/)

### 题解（SQL题）-2018年11月17日

-   delete语句：删除表中重复记录

```SQL
DELETE p1
FROM Person p1,
     Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id
```

## [197. Rising Temperature](https://leetcode.com/problems/rising-temperature/)

### 题解（SQL题-Join）-2018年11月18日

### [Mysql Join语法解析与性能分析](https://www.cnblogs.com/BeginMan/p/3754322.html)

-   Weather表，有每天温度，找出比前一天温度高的记录
-   单纯一个JOIN，会按排列组合来计算，如4个记录与4个记录的表，连接完位16个

```SQL
SELECT Weather.Id
FROM   Weather
       JOIN Weather AS w
         ON w.RecordDate = SUBDATE(Weather.RecordDate, 1)
WHERE  Weather.Temperature > w.Temperature
```

## [198. House Robber](https://leetcode.com/problems/house-robber/)

### 题解（DP）-2018年11月19日

-   给定整数数组，取出的特定元素和最大，要求这些元素不能相邻

-   法一：时间复杂度为`math O(n)`，空间复杂度为`math O(n)`
-   法二：时间复杂度为`math O(n)`，空间复杂度为`math O(1)`

```Java
public int rob1(int[] num) {
	if (num==null|num.length==0) return 0;
    int[][] dp = new int[num.length][2];//分别记录前i个元素，能达到的最大和
	dp[0][0] = 0;//dp[i][0]表示不取当前这个数
	dp[0][1] = num[0];//dp[i][1]表示取当前这个数
    for (int i = 1; i < num.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);//不取
        dp[i][1] = num[i] + dp[i - 1][0];//取
    }
    return Math.max(dp[num.length-1][0], dp[num.length-1][1]);
}


public int rob2(int[] num) {
    if (num==null|num.length==0) return 0;
    int preNo = 0;//表示若不取第i个整数，前i个整数的最大和
    int preYes = num[0];//表示若取第i个整数，前i个整数的最大和
    int temp = 0;
    for (int i = 1; i < num.length; i++) {
        temp = preNo;
        preNo = Math.max(temp,preYes);//不取
        preYes = num[i] + temp;//取
    }
    return Math.max(preNo,preYes);
}
```

## [202. Happy Number](https://leetcode.com/problems/happy-number/)

### 题解（DP）-2018年11月20日

    Input: 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

-   如果不是HappyNumber,那么必定会陷入循环，是同HashSet处理

```java
class HappyNumber{
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum;
        int remain;
        while (inLoop.add(n)) {//如果此set不已经包含了指定的元素，返回true
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum = squareSum + remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }
}
```

## [203.Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)

### 题解（链表-删除操作）-2018年11月21日

-   删除链表中的指定元素

```java
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
```

## [204.Count Primes](https://leetcode.com/problems/count-primes/)

### 题解（链表-删除操作）-2018年11月22日

-   求质数

```java
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
```
