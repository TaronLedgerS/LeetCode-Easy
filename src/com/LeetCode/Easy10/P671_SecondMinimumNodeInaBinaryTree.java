package com.LeetCode.Easy10;

import java.util.LinkedList;
import java.util.Queue;

public class P671_SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        boolean isExist1 = false;
        boolean isExist2 = false;
        Queue<TreeNode> toTraversal = new LinkedList<>();
        toTraversal.offer(root);
        while (!toTraversal.isEmpty()) {
            TreeNode node = toTraversal.poll();
            if (node.left!=null) toTraversal.offer(node.left);
            if (node.right!=null) toTraversal.offer(node.right);
            if (!isExist1) {
                min1 = node.val;
                isExist1 = true;
            } else if (min1 > node.val) {
                min2 = min1;
                min1 = node.val;
                if (!isExist2) isExist2 = true;
            }else if (min1<node.val){
                if (!isExist2){
                    min2 = node.val;
                    isExist2 = true;
                }else{
                    if (min2>node.val) min2 = node.val;
                }
            }
        }
        return isExist2?min2:-1;
    }
    public static void main(String[] args) {
        System.out.println(
                new P671_SecondMinimumNodeInaBinaryTree().findSecondMinimumValue(
                        StringToTreeNode.stringToTreeNode("2,2,2147483647")
                )
        );
    }
}
