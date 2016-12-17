package com.hackersolve.leetcode.tree.easy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {

    //check if both the trees are same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        //check if the both the left nodes and the right nodes are same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
