package com.interviewbit.list;

public class PalindromeListV2 {

    public static void main(String ...args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next = new ListNode(1);


        PalindromeListV2 palindromeList = new PalindromeListV2();
        int lPalin = palindromeList.lPalin(listNode);
        System.out.println(lPalin);
    }


    public int lPalin(ListNode A) {

        ListNode slow = A, fast = A, head = null, next = null;

        while(slow != null && fast != null) {
            fast = fast.next;
            next = slow.next;

            if(fast != null) {
                fast = fast.next;
                slow.next = head;
                head = slow;
            }
            slow = next;
        }

        while(slow != null && head != null) {
            if(head.val != slow.val) {
                return 0;
            }
            slow = slow.next;
            head = head.next;
        }

        return 1;

    }

    private static class  ListNode {
        public int val;
        public ListNode next;
         ListNode(int x) { val = x; next = null; }
  }
}
