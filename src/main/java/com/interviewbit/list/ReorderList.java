package com.interviewbit.list;


/*
Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

90 -> 94 -> 25 -> 51 -> 45 -> 29 -> 55 ->
63 -> 48 -> 27 -> 72 -> 10 -> 36 -> 68 ->
16 -> 20 -> 31 -> 7 -> 95 -> 70 -> 89 ->
23 -> 22 -> 9 -> 74 -> 71 -> 35 -> 5 ->
80 -> 11 -> 49 -> 92 -> 69 -> 6 -> 37 ->
84 -> 78 -> 28 -> 43 -> 64 -> 96 -> 57 ->
83 -> 13 -> 73 -> 97 -> 75 -> 59 -> 53 ->
52 -> 19 -> 18 -> 98 -> 12 -> 81 -> 24 ->
15 -> 60 -> 79 -> 34 -> 1 -> 54 -> 93 ->
65 -> 44 -> 4 -> 87 -> 14 -> 67 -> 26 ->
30 -> 77 -> 58 -> 85 -> 33 -> 21 -> 46 ->
82 -> 76 -> 88 -> 66 -> 101 -> 61 -> 47 -> 8
 */
public class ReorderList {


    public static void main(String ...args) {
        ListNode startNode = new ListNode(1), node = startNode;

//        node.next = new ListNode(2); node = node.next;
//        node.next = new ListNode(3); node = node.next;
//        node.next = new ListNode(4); node = node.next;
//        node.next = new ListNode(5); node = node.next;

        ReorderList reorderList = new ReorderList();
        ListNode listNode = reorderList.reorderList(startNode);


        System.out.println(listNode);
    }

    public ListNode reorderList(ListNode A) {
        ListNode start = A, curr = A, prev = null;
        ListNode slow = A, fast = A, tmp1 = null, tmp2 = null;

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            System.out.println();
        }
        if(slow == null) {
            return A;
        }
        ListNode reverse = reverseList(slow);
        prev.next = null;
        while(start != null && reverse != null) {
            tmp1 = start.next;
            tmp2 = reverse.next;
            start.next = reverse;
            reverse.next = tmp1;
            start = tmp1;
            reverse = tmp2;

        }
        return A;
    }

    public ListNode reverseList(ListNode A) {
        if(A == null) return A;
        ListNode prev = null, curr = A, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }




    private static class  ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }

        public String toString() {
            return ""+ val;
        }
    }

}
