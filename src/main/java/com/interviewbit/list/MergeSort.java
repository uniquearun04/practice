package com.interviewbit.list;

public class MergeSort {

    public static void main(String ...args) {

        ListNode head  = new ListNode(3), node = head;
        node.next =  new ListNode(2); node = node.next;
        node.next =  new ListNode(10); node = node.next;
        node.next =  new ListNode(8); node = node.next;
        node.next =  new ListNode(11); node = node.next;
        node.next =  new ListNode(12); node = node.next;
        node.next =  new ListNode(6); node = node.next;


        MergeSort mergeSort = new MergeSort();
        ListNode listNode = mergeSort.sortList(head);


        System.out.println(listNode);
    }



    public ListNode sortList(ListNode A) {
        return mergeSort(A);
    }

    private ListNode mergeSort(ListNode A) {
        ListNode slow = A, fast = A, prev = null;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        prev.next = null;
        if(slow == null) {
            return A;
        }

        if(A.next == null && slow.next == null) {
            return mergeSortedLists(A, slow);
        } else {
            ListNode leftSorted = A;
            ListNode rightSorted = slow;
            return mergeSortedLists(mergeSort(A), mergeSort(slow));
        }
    }


    private ListNode mergeSortedLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(Integer.MIN_VALUE), curr = head;
        while(A != null && B!= null) {
            if(A.val < B.val) {
                curr.next = new ListNode(A.val);
                curr = curr.next;
                A = A.next;
            } else if(A.val > B.val) {
                curr.next = new ListNode(B.val);
                curr = curr.next;
                B = B.next;
            } else {
                curr.next = new ListNode(A.val);
                curr = curr.next;
                A = A.next;
                curr.next = new ListNode(B.val);
                curr = curr.next;
                B = B.next;
            }
        }
        while(A != null) {
            curr.next = new ListNode(A.val);
            curr = curr.next;
            A = A.next;
        }
        while(B != null) {
            curr.next = new ListNode(B.val);
            curr = curr.next;
            B = B.next;
        }
        return head.next;
    }
}
