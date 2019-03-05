package com.interviewbit.list;

public class PalindromeList {

    public static void main(String ...args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);


        PalindromeList palindromeList = new PalindromeList();
        int lPalin = palindromeList.lPalin(listNode);
        System.out.println(lPalin);
    }


    public int lPalin(ListNode A) {
        int n = 0;
        ListNode head = A;
        ListNode currNode = A;
        while (currNode != null) {
            n++;
            currNode = currNode.next;
        }
        ListNode leftPart = null;
        ListNode rightPart = null;

        int mid = n / 2;
        int i = 0;

        ListNode prev = null;
        ListNode curr = null;
        ListNode next = null;
        curr = A;

        while( i < mid ) {
            if(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }
        }

        if(n % 2 == 1) {
            next = next.next;
        }
        leftPart = prev;
        rightPart = next;
        while(leftPart != null && rightPart != null) {
            if(leftPart.val != rightPart.val) return 0;
            leftPart = leftPart.next;
            rightPart = rightPart.next;
        }

        return 1;

    }

    private static class  ListNode {
        public int val;
        public ListNode next;
         ListNode(int x) { val = x; next = null; }
  }
}
