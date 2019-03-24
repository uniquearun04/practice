package com.interviewbit.tree;

/**
 * Created by achaudhary on 3/21/19.
 */
/*
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class BalancedBST {

    public static void main(String ...args) {
        //135 17 28 44 48 -1 12 58 7 6 23 64 20 37 45 26 36 18 27 -1 -1 46 54 -1 56 14 -1 -1 47 50 67 -1 2 35 -1 -1 60 41 -1 -1 10 24 -1 63 61 40 -1 -1 4 59 1 -1 29 -1 52 9 21 15 33 -1 -1 -1 55 -1 -1 -1 -1 11 38 32 -1 -1 -1 49 8 -1 51 57 13 22 62 -1 53 42 -1 25 -1 -1 43 34 -1 -1 -1 -1 -1 -1 31 39 -1 -1 -1 -1 -1 -1 -1 -1 3 -1 -1 -1 -1 -1 30 -1 -1 -1 -1 5 -1 66 -1 19 -1 -1 65 16 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

        TreeCreation treeCreation = new TreeCreation();
        TreeNode root = treeCreation.createTree("135 17 28 44 48 -1 12 58 7 6 23 64 20 37 45 26 36 18 27 -1 -1 46 54 -1 56 14 -1 -1 47 50 67 -1 2 35 -1 -1 60 41 -1 -1 10 24 -1 63 61 40 -1 -1 4 59 1 -1 29 -1 52 9 21 15 33 -1 -1 -1 55 -1 -1 -1 -1 11 38 32 -1 -1 -1 49 8 -1 51 57 13 22 62 -1 53 42 -1 25 -1 -1 43 34 -1 -1 -1 -1 -1 -1 31 39 -1 -1 -1 -1 -1 -1 -1 -1 3 -1 -1 -1 -1 -1 30 -1 -1 -1 -1 5 -1 66 -1 19 -1 -1 65 16 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1");

        BalancedBST balancedBST = new BalancedBST();
        int balanced = balancedBST.isBalanced(root);
        System.out.println(balanced);
    }

    public int isBalanced(TreeNode A) {
        if(A == null) return 1;
        TreeNode left = A.left;
        TreeNode right = A.right;
        if(left == null && right == null) return 1;
        if(left  == null) {
            int height = getHeight(right);
            if(height > 1) return 0;
            return 1;
        }
        if(right == null) {
            int height = getHeight(left);
            if(height > 1) return 0;
            return 1;
        }

        return (isBalanced(left) == 1) && (isBalanced(right) == 1) ? 1 : 0;
    }

    public int getHeight(TreeNode A) {
        if(A == null) {
            return 0;
        }
        TreeNode left = A.left;
        TreeNode right = A.right;

        return 1 + Math.max(getHeight(left), getHeight(right));
    }
}
