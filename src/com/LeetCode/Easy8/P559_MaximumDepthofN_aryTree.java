package com.LeetCode.Easy8;

import java.util.LinkedList;
import java.util.Queue;

public class P559_MaximumDepthofN_aryTree {
    //DFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth=0;
        if (root.children!=null) {
            for (Node node : root.children) {
                maxDepth = Math.max(maxDepth, maxDepth(node));
            }
        }
        return maxDepth+1;
    }
    //BFS
    public int maxDepth_BFS(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            level++;
            int size= queue.size();
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                assert curr != null;
                if (curr.children!=null) {
                    queue.addAll(curr.children);
                }

            }
        }
        return level;
    }
    public static void main(String[] args) {
        System.out.println(
                new P559_MaximumDepthofN_aryTree().maxDepth(
                        Node.stringToTreeNode(
                                "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14"
                        )
                )
        );
        System.out.println(
                new P559_MaximumDepthofN_aryTree().maxDepth_BFS(
                        Node.stringToTreeNode(
                                "1,null,3,2,4,null,5,6"
                        )
                )
        );

    }
}
