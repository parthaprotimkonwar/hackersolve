package com.hackersolve.tree.easy.leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {

    //check if the tree is symmetric or not
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        return mirror(root.left, root.right);
    }

    //check if the below two nodes of a tree are symmetric or not
    boolean mirror(TreeNode firstTree, TreeNode secondTree) {

        if (firstTree == null && secondTree == null) {
            return true;
        } else if (firstTree == null || secondTree == null) {
            return false;
        }
        //the value should be same else not symmetrical
        if (firstTree.val != secondTree.val) {
            return false;
        }
        //comparision for symmetry
        //the left node of first tree and the right node of second tree
        //the right node of first tree and left node of second tree.
        return mirror(firstTree.left, secondTree.right) && mirror(firstTree.right, secondTree.left);
    }
}
