package com.interviewbit.list;

/*
Partition List
Asked in:
Microsoft
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


A : [ 401 -> 143 -> 654 -> 910 -> 559 -> 582 -> 332 -> 26 -> 914 -> 611
-> 13 -> 160 -> 883 -> 212 -> 100 -> 341 -> 999 -> 436 -> 95 -> 969 -> 210
-> 181 -> 318 -> 330 -> 753 -> 422 -> 180 -> 271 -> 127 -> 299 -> 10 ]
B : 88
The expected output for this testcase is:
26 -> 13 -> 10 -> 401 -> 143 -> 654 -> 910 -> 559 -> 582 -> 332 -> 914 -> 611 -> 160 -> 883 -> 212 -> 100 -> 341 -> 999 -> 436 -> 95 -> 969 -> 210 -> 181 -> 318 -> 330 -> 753 -> 422 -> 180 -> 271 -> 127 -> 299
 */

public class PartitionList {


    public static void main(String ...args) {

        ListNode head = new ListNode(401), node = head;
        node.next = new ListNode(143); node = node.next;
        node.next = new ListNode(654); node = node.next;
        node.next = new ListNode(910); node = node.next;
        node.next = new ListNode(559); node = node.next;
        node.next = new ListNode(582); node = node.next;

        PartitionList partitionList = new PartitionList();
        ListNode partition = partitionList.partition(head, 400);
        System.out.println(partition);
    }

    public ListNode partition(ListNode A, int B) {
        ListNode lessNode = new ListNode(0), lessHead = lessNode;
        ListNode gteNode = new ListNode(0), gteHead = gteNode;
        ListNode curr = A;
        while(curr != null) {
            if(curr.val < B) {
                lessNode.next = curr;
                lessNode = lessNode.next;
            } else {
                gteNode.next = curr;
                gteNode = gteNode.next;
            }
            curr = curr.next;
        }
        lessNode.next = gteHead.next;
        return lessHead.next;
    }
}
