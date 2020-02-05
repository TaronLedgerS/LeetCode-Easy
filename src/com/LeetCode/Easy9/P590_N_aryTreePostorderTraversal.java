package com.LeetCode.Easy9;

import java.util.*;

public class P590_N_aryTreePostorderTraversal {
    //递归
    List<Integer> postOrderList = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root == null ) return postOrderList;
        if (root.children != null) {
            for (Node node : root.children) {
                postorder(node);
            }
        }
        postOrderList.add(root.val);
        return postOrderList;
    }

    //循环
    public List<Integer> postorderI(Node root) {
        List<Integer> postOrderListI = new ArrayList<>();
        if (root == null ) return postOrderListI;
        Stack<Node> toTraversal = new Stack<>();
        toTraversal.push(root);
        while (!toTraversal.empty()) {
            Node node = toTraversal.pop();
            postOrderListI.add(node.val);
            if (node.children != null) {
                for (Node tNode : node.children) {
                    toTraversal.push(tNode);
                }
            }
        }
        //列表倒置
        Collections.reverse(postOrderListI);
        return postOrderListI;
    }

    public static void main(String[] args) {
        System.out.println(
                new P590_N_aryTreePostorderTraversal().postorder(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
        System.out.println(
                new P590_N_aryTreePostorderTraversal().postorderI(
                        Node.stringToTreeNode("1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14")
                )
        );
    }
}
