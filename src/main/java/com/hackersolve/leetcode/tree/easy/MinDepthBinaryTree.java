package com.hackersolve.leetcode.tree.easy;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinDepthBinaryTree {

    //traverse each nodes starting from the root
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        //This node has both right and left child nodes
        if(root.left != null && root.right !=null)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));

        //One or both of the child nodes are missing
        if(root.left == null)   //find depth of the right child
            return 1 + minDepth(root.right);
        else if(root.right == null)     //find depth of the left child
            return 1 + minDepth(root.left);
        else        //both the child nodes are not present
            return 1;
    }
}
