package com.interviewbit.string;

/**
 * Created by achaudhary on 2/14/19.
 */
/*
Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
A : "bbbbbbbbab"
B : "baba"
 */
public class StrStr {

    public static void main(String ...args) {

        StrStr strStr = new StrStr();
//        int len = strStr.strStr("bbbbbbbbab", "baba");
        int len = strStr.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa");
        System.out.println(len);
    }

    public int strStr(final String A, final String B) {
        if(A.trim().length() == 0 || B.trim().length() == 0) {
            return -1;
        }
        if(A.length() < B.length()) {
            return -1;
        }
        String needle = A;
        String haystack = B;

        int start = 0;
        int j = 0;

        int reachableLength = haystack.length() - needle.length() + 1;

        for (int i = 0; i < reachableLength; i++) {
            start = i;
            j = 0;
            while(start < haystack.length() && j < needle.length()) {
                if(haystack.charAt(start) == needle.charAt(j)) {
                    start++;
                    j++;
                } else {
                    break;
                }
            }
            if(start - i == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
