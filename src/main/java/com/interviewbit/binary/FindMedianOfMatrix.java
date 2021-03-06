package com.interviewbit.binary;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
 */
public class FindMedianOfMatrix {

    public static void main(String ...args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5));
        matrix.add(list);
        list = new ArrayList<>(Arrays.asList(2, 6, 9));
        matrix.add(list);
        list = new ArrayList<>(Arrays.asList(3, 6, 9));
        matrix.add(list);

        FindMedianOfMatrix findMedianOfMatrix = new FindMedianOfMatrix();
        int median = findMedianOfMatrix.findMedianOfMatrix(matrix);
        System.out.println(median);
//        Collections.binarySearch(matrix,5);
    }

    public int findMedianOfMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        List<Integer> list;
        for (int i = 0; i < rows; i++) {
            list = matrix.get(i);
            if(min > list.get(0)) {
                min = list.get(0);
            }
            if(max < list.get(cols -1)) {
                max = list.get(cols -1);
            }
        }
        int mid = (min + max) / 2;
        int desired = (rows * cols + 1) / 2;
        int index = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            list = matrix.get(i);
            if(mid > list.get(cols -1)) {
                count += list.size();
                if(count == desired) {
                    return list.get(cols-1);
                } else if(count > desired) {
                    count -= list.size();
                    int diff = desired - count;
                    return list.get(diff -1);
                }
            } else {
                index = Collections.binarySearch(list, mid);
                if(index < 0) {
                    index = Math.abs(index) - 1;
                    if(mid < list.get(index)) {
                        index--;
                    }
                }
                count += index;
                if(count >= desired) {
                    return list.get(index);
                }
            }

        }
        return 0;
    }

    private int countSmaller(final List<Integer> A, int B) {
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

    private int countSmaller(ArrayList<ArrayList<Integer>> A, int B) {
        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            smaller += countSmaller(A.get(i), B);
        }
        return smaller;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (int) (left + ((long) right - left) / 2);
            int total = A.size() * A.get(0).size();
            int smaller = countSmaller(A, mid);
            if (smaller > total / 2)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
}
