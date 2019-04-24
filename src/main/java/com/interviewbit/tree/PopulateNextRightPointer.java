package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by achaudhary on 4/4/19.
 */
public class PopulateNextRightPointer {


    public void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> currentLevelQueue = new LinkedList<>();
        Queue<TreeLinkNode> nextLevelLevelQueue = new LinkedList<>();

        List<TreeLinkNode> currentLevelList = new ArrayList<>();

        currentLevelQueue.offer(root);
        while(!currentLevelQueue.isEmpty()) {
            TreeLinkNode current = currentLevelQueue.poll();
            currentLevelList.add(current);

            TreeLinkNode left = current.left;
            TreeLinkNode right = current.right;
            if(left != null) {
                nextLevelLevelQueue.offer(left);
            }
            if(right != null) {
                nextLevelLevelQueue.offer(right);
            }

            if(currentLevelQueue.isEmpty()) {
                if(currentLevelList.size() > 0) {
                    for(int i = 0; i < currentLevelList.size() - 1; i++) {
                        currentLevelList.get(i).next = currentLevelList.get(i+1);
                    }
                }
                currentLevelList = new ArrayList<>();
                currentLevelQueue = nextLevelLevelQueue;
                nextLevelLevelQueue = new LinkedList<>();
            }

        }
    }

        private static class TreeLinkNode {
            int val;
            TreeLinkNode left, right, next;
            TreeLinkNode(int x) { val = x; }
        }
}
