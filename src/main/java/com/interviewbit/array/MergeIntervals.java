package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    public static void main(String ...args) {

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        if(size == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        boolean inserted = false;
        for(int i=0;i<size;i++) {
            Interval iIter = intervals.get(i);
            if(iIter.start > newInterval.start) {
                intervals.add(i, newInterval);
                inserted = true;
                break;
            }
        }
        if(!inserted) {
            intervals.add(newInterval);
        }
        //merge and return
        return merge(intervals);
    }
    public ArrayList<Interval> merge(ArrayList<Interval> a) {
        Stack<Interval> st = new Stack<Interval>();
        st.push(a.get(0));
        for(int i=1;i<a.size();i++) {
            Interval top = st.peek();
            Interval iterInt = a.get(i);
            if(top.end>= iterInt.start) {
                Interval newInt = mergeIntervals(top, iterInt);
                st.pop();
                st.push(newInt);
            }
            else {
                st.push(iterInt);
            }
        }
        ArrayList<Interval> answer = new ArrayList<Interval>();
        while(!st.isEmpty()) {
            answer.add(st.pop());
        }
        Collections.reverse(answer);
        return answer;
    }
    public Interval mergeIntervals(Interval a ,Interval b) {
        int min = Math.min(a.start, b.start);
        int max = Math.max(a.end, b.end);
        return (new Interval(min, max));
    }

}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}