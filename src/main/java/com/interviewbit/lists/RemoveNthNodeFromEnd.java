package com.interviewbit.lists;

/**
 * Created by achaudhary on 2/28/19.
 */
public class RemoveNthNodeFromEnd {

    public static void main(String ...args) {

        ListNode node = new ListNode(4);

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        removeNthNodeFromEnd.removeNthFromEnd(node, 4);
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        return null;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
