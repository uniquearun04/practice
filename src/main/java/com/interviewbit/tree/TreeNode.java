package com.interviewbit.tree;

/**
 * Created by achaudhary on 3/21/19.
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        return ""+val;
    }
}