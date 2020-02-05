package com.LeetCode.Easy9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P589_N_aryTreePreorderTraversal {
    List<Integer> preOrderList = new ArrayList<>();
    //递归
    public List<Integer> preorder(Node root) {
        if (root == null  ) return preOrderList;
        preOrderList.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return preOrderList;
    }
    //循环
    public List<Integer> preorderI(Node root) {
        List<Integer> preOrderListI = new ArrayList<>();
        Stack<Node> toTraversal = new Stack<>();
        if (root ==null ) return preOrderListI;
        toTraversal.push(root);
        while (!toTraversal.empty()) {
            Node node = toTraversal.pop();
            preOrderListI.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size()-1;i>=0;i--) {
                    toTraversal.push(node.children.get(i));
                }
            }
        }
        return preOrderListI;
    }
    public static void main(String[] args) {
        System.out.println(
                new P589_N_aryTreePreorderTraversal().preorder(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
        System.out.println(
                new P589_N_aryTreePreorderTraversal().preorderI(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
    }
}

