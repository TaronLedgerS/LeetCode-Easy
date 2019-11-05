package com.LeetCode.Easy2;

import javafx.util.Pair;

import java.util.LinkedList;


public class P104_MaximumDepthofBinaryTreeTest {
    public static void main(String[] args){
        TreeNode l1 = new TreeNode (1);
        TreeNode  a = new TreeNode (2);
        TreeNode  b = new TreeNode (2);
        l1.left = a;
        l1.right = b;
        a.left = new TreeNode (3);
        a.right = new TreeNode (3);
        b.left = new TreeNode (4);
        b.right = new TreeNode (3);

        MaximumDepthofBinaryTree temp = new MaximumDepthofBinaryTree();
        System.out.println(temp.maxDepthDFS(l1));
        System.out.println(temp.maxDepthDFS(l1));
    }
}
class MaximumDepthofBinaryTree {
     int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepthDFS(root.left);
            int right_height = maxDepthDFS(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
    public int maxDepthBFS(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                queue.add(new Pair(root.left, current_depth + 1));
                queue.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }
}
