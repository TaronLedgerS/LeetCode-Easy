package com.LeetCode.Easy2;


import java.util.HashSet;
import java.util.Set;

public class P141_LinkedListCycleTest {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        l1.next = a;
        a.next = b;
        b.next = null;
        ListNode l2 = new ListNode(1);
        a = new ListNode(3);
        b = new ListNode(4);
        l2.next = a;
        a.next = b;
        b.next = a;
        LinkedListCycle temp = new LinkedListCycle();
        System.out.println(temp.hasCycle(l1));
        System.out.println(temp.hasCycle(l2));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class LinkedListCycle{
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}