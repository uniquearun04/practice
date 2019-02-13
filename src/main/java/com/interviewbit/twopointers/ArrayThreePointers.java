package com.interviewbit.twopointers;

import java.util.List;

/**
 * Created by achaudhary on 2/13/19.

 You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

 Find i, j, k such that :
 max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

 **abs(x) is absolute value of x and is implemented in the following manner : **

 if (x < 0) return -x;
 else return x;
 Example :

 Input :
 A : [1, 4, 10]
 B : [2, 15, 20]
 C : [10, 12]

 Output : 5
 With 10 from A, 15 from B and 10 from C.
 */

/*
Hint

The bruteforce solution is to pick one element each from a, b and c in a loop. O(N^3).
Obviously something better is required in this case .

A better approach might be to:

Iterate over all elements of a,
Binary search for element just smaller than or equal to in b and c, and note the difference.
Repeat the process for b and c. O(n log n).
*Note: As we move over the element in a, the elements in b and c that we are trying to find will also move forward. *
*
*

Windowing strategy works here.
Lets say the arrays are A,B and C.

Take 3 pointers X, Y and Z
Initialize them to point to the start of arrays A, B and C
Find min of X, Y and Z.
Compute max(X, Y, Z) - min(X, Y, Z).
If new result is less than current result, change it to the new result.
Increment the pointer of the array which contains the minimum.
Note that we increment the pointer of the array which has the minimum, because our goal is to decrease the difference.
Increasing the maximum pointer is definitely going to increase the difference.
Increase the second maximum pointer can potentially increase the difference ( however, it certainly will not decrease
the difference ).
 */
public class ArrayThreePointers {


    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        int m = A.size(), n = B.size(), o = C.size();
        int i = 0, j = 0, k = 0;
        int minMax = Integer.MAX_VALUE;
        while(i < m && j < n && k < o) {
            int a = A.get(i), b = B.get(j), c = C.get(k);
            int curDiff = Math.max(Math.abs(a-b), Math.max(Math.abs(b-c), Math.abs(c-a)));
            if(curDiff < minMax) {
                minMax = curDiff;
            }
            int min = Math.min(a, Math.min(b, c));
            if(min == a) {
                i++;
            } else if(min == b) {
                j++;
            } else {
                k++;
            }
        }

        return minMax;
    }

    public int minimizeV2(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int m=A.size();
        int n=B.size();
        int o=C.size();
        int i=0;
        int j=0;
        int k=0;
        int minMax=Integer.MAX_VALUE;
        while(i<m && j<n && k<o){
            int a=A.get(i);
            int b=B.get(j);
            int c=C.get(k);
            int curDiff=Math.max(Math.abs(a-b),Math.max(Math.abs(b-c),Math.abs(c-a)));
            if(curDiff<minMax){
                minMax=curDiff;
            }
            int min=Math.min(a,Math.min(b,c));
            if(min==a){
                i++;
            }else if(min==b){
                j++;
            }else{
                k++;
            }
        }
        return minMax;

    }
}
