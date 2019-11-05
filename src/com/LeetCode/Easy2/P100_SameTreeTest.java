package com.LeetCode.Easy2;

public class P100_SameTreeTest {
    public static void main(String[] args){
        TreeNode l1 = new TreeNode (1);
        TreeNode  a = new TreeNode (2);
        TreeNode  b = new TreeNode (4);
        l1.left = a;
        l1.right = b;
        TreeNode l2 = new TreeNode (1);
        a = new TreeNode (2);
        b = new TreeNode (4);
        l2.left = a;
        l2.right = b;
        SameTree temp = new SameTree();
        System.out.println(temp.isSameTree(l1,l2));
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class SameTree {
     boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
