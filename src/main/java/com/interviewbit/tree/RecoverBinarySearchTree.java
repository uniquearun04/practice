package com.interviewbit.tree;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Created by achaudhary on 3/31/19.
 */
/*
Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Example :


Input :
         1
        / \
       2   3

Output :
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
 */
public class RecoverBinarySearchTree {
    public static void test() {
    int [] A = {2,3,4,1};

    sort(A);
    }
}
