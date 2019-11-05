package com.LeetCode.Easy3;

public class P203_RemoveLinkedListElementsTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(2);
        l1.next = a;
        a.next = b;
        b.next = c;
        c.next = null;
        RemoveLinkedListElements temp = new RemoveLinkedListElements();
        System.out.println(temp.removeElements(l1,2));

    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class RemoveLinkedListElements{
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