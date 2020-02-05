package com.LeetCode.Easy9;

import java.util.LinkedList;
import java.util.Queue;

public class StringToTreeNode {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
        String[] nodes = input.split(",");
        String item = nodes[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            //左子节点
            if (index == nodes.length) {
                break;
            }
            item = nodes[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
            //右子节点
            if (index == nodes.length) {
                break;
            }
            item = nodes[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode((rightNumber));
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
