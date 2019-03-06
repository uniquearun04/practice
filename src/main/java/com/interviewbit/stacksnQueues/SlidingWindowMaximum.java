package com.interviewbit.stacksnQueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String ...args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        ArrayList<Integer> arrayList = slidingWindowMaximum.slidingMaximum(Arrays.asList(1), 1);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> slidingMaximumV0(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<b; i++){
            while(!dq.isEmpty()&& a.get(dq.peekLast())<a.get(i))
                dq.pollLast();
            dq.offerLast(i);
        }
        for(int i = b ; i<a.size() ; i++){
            result.add(a.get(dq.peekFirst()));
            int currWindowStartIndex = i-b+1;
            while(!dq.isEmpty() && dq.peek()<currWindowStartIndex)
                dq.pollFirst();
            while(!dq.isEmpty()&& a.get(dq.peekLast())<a.get(i))
                dq.pollLast();
            dq.offerLast(i);
        }
        result.add(a.get(dq.peekFirst()));
        return result;
    }


    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {

        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            while(!deque.isEmpty() && a.get(i) > a.get(deque.peekLast())) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for (int i = b; i < a.size(); i++) {
            result.add(a.get(deque.peekFirst()));
            int currentWindowStartIndex = i - b + 1;
            while(!deque.isEmpty() && deque.peekFirst() < currentWindowStartIndex) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && a.get(i) > a.get(deque.peekLast())) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result.add(a.get(deque.peekFirst()));
        return result;
    }

}
