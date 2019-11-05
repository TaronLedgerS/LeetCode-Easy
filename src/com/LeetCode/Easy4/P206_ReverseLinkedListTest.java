package com.LeetCode.Easy4;

public class P206_ReverseLinkedListTest {
    public static void main(String[] args) {
        ListNode l1 = new  ListNode(1);
        ListNode a = new  ListNode(2);
        ListNode b = new  ListNode(4);
        ListNode c = new  ListNode(2);
        l1.next = a;
        a.next = b;
        b.next = c;
        c.next = null;
        ReverseLinkedList temp = new ReverseLinkedList();
        System.out.println(temp.reverseList(l1));
    }
}
class ListNode {
    private int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
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