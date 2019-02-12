package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = A.size();
        int n = B.size();
        List<Integer> smallerList;
        List<Integer> largerList;
        if(m <= n) {
            smallerList = A;
            largerList = B;
        } else {
            smallerList = B;
            largerList = A;
        }
        int index;

        for(int i = 0; i < smallerList.size(); i++) {
            index = Collections.binarySearch(largerList, 10);
            if(index >= 0) {
                result.add(largerList.get(index));
            }
        }

        return result;
    }
}
