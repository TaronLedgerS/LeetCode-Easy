package com.LeetCode.Easy13;

public class P876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head.next==null) return head;
        ListNode FNode = head;
        ListNode BNode = head;
        while(true){
            BNode = BNode.next;
            FNode = FNode.next;
            if(FNode.next==null||FNode.next.next==null)
                return BNode;
            FNode = FNode.next;
        }
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}