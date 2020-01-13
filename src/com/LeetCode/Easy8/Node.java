package com.LeetCode.Easy8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    //1,null,
    //2,3,4,5,null,
    //null,6,7,null,8,null,9,10,null,
    //null,11,null,12,null,13,null,null,
    //14
    //null子节点列表结束（或为无子节点）
    public static Node stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }
        String[] nodes = input.split(",");
        //取出根节点，并放入待建子树根节点列表
        int index = 0;
        String item = nodes[index++];
        index++;//根节点后必然跟一个null
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        //循环建树
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            //检查输入是否为空
            if (index == nodes.length) {
                break;
            }
            item = nodes[index++];
            item = item.trim();
            List<Node> _children =new ArrayList<>();
            while (!item.equals("null")) {
                int _val = Integer.parseInt(item);
                Node _node = new Node(_val);
                _children.add(_node);
                nodeQueue.add(_node);
                if (index == nodes.length) {
                    break;
                }
                item = nodes[index++];
                item = item.trim();
            }
            node.children=_children;
        }
        return root;
    }
};