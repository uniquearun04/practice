package com.interviewbit.tree;

/**
 * Created by achaudhary on 3/22/19.
 */
/*
Given a binary tree, invert the binary tree and return it.
Look at the example for more details.

Example :
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4

 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(left);
        invertTree(right);
        return root;
    }
}
