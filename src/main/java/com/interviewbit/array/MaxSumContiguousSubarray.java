package com.interviewbit.array;

import java.util.List;

public class MaxSumContiguousSubarray {
    /*
    Find the contiguous subarray within an array, A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous subarray.
Constraints:

1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:

Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6
     */

    public int maxSubArray(final List<Integer> A) {
        int maxSum = 0;
        int currSum = maxSum;
        for(int i = 0; i < A.size(); i++){
            currSum += A.get(i);
            if(currSum < 0) currSum = 0;

            if(currSum > maxSum) maxSum = currSum;
        }
        if(maxSum == 0) {
            maxSum = A.get(0);
            for(int i = 1; i < A.size(); i++) {
                if(A.get(i) > maxSum) maxSum = A.get(i);
            }
        }
        return maxSum;
    }
}
