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

### 题解(树)-2019年11月4日

## [LOCKED UP]170.Two Sum III
