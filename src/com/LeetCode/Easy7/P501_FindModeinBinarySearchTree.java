package com.LeetCode.Easy7;

import java.util.*;

public class P501_FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if (root==null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int max=0;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            if (node.left != null) {
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }

            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            max = Math.max(max, map.get(node.val));
        }

        List<Integer> mode = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                mode.add(key);
            }
        }

        int[] res = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

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
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new P501_FindModeinBinarySearchTree().findMode(stringToTreeNode("1,null,2,2"))
        ));

    }
}
