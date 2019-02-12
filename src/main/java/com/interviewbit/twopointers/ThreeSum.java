package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by achaudhary on 2/12/19.
 */
public class ThreeSum {

    public static void main(String ...args) {

        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));


        ThreeSum threeSum = new ThreeSum();
        int sumClosest = threeSum.threeSumClosest(inputList, -1);
        System.out.println(sumClosest);
    }

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int res =  A.get(0) + A.get(1) + A.get(2);
        if(n == 3) {
            return res;
        }
        int i, j, k;
        int sum;
        for(i = 0; i < n-2; i++) {
            int num = B - A.get(i);
            j = i+1;
            k = n-1;
            while(j < k) {
                sum = A.get(j) + A.get(k);
                if(num == sum) {
                    return B;
                } else if(sum < num) {
                    j++;
                } else {
                    k--;
                }
                int diff = Math.abs(sum - num);
                int otherDiff = Math.abs(res - B);
                if(diff < otherDiff) {
                    res = sum + A.get(i);
                }
            }
        }
        return res;
    }

}
