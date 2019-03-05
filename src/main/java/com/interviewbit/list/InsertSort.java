package com.interviewbit.list;

public class InsertSort {

    public static void main(String ...args) {
        ListNode startNode = new ListNode(1), node = startNode;

        node.next = new ListNode(40); node = node.next;
        node.next = new ListNode(34); node = node.next;
        node.next = new ListNode(80); node = node.next;
        node.next = new ListNode(54); node = node.next;

        InsertSort reorderList = new InsertSort();
        ListNode listNode = reorderList.insertionSortList(startNode);

        System.out.println(listNode);
    }


    public ListNode insertionSortList(ListNode A) {

        ListNode curr = A;
        SLL sll = new SLL();
        while(curr != null) {
            sll.addInsertSort(curr);
            curr = curr.next;
        }
        return sll.head;
    }


    private static class SLL {
        ListNode head = null, tail = null;

        private void addInsertSort(ListNode node) {
            ListNode tmp = new ListNode(node.val);
            if(head == null) {
                head = tmp;
                tail = head;
            } else if(tmp.val >= tail.val) {
                tail.next = tmp;
                tail = tail.next;
            } else if(tmp.val <= head.val){
                tmp.next = head;
                head = tmp;
            } else {
                ListNode  curr = head, prev = null;

                while(curr.val < tmp.val) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = tmp;
                tmp.next = curr;
                if(curr.next == null) {
                    tail = curr;
                    tail.next = null;
                }
            }
        }

    }
}
