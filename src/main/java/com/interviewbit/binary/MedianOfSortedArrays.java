package com.interviewbit.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfSortedArrays {


    public static void main(String ...args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,6,8,10,13,15,27));
        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        int smaller = medianOfSortedArrays.countSmaller(list, 14);
        int smaller2 = medianOfSortedArrays.countSmaller(list, 15);
        System.out.println(smaller);
    }

    public int countSmaller(final List<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (B <= A.get(mid))
                right = mid - 1;
            else // if B > A.get(mid)
                left = mid + 1;
        }
        return left;
    }

    private double search(final List<Integer> a, final List<Integer> b, int count) {
//        int left = Integer.MIN_VALUE;
//        int right = Integer.MAX_VALUE;

        int left = Math.min(a.get(0), b.get(0));
        int right = Math.max(a.get(a.size()-1), b.get(b.size()-1));

        while (left <= right) {
            int mid = (int) (left + ((long) right - left) / 2);
            int smaller = countSmaller(a, mid) + countSmaller(b, mid);
            if (smaller > count)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int total = a.size() + b.size();
        if ((total & 1) == 1)
            return search(a, b, total / 2);
        else
            return (search(a, b, total / 2) + search(a, b, total / 2 - 1)) / 2;
    }
}
