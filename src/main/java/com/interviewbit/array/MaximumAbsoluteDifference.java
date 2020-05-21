package com.interviewbit.array;

public class MaximumAbsoluteDifference {

    /*
    Maximum Absolute Difference
Asked in:
Amazon
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
     */

    /*
    Expanding
|A[i] - A[j]| + |i - j| gives four cases:

1. (A[i]+i) - (A[j]+j)
2. -(A[i]+i) + (A[j]+j)
3. (A[i]-i) - (A[j]-j)
4. -(A[i]-i) + (A[j]-j)

Cases 1 and 2 are equivalent
So are cases 3 and 4.

So lets consider cases 1 and 3.
For case 1, to maximize the output we should find maximun value of  (A[i]+i) and minimum value of (A[j]+j).
So this is equivalent of calculation min and max value of (A[i]+i).
So, in one iteration, we can find the min and max values.
After the iteration, we can find the diff as max - min.

Lets say sumDiff =  maxSum - minSum

Similary, we can find maxDiff and minDiff for expression (A[i]-i) and get value of maxDiff
Lets say its dubDiff = maxDiff - minDiff

So the answer would be

max(sumDiff, subDiff)
     */

    public int maxArr(int[] A) {
        int siz = A.length, res = 0;
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0;i<siz;i++){
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }
        return Math.max(max1 - min1, max2 - min2);
    }
}
