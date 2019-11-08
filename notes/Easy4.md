[TOC]

# LeetCode-Easy4-Top61_80

-   Problems-ID:205、206、217、219、225、226、231、232、234、235、237、242、243、246、252、256、257、258、263、266

## [205.Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

### 题解-2018年11月23日

-   判断同构字符串如 s = "egg", t = "add"
-   之前出现过的两个同位置字母，将继续保持映射关系，如e-a，g-d
-   关键再在于保证每一个位置上的一对字母映射关系与上一次是否保持一致

```java
class IsomorphicString{
    public boolean isIsomorphic(String s1, String s2) {
        int[] lastS1 = new int[256];
        int[] lastS2 = new int[256];
        //初始出现均属于同构，两个数组初始化为0
        for (int i = 0; i < s1.length(); i++) {
            //判断当前位置上这一对字母映射上一次出现的位置是否相同
            if (lastS1[s1.charAt(i)] != lastS2[s2.charAt(i)])
                return false;
            //相同则，更新最新位置信息
            lastS1[s1.charAt(i)] = lastS2[s2.charAt(i)] = i+1;
        }
        return true;
    }
}
```

## [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

### 题解(递归)-2018年11月24日

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

```java
class ReverseLinkedList{
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)//输入为空或到最后的节点
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;//newHead为原来最后一个节点
    }
}
```

## [217.Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

### 题解(哈希set)-2018年11月25日

-   判断数组中，是否有重复元素
-   排序后比较
-   哈希

```java
class ContainsDuplicate{
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for(int x:nums){
            if (hashset.contains(x)){
                return true;
            }
            hashset.add(x);
        }
        return false;
    }
}
```

## [219.Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)

### 题解(哈希set)-2018年11月26日

-   数组内间隔k是否出现相同元素

```java
class ContainsDuplicateII{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
```

## [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

### 题解(栈)-2018年11月27日

-   用一个队列实现栈的push、pop、top功能,push时间复杂度O（n），其他为O（1）

```java
class MyStack {
  Queue<Integer> q = new LinkedList<Integer>();
  // Push element x onto stack.
  public void push(int x) {
	  q.add(x);
	  int n = q.size();
	  while (n-- > 1)
		  q.add(q.poll());
  }
  // Removes the element on top of the stack.
  public int pop() {
	 return q.poll();
  }
  // Get the top element.
  public int top() {
	  return q.peek();
  }
  // Return whether the stack is empty.
  public boolean empty() {
	  return q.isEmpty();
  }
}
```

## [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

### 题解(树)-2019年11月5日

-   递归，树左右翻转

    ```java
    class InvertBinaryTree {
         TreeNode invertTree(TreeNode root) {
             if(null == root){
                 return null;
             }
            TreeNode tleft = invertTree(root.left);
            TreeNode tright = invertTree(root.right);
            root.left = tright;
            root.right = tleft;
            return root;
        }
    }
    ```

## [231. Power of Two](https://leetcode.com/problems/power-of-two/)

### 题解（位运算）-2019年11月6日

-   判断给出的数是否为2次幂→是否转换为二进制后只有最高位是1其余位是0
-   法一：逐位除2取余判断
-   法二：位运算
-   法四：>>=与>>的区别在于前者会更改原值，[位运算](Java中的移位运算符)

```java
class PowerofTwo{
    boolean isPowerOfTwo1(int n) {
        if (n==0) return false;
        while(n%2 == 0){
            n = n / 2;
        }
        return n == 1;
    }
    boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
    boolean isPowerOfTwo3(int n) {
        if (n==0) return false;
        int ones = 0;
        for (int i = 1; i <= 64; ++i) {
            ones += n & 1;//统计1的个数
            n = n >> 1;
        }
        return ones == 1;//只有一个1位正确结果
    }
    boolean isPowerOfTwo4(int n) {
        int shifts=(n==1)?0:1;
        for( int temp=n; (temp>>=1)>1; shifts++ );
        return n==(1<<shifts);
    }
}
```

## [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

### [题解（栈）-2019年11月7日](https://leetcode.com/problems/implement-queue-using-stacks/solution/)

-   法一：(Two Stacks)栈顶当队首 Push - O(n) per operation, Pop - O(1) per operation.
    ```java
    class MyQueue {
        private Stack<Integer>  s1 = new Stack<>();
        private Stack<Integer>  s2 = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {
        }
        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!s1.empty())
                s2.push(s1.pop());
            s1.push(x);
            while (!s2.empty())
                s1.push(s2.pop());
        }
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return s1.pop();
        }
        /** Get the front element. */
        public int peek() {
            return s1.peek();
        }
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.empty();
        }
    }
    ```
-   法二：(Two Stacks) 栈顶当队尾Push - O(1) per operation, Pop - O(1) per operation.
    ```java
    class MyQueue2 {
        private Stack<Integer>  s1 = new Stack<>();//栈顶当队尾
        private Stack<Integer>  s2 = new Stack<>();
        private int front;
        /** Initialize your data structure here. */
        public MyQueue2() {
        }
        /** Push element x to the back of queue. */
        public void push(int x) {
            if (s1.empty()) {
                front=x;
            }
            s1.push(x);
        }
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            int a = s2.pop();
            if (!s2.empty()) {
                front = s2.peek();
            } else {
                front = -1;
            }
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
            return a;
        }
        /** Get the front element. */
        public int peek() {
            return front;
        }
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.empty();
        }
    }
    ```

## [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

### 题解（链表操作）- 2019年11月8日

-   判断一个单链表是否回文：翻转链表的后半段，逐个比较
    ```java
    public boolean isPalindrome(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	if (fast != null) {//保证左边比右边多
    		slow = slow.next;//右半部的开头
    	}
    	slow = reverse(slow);
    	fast = head;
    	while (slow != null) {
    		if (fast.val != slow.val) {
    			return false;
    		}
    		fast = fast.next;
    		slow = slow.next;
    	}
    	return true;
    }
    public ListNode reverse(ListNode head) {
    	ListNode prev = null;
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }
    ```

## [LOCKED UP]170.Two Sum III
