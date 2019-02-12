package com.interviewbit.array;

import com.interviewbit.math.MaxCoPrime;

public class MaxSubset {

    public int[] maxset(int[] A) {
        int left = 0, right = 0;
        int leftMSA = 0, rightMSA = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                sum += A[i];
                right++;
            }
            if(A[i] < 0 || (i == A.length -1)) {
                if(sum > max) {
                    max = sum;
                    leftMSA = left;
                    rightMSA = right;
                }
                sum = 0;
                left = i+1;
                right = left;

            }
        }
        int result[] = new int[rightMSA - leftMSA];
        for(int i = 0; i < result.length; i++) {
            result[i] = A[leftMSA++];
        }

        return  result;
    }

    public static void main(String ...args) {
//        int A[] = {0,0,-1,0};
        int A[] = { 1967513926, 1540383426, -1303455736, -521595368 };
        MaxSubset maxSubset = new MaxSubset();
        int[] maxset = maxSubset.maxset(A);
        System.out.println(maxset);
    }
}
