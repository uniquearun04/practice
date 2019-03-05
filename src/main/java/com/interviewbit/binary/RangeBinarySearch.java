package com.interviewbit.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeBinarySearch {


    public static void main(String ...args) {

        System.out.println(-1 % 20);

        RangeBinarySearch rangeBinarySearch = new RangeBinarySearch();
        ArrayList<Integer> arrayList = rangeBinarySearch.searchRange(new ArrayList<>(Arrays.asList(5, 7, 7, 8, 8, 10)), 8);
        System.out.println(arrayList);
        arrayList = rangeBinarySearch.searchRange(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)), 10);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int index = binarySearch(a, b, 0, a.size() -1);
        if( index < 0) return new ArrayList<>(Arrays.asList(-1,-1));
        int leftIndex = leftBinarySearch(a, b, 0, index);
        int rightIndex = rightBinarySearch(a, b, index, a.size() -1);
        return new ArrayList<>(Arrays.asList(leftIndex, rightIndex));
    }

    int leftBinarySearch(List<Integer> list, int a, int lo, int hi) {
        int index = binarySearch(list, a, lo, hi);
        if(lo >= hi || index < 0) return index;
        hi = index;
        int mid = (lo + hi) / 2;
        if( a == list.get(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }

        if(hi - lo == 1) {
            if(a == list.get(lo)) return lo;
            else return hi;
        }
        return leftBinarySearch(list, a, lo, hi);
    }

    int rightBinarySearch(List<Integer> list, int a, int lo, int hi) {
        int index = binarySearch(list, a, lo, hi);
        if(lo >= hi || index < 0) return index;
        lo = index;
        int mid = (lo  + hi) / 2;

        if( a == list.get(mid)) {
            lo = mid;
        } else {
            hi = mid - 1;
        }

        if(hi - lo == 1) {
            if(a == list.get(hi)) return hi;
            else return lo;
        }
        return rightBinarySearch(list, a, lo, hi);
    }


    int binarySearch(List<Integer> list, int a, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if(a > list.get(mid)) return binarySearch(list, a, mid + 1, hi);
        else if (a < list.get(mid)) return binarySearch(list, a, lo, mid -1);
        else return mid;
    }
}
