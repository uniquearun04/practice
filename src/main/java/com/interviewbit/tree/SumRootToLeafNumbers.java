package com.interviewbit.tree;

/**
 * Created by achaudhary on 3/29/19.
 */
public class SumRootToLeafNumbers {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
//        TreeNode tree = treeCreation.createTree("5 1 -1 2 -1 -1");
//        TreeNode tree = treeCreation.createTree("763 3 7 9 9 0 -1 -1 2 1 4 3 2 5 2 2 4 8 1 1 4 9 0 -1 8 3 5 2 5 -1 1 6 2 8 1 0 7 3 -1 7 -1 6 6 1 7 1 5 9 4 7 -1 7 -1 -1 -1 6 2 8 7 8 1 5 9 0 4 6 -1 -1 5 6 -1 2 1 8 2 5 5 -1 4 -1 1 9 1 4 3 5 7 4 -1 -1 0 6 7 5 -1 2 1 7 1 9 0 2 5 4 -1 -1 -1 -1 -1 8 2 2 -1 -1 -1 -1 -1 2 -1 3 9 4 8 8 6 4 7 2 5 7 1 -1 9 5 3 8 0 4 -1 -1 5 5 7 2 -1 -1 -1 8 0 4 4 5 5 7 -1 -1 5 6 3 -1 9 1 9 -1 8 -1 -1 9 -1 -1 8 -1 -1 -1 -1 -1 -1 -1 -1 -1 6 7 3 -1 1 8 -1 -1 1 8 -1 -1 -1 8 0 0 5 6 -1 -1 0 -1 9 -1 5 -1 6 6 -1 6 2 6 5 -1 -1 7 3 1 6 -1 7 6 -1 -1 6 -1 3 9 -1 -1 -1 0 -1 2 -1 0 -1 7 3 5 -1 8 2 0 6 8 7 3 9 0 1 0 -1 -1 -1 0 8 7 2 9 -1 6 6 6 -1 2 3 2 -1 -1 1 1 4 8 -1 2 0 -1 -1 -1 -1 -1 -1 1 3 6 -1 -1 -1 -1 5 4 1 7 7 -1 -1 -1 -1 -1 -1 0 8 0 -1 5 5 -1 7 3 -1 -1 1 -1 -1 -1 7 9 4 -1 4 -1 -1 -1 -1 -1 -1 -1 -1 -1 0 0 5 5 -1 -1 -1 2 6 8 1 -1 0 -1 6 -1 0 -1 -1 -1 -1 -1 -1 6 8 2 -1 4 2 -1 1 -1 -1 -1 2 1 0 2 7 8 -1 1 -1 -1 3 4 -1 -1 -1 -1 -1 5 -1 -1 8 2 -1 -1 -1 -1 2 8 -1 3 -1 8 6 3 -1 -1 -1 8 6 4 -1 -1 -1 -1 5 -1 -1 -1 -1 -1 -1 9 4 -1 -1 -1 -1 -1 -1 -1 2 2 7 3 9 -1 -1 9 -1 -1 -1 -1 6 -1 3 8 -1 -1 -1 -1 -1 -1 -1 3 -1 -1 -1 -1 -1 -1 -1 -1 4 -1 2 -1 -1 -1 -1 2 -1 -1 1 9 1 -1 -1 2 5 1 -1 -1 4 2 -1 -1 -1 7 6 3 8 2 8 -1 -1 0 -1 -1 3 1 -1 -1 5 -1 -1 9 -1 2 -1 0 -1 -1 -1 8 -1 -1 8 -1 -1 0 -1 0 -1 7 -1 -1 1 4 -1 9 5 3 -1 -1 -1 2 3 -1 -1 -1 6 7 -1 0 6 -1 -1 -1 -1 -1 5 -1 -1 -1 5 -1 -1 -1 -1 -1 4 8 3 -1 -1 9 5 -1 -1 -1 9 0 -1 -1 -1 -1 -1 -1 -1 -1 4 -1 7 -1 -1 -1 -1 -1 -1 -1 4 0 -1 8 1 -1 5 -1 0 -1 -1 -1 -1 -1 1 1 0 -1 8 6 -1 -1 -1 -1 -1 -1 3 5 9 4 1 9 -1 -1 -1 -1 -1 6 -1 -1 -1 -1 -1 -1 5 -1 -1 9 -1 -1 0 -1 -1 -1 -1 0 1 -1 3 -1 8 -1 1 -1 -1 -1 -1 2 5 6 2 6 -1 6 6 4 -1 9 -1 -1 -1 -1 5 8 -1 -1 -1 -1 -1 1 -1 -1 -1 -1 5 -1 7 -1 -1 -1 -1 9 4 2 1 8 -1 -1 -1 3 4 -1 -1 -1 -1 -1 -1 -1 5 -1 -1 -1 -1 -1 4 -1 9 -1 -1 -1 3 -1 -1 3 -1 -1 7 4 1 -1 -1 -1 -1 -1 -1 -1 -1 7 8 -1 9 0 -1 -1 -1 2 6 -1 8 -1 -1 -1 -1 -1 2 -1 4 2 -1 -1 6 8 -1 -1 -1 -1 -1 4 -1 -1");
        TreeNode tree = treeCreation.createTree("15 1 2 2 -1 -1 3 4 -1 -1 5 6 -1 -1 -1 -1");
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        int numbers = sumRootToLeafNumbers.sumNumbers(tree);
        System.out.println(numbers);
    }


    public int sumNumbers(TreeNode A) {
        if(A == null) return 0;
        return sumNumbers(A, 0);
    }

    public int sumNumbers(TreeNode A, int val) {
        if(A == null) return 0;
        TreeNode left = A.left;
        TreeNode right = A.right;
        if(left == null && right == null) {
            return val * 10 + A.val;
        }
        int newVal = (val * 10 + A.val) % 1003;
        return (sumNumbers(left, newVal) +  sumNumbers(right, newVal)) % 1003;
    }
}
