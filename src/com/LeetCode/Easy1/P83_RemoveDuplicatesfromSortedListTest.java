package com.LeetCode.Easy1;

public class P83_RemoveDuplicatesfromSortedListTest {
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(2);
        head.next = a;
        a.next = b;
        a = new ListNode(3);
        b.next = a;
        b = new ListNode(4);
        a.next = b;
        b.next = null;
        RemoveDuplicatesfromSortedList temp = new RemoveDuplicatesfromSortedList();
        ListNode ans = temp.deleteDuplicates(head);
        temp.display(ans);
    }
}

class RemoveDuplicatesfromSortedList {
    ListNode deleteDuplicates(ListNode head) {
        if(head == null|| head.next == null) return head;
        ListNode listIndex = head;
        while(listIndex.next != null) {
            if (listIndex.val == listIndex.next.val) {//与下一个相同，跳过
                listIndex.next = listIndex.next.next;
            } else {
                listIndex = listIndex.next;
            }
        }
        return head;
    }
    void display(ListNode L){
        while (L!=null){
            System.out.print(L.val+" ");
            L = L.next;
        }
    }
}