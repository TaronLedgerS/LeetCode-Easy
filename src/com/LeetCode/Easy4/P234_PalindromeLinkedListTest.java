package com.LeetCode.Easy4;

import java.util.Scanner;

public class P234_PalindromeLinkedListTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int t;
        while ((t = sc.nextInt()) != -1) {
            ListNode tn = new ListNode(t);
            temp.next = tn;
            temp = tn;
        }
        PalindromeLinkedList mylist = new PalindromeLinkedList();
        System.out.println(mylist.isPalindrome(head.next));
    }
}

class PalindromeLinkedList {
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
}
