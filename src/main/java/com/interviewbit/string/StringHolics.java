package com.interviewbit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by achaudhary on 2/13/19.
 */
/*
You are given an array A consisting of strings made up of the letters ‘a’ and ‘b’ only.
Each string goes through a number of operations, where:
<ul>
<li>At time 1, you circularly rotate each string by 1 letter.</li>
<li>At time 2, you circularly rotate the new rotated strings by 2 letters.</li>
<li>At time 3, you circularly rotate the new rotated strings by 3 letters.</li>
<li>At time i, you circularly rotate the new rotated strings by i % length(string) letters.</li>
</ul>
Eg: String is abaa
<ul>
<li>At time 1, string is baaa, as 1 letter is circularly rotated to the back</li>
<li>At time 2, string is aaba, as 2 letters of the string baaa is circularly rotated to the back</li>
<li>At time 3, string is aaab, as 3 letters of the string aaba is circularly rotated to the back</li>
<li>At time 4, string is again aaab, as 4 letters of the string aaab is circularly rotated to the back</li>
<li>At time 5, string is aaba, as 1 letters of the string aaab is circularly rotated to the back</li>
</ul>
After some units of time, a string becomes equal to it’s original self.
Once a string becomes equal to itself, it’s letters start to rotate from the first letter again (process resets).
So, if a string takes t time to get back to the original, at time t+1 one letter will be rotated and the string will
be it’s original self at 2t time.
You have to find the minimum time, where maximum number of strings are equal to their original self.
As this time can be very large, give the answer modulo 109+7.

Note: Your solution will run on multiple test cases so do clear global variables after using them.

Input:

A: Array of strings.
Output:

Minimum time, where maximum number of strings are equal to their original self.
Constraints:

1 <= size(A) <= 10^5
1 <= size of each string in A <= 10^5
Each string consists of only characters 'a' and 'b'
Summation of length of all strings <= 10^7
Example:

Input

A: [a,ababa,aba]
Output

4

String 'a' is it's original self at time 1, 2, 3 and 4.
String 'ababa' is it's original self only at time 4. (ababa => babaa => baaba => babaa => ababa)
String 'aba' is it's original self at time 2 and 4. (aba => baa => aba)

Hence, 3 strings are their original self at time 4.


 */
public class StringHolics {

    public static void main(String ...args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a","ababa","aba"));
        StringHolics stringHolics = new StringHolics();
        int solve = stringHolics.solve(list);
        System.out.println(solve);
    }

    public int solve(ArrayList<String> A) {
        int lcm = lcm(findMaxLenSubString(A.get(0)), findMaxLenSubString(A.get(1)));
        for(int i = 2; i < A.size(); i++) {
            lcm = lcm(lcm, findMaxLenSubString(A.get(i)));
        }
        int t = findTime(lcm);

        return t;
    }

    int findMaxLenSubString(String string) {
        int n = string.length();
        int [] lps = new int [n];
        int i = 1;
        int len = 0;

        lps[0] = 0;
        int max = 0;

        while(i < n) {
            if(string.charAt(i) == string.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
                max = Math.max(len, max);
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len -1];
                }
            }
        }

        return max >= 2 ? max : string.length();
    }

    int findTime(int lcm) {
        double t1 = (-1 + Math.sqrt(1.0 + 4 * 2 * lcm)) /2;
        return (int)t1;
    }

    int lcm(int a, int b) {
        return (int)((a * 1L * b) / gcd(a,b));
    }

    int gcd(int a, int b) {
        if(a == 0 ) {
            return b;
        }
        if(b == 0) {
            return a;
        }
        if(a == b) return a;

        if(a > b) return gcd(a-b, b);
        return gcd(a, b-a);
    }
}
