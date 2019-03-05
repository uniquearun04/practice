package com.interviewbit.list;

public class ReverseList2 {


    public static void main(String ...args) {

        ListNode head = new ListNode(1), node = head;
        node.next = new ListNode(2); node = node.next;
        node.next = new ListNode(3); node = node.next;
        node.next = new ListNode(4); node = node.next;
        node.next = new ListNode(5); node = node.next;


        ReverseList2 reverseList2 = new ReverseList2();
        ListNode listNode = reverseList2.reverseBetween(head, 2, 3);
        System.out.println(listNode);
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode head = new ListNode(0);
        ListNode curr = A, next = null, prev = head;
        head.next = A;

        int i = 0;
        while(i < B - 1) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode prev2 = null, head2 = null, tail = curr;
        while(i < C ) {
            next = curr.next;
            curr.next = prev2;
            prev2 = curr;
            curr = next;
            i++;
        }
        tail.next = curr;
        prev.next = prev2;


        return head.next;
    }

}
