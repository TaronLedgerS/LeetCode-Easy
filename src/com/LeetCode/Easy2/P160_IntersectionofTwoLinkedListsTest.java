package com.LeetCode.Easy2;

public class P160_IntersectionofTwoLinkedListsTest{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        l1.next = a;
        a.next = b;
        b.next = null;
        ListNode l2 = new ListNode(1);
        a = new ListNode(3);
        //b = new ListNode(4);
        l2.next = a;
        a.next = b;
        b.next = null;
        IntersectionofTwoLinkedLists temp = new IntersectionofTwoLinkedLists();
        System.out.println(temp.getIntersectionNode(l1,l2).val);
    }
}

class IntersectionofTwoLinkedLists {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}