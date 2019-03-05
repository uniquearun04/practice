package com.interviewbit.list;

import java.util.Stack;

public class PalindromeListV1 {

    public static void main(String ...args) {
        String a = "";
        Stack<String> stack = new Stack<>();
        while(!stack.empty()) {

        }
    }
    public int lPalin(ListNode A) {
        ListNode head = A, slow = A, fast = A, prev = null;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        prev.next = null;
        ListNode otherHalf = reverse(slow);
        ListNode firstHalf = A, secondHalf = otherHalf;
        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return 1;
    }

    public ListNode reverse(ListNode A) {
        ListNode curr = A, prev = null, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
