package com.interviewbit.list;

import java.util.HashSet;
import java.util.List;

public class DeleteDuplicates2 {


    /*
    1 -> 1 -> 1 ->
    2 -> 2 -> 2 -> 2 -> 2 -> 2 ->
     3 -> 3 ->
     5 -> 5 ->
     6 ->
     7 -> 7 -> 7 -> 7 -> 7 ->
     8 -> 8 ->
     9 ->
     10 ->
     11 -> 11 -> 11 -> 11 ->
     12 -> 12 -> 12 ->
     13 -> 13 -> 13 ->
     14 -> 14 -> 14 -> 14 -> 14 ->
     15 ->
     16 -> 16 ->
     17 -> 17 -> 17 ->
     18 -> 18 -> 18 -> 18 -> 18 -> 18 -> 18 ->
     19 -> 19 -> 19 -> 19 ->
     20 -> 20
     */
    public static void main(String ...args) {

        ListNode node = new ListNode(1);
        ListNode head = node;

        node.next = new ListNode(1); node = node.next;
        node.next = new ListNode(1); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(3); node = node.next;
        node.next = new ListNode(3); node = node.next;
        node.next = new ListNode(3); node = node.next;
        node.next = new ListNode(5); node = node.next;
        node.next = new ListNode(5); node = node.next;
        node.next = new ListNode(5); node = node.next;
        node.next = new ListNode(6); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(7); node = node.next;
        node.next = new ListNode(8); node = node.next;
        node.next = new ListNode(8); node = node.next;
        node.next = new ListNode(9); node = node.next;
        node.next = new ListNode(10); node = node.next;
        node.next = new ListNode(11); node = node.next;
        node.next = new ListNode(11); node = node.next;
        node.next = new ListNode(11); node = node.next;
        node.next = new ListNode(11); node = node.next;
        node.next = new ListNode(12); node = node.next;
        node.next = new ListNode(12); node = node.next;
        node.next = new ListNode(12); node = node.next;
        node.next = new ListNode(13); node = node.next;
        node.next = new ListNode(13); node = node.next;
        node.next = new ListNode(13); node = node.next;
        node.next = new ListNode(14); node = node.next;
        node.next = new ListNode(14); node = node.next;
        node.next = new ListNode(14); node = node.next;
        node.next = new ListNode(14); node = node.next;
        node.next = new ListNode(14); node = node.next;
        node.next = new ListNode(15); node = node.next;
        node.next = new ListNode(16); node = node.next;
        node.next = new ListNode(16); node = node.next;
        node.next = new ListNode(17); node = node.next;
        node.next = new ListNode(17); node = node.next;
        node.next = new ListNode(17); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(18); node = node.next;
        node.next = new ListNode(19); node = node.next;
        node.next = new ListNode(19); node = node.next;
        node.next = new ListNode(19); node = node.next;
        node.next = new ListNode(19); node = node.next;
        node.next = new ListNode(20); node = node.next;
        node.next = new ListNode(20); node = node.next;
        node.next = new ListNode(20); node = node.next;
        node.next = new ListNode(20); node = node.next;
        node.next = new ListNode(20); node = node.next;
        node.next = new ListNode(21); node = node.next;


        DeleteDuplicates2 deleteDuplicates2 = new DeleteDuplicates2();
        ListNode listNode = deleteDuplicates2.deleteDuplicates(head);
        System.out.println(listNode);
    }



    public ListNode deleteDuplicates(ListNode A) {
        ListNode prev = null, curr = null, next = null, head = null, tmp = null;
        head = new ListNode(0);
        head.next = A;
        prev = head;
        curr = head.next;
        next = curr.next;
        while(curr != null && next != null) {
            if(curr.val == next.val) {
                head.val = curr.val;
                prev.next = next.next;
                curr = prev.next;
                if(curr != null) {
                    next = curr.next;
                } else {
                    next = null;
                }
            } else if(head.val == curr.val) {
                curr = next;
                next = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
                next = curr.next;
            }

        }
        if(curr != null && head.val == curr.val) {
            prev.next = null;
        }

        return head.next;

    }



     private static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }

         public String toString() {
            return ""+val;
         }

     }

}
