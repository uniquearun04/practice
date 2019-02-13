package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumCloset {

    public static void main(String ...args) {

        int B = -1;
        ArrayList<Integer> A =  new ArrayList<>(Arrays.asList( -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 ));

        ThreeSumCloset threeSumCloset = new ThreeSumCloset();
//        int sumClosest = threeSumCloset.threeSumClosest(A, B);
//        System.out.println(sumClosest);

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList( 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 ));
        int sumClosest = threeSumCloset.threeSumClosest(A2, B);
        System.out.println(sumClosest);

    }

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int a = 0, b = 0, c = 0;
        int min = Integer.MAX_VALUE;
        int n = A.size();
        int diff = 0;
        for(int k = 0; k < n - 2; k++) {
            int sum = 0;
            int ct = B - A.get(k);
            int i, j;
            for(i = k+1, j = n-1; i < n - 1 && i < j && j < n;) {
                sum = A.get(i) + A.get(j);
                if(sum > ct) {
                    if(j > i + 1) {
                        j--;
                    } else {
                        break;
                    }
                } else if(sum < ct) {
                    if(i < j - 1) {
                        i++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            diff = ct - (A.get(i) + A.get(j));
            if(diff < min) {
                min = diff;
                a = A.get(k);
                b = A.get(i);
                c = A.get(j);
            }
            if(a + b + c == B) {
                break;
            }
        }
        System.out.println("a:= "+a+", b:= "+b+", c:= "+c);
        return a + b + c;
    }
}
