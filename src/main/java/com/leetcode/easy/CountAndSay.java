package com.leetcode.easy;

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class CountAndSay {

    public static void main(String ...args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }

    public String countAndSay(int n) {
        String num = "1";
        for (int i = 1; i < n ; i++) {
            num = lookAndSay(num);
        }
        return num;
    }

    private String lookAndSay(String num) {
        String prevDegit = num.substring(0,1);
        int count = 1;
        String curDigit;
        String outPutNUmber = "";

        for (int i = 1; i < num.length(); i++) {
            curDigit = num.substring(i,i+1);
            if(curDigit.equals(prevDegit)) {
                count++;
            } else {
                outPutNUmber += count + prevDegit;
                prevDegit = curDigit;
                count = 1;
            }
        }
        outPutNUmber += count + prevDegit;
        return outPutNUmber;
    }
}
