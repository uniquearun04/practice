package com.interviewbit.tree;

/**
 * Created by achaudhary on 3/22/19.
 */
public class SymmetricTree {

    public int isSymmetric(TreeNode A) {
        TreeNode mirrorTree = mirrorTree(A);
        return isSymmetric(A, mirrorTree);
    }

    private int isSymmetric(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return 1;
        }
        if(A != null && B != null) {
            if(A.val == B.val) {
                return (isSymmetric(A.left, B.left) == 1 && isSymmetric(A.right, B.right) == 1) ? 1 : 0;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public TreeNode mirrorTree(TreeNode A) {
        if(A == null) return null;
        TreeNode B = new TreeNode(A.val);
        TreeNode left = A.left;
        TreeNode right = A.right;
        if(left != null) {
            B.right = new TreeNode(left.val);
        }
        if(right != null) {
            B.left = new TreeNode(right.val);
        }
        mirrorTree(B.left);
        mirrorTree(B.right);

        return B;
    }
}
