package com.LeetCode.Easy2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107_BinaryTreeLevelOrderTraversalIITest {
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

        BinaryTreeLevelOrderTraversalII temp = new BinaryTreeLevelOrderTraversalII();
        System.out.println(temp.levelOrderBottom(l1));


    }
}
class BinaryTreeLevelOrderTraversalII{
    List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode tnode = q.poll();
                if (tnode!=null) {
                    list.add(tnode.val);
                    if(tnode.left!=null) q.add(tnode.left);
                    if(tnode.right!=null) q.add(tnode.right);
                }
            }
            result.add(0,list);
        }
        return result;

    }
}
