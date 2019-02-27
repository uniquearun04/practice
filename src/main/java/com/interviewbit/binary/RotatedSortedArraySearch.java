package com.interviewbit.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {


    public static void main(String ...args) {

        RotatedSortedArraySearch rotatedSortedArraySearch = new RotatedSortedArraySearch();
        int search = rotatedSortedArraySearch.search(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 0, 1, 2, 3)), 7);
        System.out.println(search);

        search = rotatedSortedArraySearch.search(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 0, 1, 2, 3, 4)), 7);
        System.out.println(search);

        search = rotatedSortedArraySearch.search(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, -1, 0, 1, 2, 3)), 0);
        System.out.println(search);

        search = rotatedSortedArraySearch.search(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 0, 1, 2, 3)), 1);
        System.out.println(search);

        search = rotatedSortedArraySearch.search(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 0, 1, 2, 3)), 2);
        System.out.println(search);

    }

    public int search(final List<Integer> a, int b) {
        int pivot = findPivot(a, 0, a.size() -1);
        int leftSearch = binarySearch(a, b, 0, pivot -1);
        if(leftSearch < 0) {
            return binarySearch(a, b, pivot, a.size() -1);
        }
        return leftSearch;
    }

    int findPivot(List<Integer> list, int lo, int hi) {
        if(lo == hi) return lo;
        int mid = (lo + hi) / 2;
        if(list.get(mid) > list.get(hi) ) {
            lo = mid + 1;
        } else if( list.get(mid) <= list.get(hi)) {
            hi = mid;
        }
        return findPivot(list, lo, hi);
    }

    int binarySearch(List<Integer> list, int a, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if(list.get(mid) > a ) {
            hi = mid - 1;
        } else if (list.get(mid) < a ) {
            lo = mid + 1;
        } else {
            return mid;
        }
        return binarySearch(list, a, lo, hi);
    }
}
