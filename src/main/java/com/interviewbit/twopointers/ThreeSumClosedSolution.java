package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by achaudhary on 2/12/19.
 */
public class ThreeSumClosedSolution {

    /*
    Lets sort the array.
When the array is sorted, try to fix the least integer by looping over it.
Lets say the least integer in the solution is arr[i].

Now we need to find a pair of integers j and k, such that arr[j] + arr[k] is closest to (target - arr[i]).
To do that, let us try the 2 pointer approach.
If we fix the two pointers at the end ( that is, i+1 and end of array ), we look at the sum.

If the sum is smaller than the sum we need to get to, we increase the first pointer.
If the sum is bigger, we decrease the end pointer to reduce the sum.
     */

    public static void main(String ...args) {

        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));


        ThreeSumClosedSolution threeSum = new ThreeSumClosedSolution();
        int sumClosest = threeSum.threeSumClosest(inputList, -1);
        System.out.println(sumClosest);
    }
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int low, high, mid;
        Collections.sort(A);
        int n = A.size();
        int res = A.get(0) + A.get(1) + A.get(2);

        if (n == 3) {
            return res;
        }

        int sum;

        for (low = 0; low < n - 2; low++) {
            mid = low + 1;
            high = n - 1;
            int num = B - A.get(low);

            while (mid < high) {

                sum = A.get(mid) + A.get(high);

                if (sum == num)
                    return B;
                else if (sum < num) {
                    mid++;
                } else {
                    high--;
                }

                int diff = Math.abs(sum - num);
                int otherDiff = Math.abs(res - B);

                if (diff < otherDiff)
                    res = sum + A.get(low);

            }
        }
        return res;
    }
}
