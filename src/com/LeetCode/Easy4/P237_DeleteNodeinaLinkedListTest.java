package com.LeetCode.Easy4;

import java.util.Scanner;

public class P237_DeleteNodeinaLinkedListTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null;
        ListNode temp = null;
        int t;
        while ((t = sc.nextInt()) != -1) {
            ListNode node = new ListNode(t);
            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
            }
        }
        DeleteNodeinaLinkedList myList = new DeleteNodeinaLinkedList();
        if (head != null) {
            myList.deleteNode(head);
        }

    }
}

class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        //用下一节点替换掉当前节点，然后删除下一个节点
        node.val = node.next.val;//用下一个节点覆盖原值
        node.next = node.next.next;//指向下一个节点的下一个节点

    }
}