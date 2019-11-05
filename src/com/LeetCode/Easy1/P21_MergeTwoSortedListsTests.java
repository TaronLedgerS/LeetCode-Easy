package com.LeetCode.Easy1;

public class P21_MergeTwoSortedListsTests {
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
        b.next = null;
        MergeTwoSortedLists temp = new MergeTwoSortedLists();
        ListNode ans = temp.mergeTwoLists(l1,l2);
        temp.display(ans);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MergeTwoSortedLists{
     ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;//用来存储最终结果的第一个节点

        if (l1.val <= l2.val) {//
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        //移动的“光标”，引用最后一个纳入结果列表的节点
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2:l1;
        return head;
    }
    void display(ListNode L){
         while (L!=null){
             System.out.print(L.val+" ");
             L = L.next;
         }
    }
}

