package com.interviewbit.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achaudhary on 2/13/19.
 */
/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.
 */
public class CountAndSay {

    public static void main(String ...args) {
        CountAndSay countAndSay = new CountAndSay();
        String andSay = countAndSay.countAndSay(4);
        System.out.println(andSay);
    }

    public String countAndSay(int A) {
        String result = "1";
        for (int i = 0; i < A-1; i++) {
            result = countAndSay(result);
        }
        return result;
    }

    public String countAndSay(String num) {
        StringBuffer sb = new StringBuffer();
        String prevDigit = num.substring(0,1);
        String currentDigit;
        int count = 1;
        for (int i = 1; i < num.length(); i++) {
            currentDigit = num.substring(i,i+1);
            if(currentDigit.equals(prevDigit)) {
                count++;
            } else {
                sb.append(count).append(prevDigit);
                count = 1;
                prevDigit = currentDigit;
            }
        }
        sb.append(count).append(prevDigit);
        return sb.toString();
    }
}
