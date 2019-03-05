package com.interviewbit.list;

public class KReverseList {

    public static void main(String ...args) {

        ListNode head = new ListNode(6), node = head;
        node.next = new ListNode(10); node = node.next;
        node.next = new ListNode(0); node = node.next;
        node.next = new ListNode(3); node = node.next;
        node.next = new ListNode(4); node = node.next;
        node.next = new ListNode(8); node = node.next;

        KReverseList kReverseList = new KReverseList();
        ListNode listNode = kReverseList.reverseList(head, 3);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode A, int B) {

        int k = 0;
        ListNode head = A, curr = A;
        while (curr != null) {
            k++;
            curr = curr.next;
        }
        ListNode node = A;
        int i = 0;
        while (i < k) {
            node = reverseBetween(node, i + 1, i + B);
            i += B;
        }
        return node;

    }

    private ListNode reverseBetween(ListNode A, int B, int C) {

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
