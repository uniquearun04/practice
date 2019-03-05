package com.interviewbit.list;

public class SwapPairwise {

    public static void main(String ...args) {

        ListNode head  = new ListNode(1), node = head;
        node.next =  new ListNode(2); node = node.next;
        node.next =  new ListNode(3); node = node.next;
        node.next =  new ListNode(4); node = node.next;
        node.next =  new ListNode(5); node = node.next;


        SwapPairwise swapPairwise = new SwapPairwise();
        ListNode listNode = swapPairwise.swapPairs(head);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode A) {
        ListNode head = new ListNode(0);
        ListNode prev = head, first = A, second = null, next = null;
        if(first != null) second = first.next;
        head.next = A;
        while(first != null && second != null) {
            next = second.next;
            first.next = next;
            second.next = first;
            prev.next = second;
            prev = first;
            first = next;
            second = first != null ? first.next : null;
        }
        return head.next;
    }


}
